package com.lordrians.studentapi.service

import com.lordrians.studentapi.Result
import com.lordrians.studentapi.model.Student

interface StudentService {
    fun getAll(): Result<List<Student>>
    fun add(student: Student): Result<List<Student>>
    fun getById(id: String): Result<Student>
    fun remove(id: String): Result<List<Student>>
    fun update(student: Student): Result<Student>
}