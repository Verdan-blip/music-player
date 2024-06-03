package ru.kpfu.itis.bagaviev.feature.upload.domain.exceptions

const val NOT_DEFINED_TEXT_FORMAT = "Track %s not defined"

class TrackTitleNotDefinedException : Exception(String.format(NOT_DEFINED_TEXT_FORMAT, "track"))

class TrackGenreNotDefinedException() : Exception(String.format(NOT_DEFINED_TEXT_FORMAT, "genre"))

class TrackAudioFileNotDefinedException() : Exception(String.format(NOT_DEFINED_TEXT_FORMAT, "audioFile"))

class TrackCoverFileNotDefinedException() : Exception(String.format(NOT_DEFINED_TEXT_FORMAT, "coverFile"))