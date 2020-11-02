package com.example.roomdb_review

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.roomdb_review.database.EmployeeDatabase
import java.util.concurrent.Executors

private const val DATABASE_NAME = "employee-database"

class Repositry private constructor(context : Context){
    private val database:EmployeeDatabase = Room.databaseBuilder(
        context.applicationContext,
        EmployeeDatabase::class.java,
        DATABASE_NAME).build()

    private val employeeDAO = database.employeeDAO()
    fun getEmployee():LiveData<List<Employee>> = employeeDAO.getEmployee()
    private val executor = Executors.newSingleThreadExecutor()

    companion object {
        private var INSTANCE: Repositry? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = Repositry(context)
            }
        }
        fun get(): Repositry {
            return INSTANCE
                ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }

    fun addEmp(employee: Employee)
    {
        executor.execute {
            employeeDAO.addEmp(employee)
        }
    }
}