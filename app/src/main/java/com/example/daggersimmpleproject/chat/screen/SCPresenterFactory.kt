package com.example.daggersimmpleproject.chat.screen

import dagger.assisted.AssistedFactory

// если AssistedFactory не прописываются в модулях, то за уничтожение этого объекта должна отвечать та сущность, которая создала объект?
@AssistedFactory
interface SCPresenterFactory {
    fun create(chatId: String): SCPresenter
}