package com.example.daggersimmpleproject.translator

interface Translator {
    val name: String
    fun translate(text: String): String
}