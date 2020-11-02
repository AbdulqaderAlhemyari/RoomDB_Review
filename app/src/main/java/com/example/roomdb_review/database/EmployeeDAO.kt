package com.example.roomdb_review.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdb_review.Employee


@Dao
interface EmployeeDAO {

    @Query("Select * from Employee")
    fun getEmployee(): LiveData<List<Employee>>

    @Insert
    fun addEmp(emp : Employee)
}