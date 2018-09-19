package com.example.bawn.myapplication

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(format: String): Date {

    val formatter = SimpleDateFormat(format)
    return formatter.parse(this)
}