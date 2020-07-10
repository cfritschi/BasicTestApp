package com.example.basictestapp.storage

import java.util.*

data class ToDoItem(
    private val todoBody: String? = null,
    private val todoDescription: String,
    private val hasReminder: Boolean? = false,
    private val todoDate: Date? = null,
    private val todoColor : Int = 1677725,
    private val todoIdentifier: String = UUID.randomUUID().toString()
)