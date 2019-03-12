package com.practice.todorest.entity

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Todo(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0, var text: String ="", var done: Boolean = false, val created_at: Instant = Instant.now())