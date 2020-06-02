package com.example.newsassignment

import android.app.Application
import com.example.newsassignmen.ApiComponent
import com.example.newsassignmen.DaggerApiComponent
import com.example.newsassignment.di.ApiHelper
import com.example.newsassignment.di.AppModule
import com.example.newsassignment.di.DBModule


class Appcontroller : Application() {

    lateinit var mApiComponent: ApiComponent

    init {
        app = this
    }

    override fun onCreate() {
        super.onCreate()

        mApiComponent = DaggerApiComponent.builder()
            .appModule(AppModule(this))
            .apiHelper(ApiHelper())
            .dBModule(DBModule(this))
            .build()

    }

    companion object {
        lateinit var app: Appcontroller
    }
}
