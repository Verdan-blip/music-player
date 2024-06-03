package ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.exceptions

import java.io.IOException

open class HttpException(message: String) : IOException(message)

class UnauthorizedException(message: String) : HttpException(message)

class ForbiddenException(message: String) : HttpException(message)