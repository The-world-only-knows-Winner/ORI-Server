package com.onlywin.ori.common.error

abstract class OriException(
    val errorProperty: ErrorProperty,
): RuntimeException()