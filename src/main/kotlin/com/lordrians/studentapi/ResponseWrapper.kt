package com.lordrians.studentapi


import org.springframework.stereotype.Component

data class BaseResponse<T>(
    val status: Boolean,
    val message: String,
    val data: T
)
fun <T> tryCatch(
    codeBlock: () -> Result<T>
): Result<T> =
    try {
        codeBlock.invoke()
    } catch (e: Exception){
        Result.Error(e)
    }

sealed class Result<out T>{
    data class Success<S>(val data: S): Result<S>()
    data class Error(val error: Exception): Result<Nothing>()
}

val <T> Result<T>.data : T
    get() = when(this){
        is Result.Success -> this.data
        is Result.Error -> throw error
    }

abstract class Mapper<SourceType,ResultType>{
    abstract fun map(dataModel: SourceType): ResultType
}

@Component
class SuccessToResMapper : Mapper<Result<Any>,BaseResponse<Any>>(){
    override fun map(dataModel: Result<Any>): BaseResponse<Any> {
        return BaseResponse(
            status = true,
            message = "OK",
            data = dataModel.data
        )
    }
}

@Component
class ErrorToResMapper : Mapper<String?,BaseResponse<String>>(){
    override fun map(dataModel: String?): BaseResponse<String> {
        return BaseResponse(
            status = false,
            message = "NOT OK",
            data = dataModel ?: "Server Not OK"
        )
    }
}