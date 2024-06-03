package ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.exceptions.ForbiddenException
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.exceptions.HttpException
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.exceptions.UnauthorizedException
import javax.inject.Inject

class StatusCodeInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val response = chain.proceed(chain.request())

        response.apply {
            try {
                val jsonBody = JSONObject(peekBody(PEEK_BODY_BYTES_COUNT).string())

                if (!response.isSuccessful) {
                    val message = jsonBody.get(ERROR_RESPONSE_BODY_MESSAGE_KEY) as String

                    when (response.code) {
                        401 -> throw UnauthorizedException(message)
                        403 -> throw ForbiddenException(message)
                        else -> throw HttpException(message)
                    }
                }
            } catch (ex: JSONException) {
                return response
            }
        }

        return response
    }

    companion object {

        const val PEEK_BODY_BYTES_COUNT = 2048L
        const val ERROR_RESPONSE_BODY_MESSAGE_KEY = "message"
    }
}