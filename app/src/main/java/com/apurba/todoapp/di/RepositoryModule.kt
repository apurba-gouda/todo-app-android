package com.apurba.todoapp.di

import com.apurba.todoapp.data.repository.TodoRepositoryImpl
import com.apurba.todoapp.domain.repository.TodoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    
    @Singleton
    @Binds
    abstract fun bindTodoRepository(
        impl: TodoRepositoryImpl
    ): TodoRepository
}