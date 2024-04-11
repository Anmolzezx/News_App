package com.techmania.newsapp.mvvm

import androidx.lifecycle.LiveData
import com.techmania.newsapp.db.SavedArticle
import com.techmania.newsapp.Service.RetrofitInstance


class NewsRepo(val newsDao: NewsDao) {

    fun getAllSavedNews() : LiveData<List<SavedArticle>>{
        return newsDao.getAllNews()
    }

    fun getNewsByid() : LiveData<SavedArticle> {
        return newsDao.getNewsById()
    }

    suspend fun getBreakingNews(code: String, pageNumber: Int) = RetrofitInstance.api.getBreakingNews(code, pageNumber)

    suspend fun getCategoryNews(code: String) = RetrofitInstance.api.getByCategory(code)

    fun deleteAll(){
        newsDao.delteAll()
    }


    suspend fun insertNews(savedArticle: SavedArticle) {

        newsDao.insertNews(savedArticle)
    }
}