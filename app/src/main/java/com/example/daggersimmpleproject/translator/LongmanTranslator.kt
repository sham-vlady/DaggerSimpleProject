package com.example.daggersimmpleproject.translator


class LongmanTranslator : Translator {

    override val name: String
        get() = "Longman Translator"

    override fun translate(text: String): String {
        //TODO implement translation by Google services
        return "Translated text by Longman Translator"
    }
}