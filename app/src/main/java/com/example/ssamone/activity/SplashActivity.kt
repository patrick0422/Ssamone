package com.example.ssamone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.util.Log
import com.example.ssamone.db.question.QList
import com.example.ssamone.db.question.QuestionDatabase
import com.example.ssamone.R
import com.example.ssamone.db.user.User
import com.example.ssamone.db.user.UserDatabase
import java.lang.RuntimeException
import java.sql.Types.NULL
import java.time.LocalDate

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val qService = QuestionDatabase.getInstance(applicationContext)!!.dao()

        try {
            qService.addQuestions(QList.getQList())
            Log.d(TAG, "qService added")
        } catch (e: RuntimeException) { Log.d(TAG, "qService exception") }


        val uService = UserDatabase.getInstance(applicationContext)!!.dao()

        try {
            uService.addUser(User(1, "양태웅", "nope", 1))
            Log.d(TAG, "uService added")
        } catch (e: RuntimeException) { Log.d(TAG, "uService exception") }

        Thread.sleep(1000)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}