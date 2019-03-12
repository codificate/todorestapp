package com.practice.todorest.controller

import com.practice.todorest.entity.Todo
import com.practice.todorest.repository.TodoRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@RestController @RequestMapping(value = ["/todo"]) @EnableWebMvc
class TodoController(val todoRepository: TodoRepository) {
    @GetMapping(value = ["/"])
    fun getAll() = todoRepository.findAll()

    @GetMapping(value = ["/{id}"])
    fun getOne(@PathVariable id: Long) = todoRepository.findById(id)

    @PostMapping(value = ["/"])
    fun addNew(@RequestBody text: String) = todoRepository.save(Todo(text = text))

    @DeleteMapping(value = ["/{id}"])
    fun removeOne(@PathVariable id: Long) = todoRepository.deleteById(id)

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody todo: Todo) : Todo {
        val todoUpdated: Todo = todoRepository.findById(id).orElseThrow { Exception("Doesn't exists this data in server") }
        todoUpdated.text = todo.text
        todoUpdated.done = todo.done
        return todoRepository.save(todoUpdated)
    }
}