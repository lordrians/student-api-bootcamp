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



    override fun getAll(): Result<List<Student>> = tryCatch {
        val listStudent = databaseComponent.studentDb.getCollection<Student>().find().toList()
        Result.Success(listStudent)
    }

    override fun add(student: Student): Result<List<Student>> = tryCatch {
        databaseComponent.studentDb.getCollection<Student>().findOne(Student::name eq student.name).run {
            if (this != null){
                throw Exception("Data sudah ada")
            } else {
                databaseComponent.studentDb.getCollection<Student>().insertOne(student)
                Result.Success(getAll().data)
            }
        }
    }

    override fun getById(id: String): Result<Student> = tryCatch {
        databaseComponent.studentDb.getCollection<Student>().findOne(Student::id eq id).run {
            if (this == null){
                throw Exception("Data tidak ada")
            } else {
                Result.Success(this)
            }
        }
    }

    override fun remove(id: String): Result<List<Student>> = tryCatch {
        databaseComponent.studentDb.getCollection<Student>().deleteOneById(Student::id eq id).run {
            if (this.wasAcknowledged()){
                throw Exception("Data tidak ada")
            } else {
                Result.Success(getAll().data)
            }
        }
    }

    override fun update(student: Student): Result<Student> = tryCatch {
        databaseComponent.studentDb.getCollection<Student>().findOneAndReplace(
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