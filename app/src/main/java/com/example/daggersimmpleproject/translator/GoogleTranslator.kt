package com.example.daggersimmpleproject.translator


class GoogleTranslator : Translator {

    override val name: String
        get() = "Google Translator"

    override fun translate(text: String): String {
        //TODO implement translation by Google services
        return "Translated text by Google Translator"
    }
}