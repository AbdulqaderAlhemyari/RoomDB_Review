package com.example.roomdb_review.database

import androidx.room.TypeConverter
import java.util.*

class EmployeeTypeConverters
{
    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }
}