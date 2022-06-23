package com.lordrians.studentapi.controller

import com.lordrians.studentapi.ErrorToResMapper
import com.lordrians.studentapi.SuccessToResMapper
import com.lordrians.studentapi.service.StudentService
import com.lordrians.studentapi.Result
import com.lordrians.studentapi.model.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/student")
class StudentController {

    @Autowired
    lateinit var studentService: StudentService

    @Autowired
    lateinit var successMapper: SuccessToResMapper

    @Autowired
    lateinit var errorMapper: ErrorToResMapper

    @GetMapping
    fun getAll() =
        when(val result = studentService.getAll()){
            is Result.Success -> successMapper.map(result)
            is Result.Error -> errorMapper.map(result.error.message)
        }

    @GetMapping("/{id}")
    fun getById(
        @PathVariable(value = "id") id : String
    ) =
        when(val result = studentService.getById(id)){
            is Result.Success -> successMapper.map(result)
            is Result.Error -> errorMapper.map(result.error.message)
        }

    @PostMapping()
    fun add(
        @RequestBody student: Student
    ) =
        when(val result = studentService.add(student)){
            is Result.Success -> successMapper.map(result)
            is Result.Error -> errorMapper.map(result.error.message)
        }

    @DeleteMapping("/{id}")
    fun remove(
        @PathVariable(value = "id") id: String
    ) =
        when(val result = studentService.remove(id)){
            is Result.Success -> successMapper.map(result)
            is Result.Error -> errorMapper.map(result.error.message)
        }

    @PutMapping()
    fun update(
        @RequestBody student: Student
    ) =
        when(val result = studentService.update(student)){
            is Result.Success -> successMapper.map(result)
            is Result.Error -> errorMapper.map(result.error.message)
        }
}