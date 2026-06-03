package com.apurba.todoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apurba.todoapp.domain.model.Todo
import com.apurba.todoapp.domain.repository.TodoRepository
import com.apurba.todoapp.domain.usecase.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetailViewModel @Inject constructor(
    private val repository: TodoRepository,
    private val updateTodoUseCase: UpdateTodoUseCase
) : ViewModel() {
    
    private val _todoState = MutableStateFlow<Todo?>(null)
    val todoState: StateFlow<Todo?> = _todoState.asStateFlow()
    
    fun loadTodo(id: Long) {
        viewModelScope.launch {
            val todo = repository.getTodoById(id)
            _todoState.value = todo
        }
    }
    
    fun updateTodo(todo: Todo) {
        viewModelScope.launch {
            updateTodoUseCase(todo)
        }
    }
}