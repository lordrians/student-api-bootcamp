package com.lordrians.studentapi.repository

import com.lordrians.studentapi.database.DatabaseComponent
import com.lordrians.studentapi.model.Student
import com.lordrians.studentapi.tryCatch
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import com.lordrians.studentapi.Result
import com.lordrians.studentapi.data
import org.litote.kmongo.*

@Repository
class StudentRepositoryImpl : StudentRepository{

    @Autowired
    lateinit var databaseComponent: DatabaseComponent


    private val studentCol = databaseComponent.studentDb.getCollection<Student>()


    override fun getAll(): Result<List<Student>> = tryCatch {
        val listStudent = studentCol.find().toList()
        Result.Success(listStudent)
    }

    override fun add(student: Student): Result<List<Student>> = tryCatch {
        studentCol.findOne(Student::name eq student.name).run {
            if (this != null){
                throw Exception("Data sudah ada")
            } else {
                studentCol.insertOne(student)
                Result.Success(getAll().data)
            }
        }
    }

    override fun getById(id: String): Result<Student> = tryCatch {
        studentCol.findOne(Student::id eq id).run {
            if (this == null){
                throw Exception("Data tidak ada")
            } else {
                Result.Success(this)
            }
        }
    }

    override fun remove(id: String): Result<List<Student>> = tryCatch {
        studentCol.deleteOneById(Student::id eq id).run {
            if (this.wasAcknowledged()){
                throw Exception("Data tidak ada")
            } else {
                Result.Success(getAll().data)
            }
        }
    }

    override fun update(student: Student): Result<Student> = tryCatch {
        studentCol.findOneAndReplace(
            Student::id eq student.id,
            student
        ).run {
            if (this == null){
                throw Exception("Data tidak ada")
            } else {
                Result.Success(this)
            }
        }
    }
}