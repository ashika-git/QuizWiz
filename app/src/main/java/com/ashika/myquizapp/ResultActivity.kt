package com.ashika.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView = findViewById(R.id.tv_userName)
        val tvScore:TextView = findViewById(R.id.tv_score)
        val btnfinsh:Button = findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)

        //intent
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        val correctAns = intent.getIntExtra(Constants.CORRECT_ANS , 0)
        tvScore.text = "Your score is $correctAns out of $totalQuestions"

        btnfinsh.setOnClickListener{
            startActivity(Intent(this , MainActivity::class.java))
        }
    }
}