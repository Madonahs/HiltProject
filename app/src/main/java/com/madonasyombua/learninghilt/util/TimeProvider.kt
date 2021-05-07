package com.madonasyombua.learninghilt.util

import java.util.*

class SystemTimeProvider: TimeProvider {
    override fun getCurrentDate() = Date()
    }

interface TimeProvider{
    fun getCurrentDate() : Date
}