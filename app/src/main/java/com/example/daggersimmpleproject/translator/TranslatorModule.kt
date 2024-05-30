package com.example.daggersimmpleproject.translator

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Singleton


@Module
class TranslatorsModule {
    @Provides
    @IntoSet
    @Singleton
    fun provideGoogleTranslator(): Translator {
        return GoogleTranslator()
    }

    @Provides
    @IntoSet
    @Singleton
    fun provideLongmanTranslator(): Translator {
        return LongmanTranslator()
    }


}