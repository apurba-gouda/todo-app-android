# Todo App Android

A modern Android to-do list application built with Jetpack Compose, Clean Architecture, Hilt Dependency Injection, and Room Database.

## Features

- ✅ Create, read, update, and delete todo items
- ✅ Mark todos as completed or incomplete
- ✅ Filter todos by status (All, Active, Completed)
- ✅ Local data persistence using Room Database
- ✅ Clean Architecture with separation of concerns
- ✅ Modern UI built with Jetpack Compose
- ✅ Type-safe navigation with Compose Navigation
- ✅ Dependency injection with Hilt
- ✅ Coroutines for asynchronous operations

## Architecture

The application follows Clean Architecture principles with three main layers:

### 1. **Presentation Layer** (`presentation/`)
- **Screens**: UI components using Jetpack Compose
- **ViewModels**: Business logic and state management
- **Navigation**: Route definitions and navigation setup

### 2. **Domain Layer** (`domain/`)
- **Models**: Business entities (Todo)
- **Repository Interfaces**: Abstract contracts
- **Use Cases**: Business logic orchestration

### 3. **Data Layer** (`data/`)
- **Entity Models**: Database models
- **DAOs**: Database access objects (Room)
- **Repository Implementation**: Concrete repository implementations
- **Local Database**: Room Database configuration

## Project Structure

```
app/src/main/
├── java/com/apurba/todoapp/
│   ├── data/
│   │   ├── local/
│   │   │   ├── dao/TodoDao.kt
│   │   │   ├── entity/TodoEntity.kt
│   │   │   └── TodoDatabase.kt
│   │   └── repository/TodoRepositoryImpl.kt
│   ├── domain/
│   │   ├── model/Todo.kt
│   │   ├── repository/TodoRepository.kt
│   │   └── usecase/
│   │       ├── GetAllTodosUseCase.kt
│   │       ├── GetActiveTodosUseCase.kt
│   │       ├── GetCompletedTodosUseCase.kt
│   │       ├── AddTodoUseCase.kt
│   │       ├── UpdateTodoUseCase.kt
│   │       └── DeleteTodoUseCase.kt
│   ├── presentation/
│   │   ├── screens/
│   │   │   ├── TodoListScreen.kt
│   │   │   └── TodoDetailScreen.kt
│   │   ├── viewmodel/
│   │   │   ├── TodoListViewModel.kt
│   │   │   └── TodoDetailViewModel.kt
│   │   └── navigation/TodoNavigation.kt
│   ├── di/
│   │   ├── DatabaseModule.kt
│   │   └── RepositoryModule.kt
│   ├── ui/theme/
│   │   ├── Theme.kt
│   │   ├── Color.kt
│   │   └── Type.kt
│   ├── MainActivity.kt
│   └── TodoApplication.kt
└── res/
```

## Dependencies

- **Androidx Core**: Core Android libraries
- **Jetpack Compose**: Modern UI toolkit
- **Jetpack Navigation**: Type-safe navigation
- **Room Database**: Local data persistence
- **Hilt**: Dependency injection framework
- **Kotlin Coroutines**: Asynchronous programming

## Setup Instructions

### Prerequisites
- Android Studio Giraffe or later
- Android SDK 24 or later
- Kotlin 1.9.10 or later

### Installation

1. Clone the repository
```bash
git clone https://github.com/apurba-gouda/todo-app-android.git
```

2. Open the project in Android Studio

3. Build the project
```bash
./gradlew build
```

4. Run on emulator or physical device
```bash
./gradlew installDebug
```

## How to Use

1. **Add a Todo**: Click the floating action button (+) to create a new todo
2. **View Todo Details**: Click on a todo item to view and edit its details
3. **Complete a Todo**: Check the checkbox next to a todo to mark it as complete
4. **Delete a Todo**: Click the delete icon to remove a todo
5. **Filter Todos**: Use the filter buttons to view All, Active, or Completed todos

## Key Technologies

- **Jetpack Compose**: Declarative UI framework
- **Room Database**: SQLite abstraction layer
- **Hilt**: Dependency injection with Dagger2
- **Kotlin Flow**: Reactive stream handling
- **Coroutines**: Asynchronous and non-blocking programming
- **Navigation Compose**: Type-safe navigation component

## Future Enhancements

- [ ] Add due dates and reminders
- [ ] Implement categories/tags
- [ ] Add dark theme support
- [ ] Sync with cloud backend
- [ ] Add search functionality
- [ ] Implement undo/redo functionality

## License

MIT License - See LICENSE file for details

## Author

Created by Apurba Gouda

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
