package com.ahmet.notpad.di

import android.content.Context
import androidx.room.Room
import com.ahmet.notpad.data.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "user_database"
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideUserDao(database : UserDatabase) = database.userDao()
}