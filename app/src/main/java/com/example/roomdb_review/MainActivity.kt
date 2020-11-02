package com.example.roomdb_review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var empTextView : TextView
    private val employeeViewModel: EmployeeViewModel  by lazy {
        ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        empTextView=findViewById(R.id.tv)
        insertEmployee()
    }

    fun insertEmployee()
    {
        for (i in 0 until 5) {
            val employee = Employee()
            employee.empName="Ahmed"
            if(i%2==0)
            {
                employee.empSalary=5000
            }
            else{employee.empSalary=8000}

            employeeViewModel.addEmployee(employee)
        }
    }
    override fun onStart() {
        super.onStart()
        employeeViewModel.employeeListLiveData.observe(this,
            Observer {employee ->
                employee?.let {
                    Log.i("employeeListSize", "Got studentLiveData ${employee.size}")
                    printEmployeeList(employee)
                }
            })
    }

    fun printEmployeeList(empList :List<Employee>){
        empList.forEach { employee ->
            empTextView.append("${employee.empName} // ${employee.empSalary} \n ")
        }
    }


}
