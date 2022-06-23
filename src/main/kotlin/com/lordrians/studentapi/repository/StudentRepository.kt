package com.lordrians.studentapi.repository

import com.lordrians.studentapi.model.Student
import com.lordrians.studentapi.Result

interface StudentRepository {
    fun getAll(): Result<List<Student>>
    fun add(student: Student): Result<List<Student>>
    fun getById(id: String): Result<Student>
    fun remove(id: String): Result<List<Student>>
    fun update(student: Student): Result<Student>
}