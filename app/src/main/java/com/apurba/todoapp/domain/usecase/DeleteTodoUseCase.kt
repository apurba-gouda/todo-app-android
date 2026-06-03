package com.apurba.todoapp.domain.usecase

import com.apurba.todoapp.domain.model.Todo
import com.apurba.todoapp.domain.repository.TodoRepository
import javax.inject.Inject

class DeleteTodoUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo) {
        return repository.deleteTodo(todo)
    }
}