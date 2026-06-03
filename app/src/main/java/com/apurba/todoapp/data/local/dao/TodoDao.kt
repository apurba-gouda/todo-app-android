package com.apurba.todoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.apurba.todoapp.data.local.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    
    @Query("SELECT * FROM todos ORDER BY created_at DESC")
    fun getAllTodos(): Flow<List<TodoEntity>>
    
    @Query("SELECT * FROM todos WHERE id = :id")
    suspend fun getTodoById(id: Long): TodoEntity?
    
    @Insert
    suspend fun insertTodo(todo: TodoEntity): Long
    
    @Update
    suspend fun updateTodo(todo: TodoEntity)
    
    @Delete
    suspend fun deleteTodo(todo: TodoEntity)
    
    @Query("DELETE FROM todos WHERE id = :id")
    suspend fun deleteTodoById(id: Long)
    
    @Query("SELECT * FROM todos WHERE is_completed = 0 ORDER BY created_at DESC")
    fun getActiveTodos(): Flow<List<TodoEntity>>
    
    @Query("SELECT * FROM todos WHERE is_completed = 1 ORDER BY created_at DESC")
    fun getCompletedTodos(): Flow<List<TodoEntity>>
}