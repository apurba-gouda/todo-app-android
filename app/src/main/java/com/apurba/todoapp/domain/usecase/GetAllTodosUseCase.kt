package com.apurba.todoapp.domain.usecase

import com.apurba.todoapp.domain.model.Todo
import com.apurba.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTodosUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    operator fun invoke(): Flow<List<Todo>> {
        return repository.getAllTodos()
    }
}