package com.example.lab08.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.lab08.data.Task

@Dao
interface TaskDao {

    // Obtener todas las tareas
    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<Task>

    // Insertar una nueva tarea
    @Insert
    suspend fun insertTask(task: Task)

    // Marcar una tarea como completada o no completada
    @Update
    suspend fun updateTask(task: Task)

    // Eliminar una tarea específica
    @Delete
    suspend fun deleteTask(task: Task)

    // Eliminar todas las tareas
    @Query("DELETE FROM tasks")
    suspend fun deleteAllTasks()

    // Buscar tareas que coincidan con la descripción
    @Query("SELECT * FROM tasks WHERE description LIKE :query")
    suspend fun searchTasks(query: String): List<Task>
}
