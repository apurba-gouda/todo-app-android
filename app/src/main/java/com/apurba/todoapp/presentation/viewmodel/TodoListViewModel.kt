package com.apurba.todoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apurba.todoapp.domain.model.Todo
import com.apurba.todoapp.domain.usecase.AddTodoUseCase
import com.apurba.todoapp.domain.usecase.DeleteTodoUseCase
import com.apurba.todoapp.domain.usecase.GetActiveTodosUseCase
import com.apurba.todoapp.domain.usecase.GetAllTodosUseCase
import com.apurba.todoapp.domain.usecase.GetCompletedTodosUseCase
import com.apurba.todoapp.domain.usecase.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val getAllTodosUseCase: GetAllTodosUseCase,
    private val getActiveTodosUseCase: GetActiveTodosUseCase,
    private val getCompletedTodosUseCase: GetCompletedTodosUseCase,
    private val addTodoUseCase: AddTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase
) : ViewModel() {
    
    private val _todoListState = MutableStateFlow<List<Todo>>(emptyList())
    val todoListState: StateFlow<List<Todo>> = _todoListState.asStateFlow()
    
    private val _filter = MutableStateFlow<TodoFilter>(TodoFilter.ALL)
    val filter: StateFlow<TodoFilter> = _filter.asStateFlow()
    
    init {
        loadTodos(TodoFilter.ALL)
    }
    
    fun loadTodos(filter: TodoFilter) {
        _filter.value = filter
        viewModelScope.launch {
            when (filter) {
                TodoFilter.ALL -> getAllTodosUseCase().collect { todos ->
                    _todoListState.value = todos
                }
                TodoFilter.ACTIVE -> getActiveTodosUseCase().collect { todos ->
                    _todoListState.value = todos
                }
                TodoFilter.COMPLETED -> getCompletedTodosUseCase().collect { todos ->
                    _todoListState.value = todos
                }
            }
        }
    }
    
    fun addTodo(title: String, description: String = "") {
        viewModelScope.launch {
            val todo = Todo(
                title = title,
                description = description
            )
            addTodoUseCase(todo)
        }
    }
    
    fun updateTodo(todo: Todo) {
        viewModelScope.launch {
            updateTodoUseCase(todo)
        }
    }
    
    fun toggleTodoCompletion(todo: Todo) {
        viewModelScope.launch {
            val updatedTodo = todo.copy(isCompleted = !todo.isCompleted)
            updateTodoUseCase(updatedTodo)
        }
    }
    
    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            deleteTodoUseCase(todo)
        }
    }
}

enum class TodoFilter {
    ALL, ACTIVE, COMPLETED
}