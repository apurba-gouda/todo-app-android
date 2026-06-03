package com.apurba.todoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.apurba.todoapp.presentation.screens.TodoDetailScreen
import com.apurba.todoapp.presentation.screens.TodoListScreen

@Composable
fun TodoNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Screen.TodoList.route
    ) {
        composable(Screen.TodoList.route) {
            TodoListScreen(
                onNavigateToDetail = { todoId ->
                    navController.navigate(Screen.TodoDetail.createRoute(todoId))
                }
            )
        }
        
        composable(
            route = Screen.TodoDetail.route,
            arguments = listOf(
                navArgument("todoId") {
                    type = NavType.LongType
                }
            )
        ) { backStackEntry ->
            val todoId = backStackEntry.arguments?.getLong("todoId") ?: 0L
            TodoDetailScreen(
                todoId = todoId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

sealed class Screen(val route: String) {
    object TodoList : Screen("todo_list")
    object TodoDetail : Screen("todo_detail/{todoId}") {
        fun createRoute(todoId: Long): String = "todo_detail/$todoId"
    }
}