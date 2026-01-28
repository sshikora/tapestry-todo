# Todo App

A simple To-Do application built with Apache Tapestry 5.8 and Tailwind CSS.

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Running Locally

1. Navigate to the project directory:
   ```bash
   cd todo-app
   ```

2. Run the application using Jetty:
   ```bash
   mvn jetty:run
   ```

3. Open your browser and go to:
   ```
   http://localhost:8080
   ```

## Features

- Add new todo items
- Mark todos as complete/incomplete
- Delete individual todos
- Clear all completed todos
- View statistics (total, completed, pending)

## Project Structure

```
todo-app/
├── pom.xml
├── src/main/
│   ├── java/com/example/todo/
│   │   ├── components/
│   │   │   └── Layout.java
│   │   ├── entities/
│   │   │   └── Todo.java
│   │   ├── pages/
│   │   │   └── Index.java
│   │   └── services/
│   │       ├── AppModule.java
│   │       ├── TodoService.java
│   │       └── TodoServiceImpl.java
│   ├── resources/com/example/todo/
│   │   ├── components/
│   │   │   └── Layout.tml
│   │   └── pages/
│   │       └── Index.tml
│   └── webapp/WEB-INF/
│       └── web.xml
```

## Technology Stack

- **Apache Tapestry 5.8**: Component-oriented Java web framework
- **Tailwind CSS**: Utility-first CSS framework (loaded via CDN)
- **Jetty**: Embedded servlet container for local development
- **Maven**: Build and dependency management
