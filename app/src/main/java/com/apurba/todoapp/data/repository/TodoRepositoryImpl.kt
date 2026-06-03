package com.apurba.todoapp.data.repository

import com.apurba.todoapp.data.local.dao.TodoDao
import com.apurba.todoapp.data.local.entity.TodoEntity
import com.apurba.todoapp.domain.model.Todo
import com.apurba.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) : TodoRepository {
    
    override fun getAllTodos(): Flow<List<Todo>> {
        return todoDao.getAllTodos().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override fun getActiveTodos(): Flow<List<Todo>> {
        return todoDao.getActiveTodos().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override fun getCompletedTodos(): Flow<List<Todo>> {
        return todoDao.getCompletedTodos().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override suspend fun getTodoById(id: Long): Todo? {
        return todoDao.getTodoById(id)?.toDomain()
    }
    
    override suspend fun insertTodo(todo: Todo): Long {
        return todoDao.insertTodo(todo.toEntity())
    }
    
    override suspend fun updateTodo(todo: Todo) {
        todoDao.updateTodo(todo.toEntity())
    }
    
    override suspend fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo.toEntity())
    }
    
    override suspend fun deleteTodoById(id: Long) {
        todoDao.deleteTodoById(id)
    }
    
    private fun TodoEntity.toDomain(): Todo {
        return Todo(
            id = id,
            title = title,
            description = description,
            isCompleted = isCompleted,
            createdAt = createdAt,
            dueDate = dueDate
        )
    }
    
    private fun Todo.toEntity(): TodoEntity {
        return TodoEntity(
            id = id,
            title = title,
            description = description,
            isCompleted = isCompleted,
            createdAt = createdAt,
            dueDate = dueDate
        )
    }
}