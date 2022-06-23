package com.lordrians.studentapi.service

import com.lordrians.studentapi.Result
import com.lordrians.studentapi.model.Student
import com.lordrians.studentapi.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl: StudentService {

    @Autowired
    lateinit var repository: StudentRepository

    override fun getAll(): Result<List<Student>> =
        repository.getAll()

    override fun add(student: Student): Result<List<Student>> =
        repository.add(student)

    override fun getById(id: String): Result<Student> =
        repository.getById(id)

    override fun remove(id: String): Result<List<Student>> =
        repository.remove(id)

    override fun update(student: Student): Result<Student> =
        repository.update(student)
}