package com.example.newsassignmen

import com.example.newsassignment.NewsApi
import com.example.newsassignment.NewsViewModel
import com.example.newsassignment.di.ApiHelper
import com.example.newsassignment.di.AppModule
import com.example.newsassignment.di.DBModule
import com.example.newsassignment.repository.NewsRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiHelper::class, AppModule::class, DBModule::class])
interface ApiComponent {

    val newsApi: NewsApi
    fun inject(repo: NewsRepository)
    fun inject(newsVM: NewsViewModel)
}
