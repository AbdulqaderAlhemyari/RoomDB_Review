package com.example.roomdb_review

import android.app.Application

class EmployeeApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Repositry.initialize(this)
    }
}