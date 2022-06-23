package com.lordrians.studentapi.database

import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo
import org.springframework.stereotype.Component

@Component
class DatabaseComponent {
    companion object {
        private const val DB_URL = "mongodb+srv://aejbootcamp:AejBootcamp123@cluster0.olg9veq.mongodb.net/?retryWrites=true&w=majority"
    }

    private final val database: MongoClient = KMongo.createClient(DB_URL)

    val studentDb = database.getDatabase("student")
}