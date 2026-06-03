package com.apurba.todoapp.domain.repository

import com.apurba.todoapp.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getAllTodos(): Flow<List<Todo>>
    fun getActiveTodos(): Flow<List<Todo>>
    fun getCompletedTodos(): Flow<List<Todo>>
    suspend fun getTodoById(id: Long): Todo?
    suspend fun insertTodo(todo: Todo): Long
    suspend fun updateTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
    suspend fun deleteTodoById(id: Long)
}