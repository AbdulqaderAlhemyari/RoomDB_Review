package com.example.roomdb_review

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Employee(@PrimaryKey val empID: UUID = UUID.randomUUID(),
                    var empName: String = "",
                    var empNo: Int = 0,
                    var empSalary: Int = 0)