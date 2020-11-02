package com.example.roomdb_review

import androidx.lifecycle.ViewModel

class EmployeeViewModel: ViewModel() {

    private val employeeRepositry = Repositry.get()

    val employeeListLiveData = employeeRepositry.getEmployee()

    fun addEmployee(emp:Employee)
    {
        employeeRepositry.addEmp(emp)
    }
}