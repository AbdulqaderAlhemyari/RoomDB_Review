package com.example.roomdb_review.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roomdb_review.Employee

@Database(entities = [ Employee::class ], version=1)
@TypeConverters(EmployeeTypeConverters::class)
abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun employeeDAO() : EmployeeDAO
}