package com.practice.todorest.repository

import com.practice.todorest.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long>