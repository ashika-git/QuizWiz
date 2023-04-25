package com.ashika.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{
    private var mCurrentPosition :Int = 1
    private var mQuestionList :ArrayList<Question>? = null
    private var mSelectedOption:Int = 0
    private var mUserName :String? = null
    private var mCorrectAnswer:Int = 0

    private var progressBar:ProgressBar?=null
    private var tvProgress :TextView? = null
    private var tvQuestion :TextView? = null
    private var ivImage :ImageView? =null

    private var tvOptionOne :TextView? = null
    private var tvOptionTwo :TextView? = null
    private var tvOptionThree :TextView? = null
    private var tvOptionFour :TextView? = null
    private var btnSubmit:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar =findViewById(R.id.progressBar)
        tvProgress =findViewById(R.id.tv_progress)
        tvQuestion= findViewById(R.id.tv_ques)
        ivImage =findViewById(R.id.iv_image)

        tvOptionOne=findViewById(R.id.tv_ops_one)
        tvOptionTwo = findViewById(R.id.tv_ops_two)
        tvOptionThree = findViewById(R.id.tv_ops_three)
        tvOptionFour = findViewById(R.id.tv_ops_four)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


    }

    private fun setQuestion(){
        defaultOptionView()
        //here we use current position which is nothing but the tv of progressbar 1/4
        val question: Question =
            mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text ="$mCurrentPosition"+ "/" +"${progressBar?.max}"
        tvQuestion?.text = question.question

        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text ="FINISH"
        }else{
            btnSubmit?.text ="SUBMIT"
        }
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_ops_one ->{
                tvOptionOne?.let {
                    selectedOptionView(it ,1)
                }
            }
            R.id.tv_ops_two ->{
                tvOptionTwo?.let {
                    selectedOptionView(it ,2)
                }
            }
            R.id.tv_ops_three ->{
                tvOptionThree?.let {
                    selectedOptionView(it ,3)
                }
            }
            R.id.tv_ops_four->{
                tvOptionFour?.let {
                    selectedOptionView(it ,4)
                }
            }
            R.id.btn_submit ->{
                if (mSelectedOption == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANS ,mCorrectAnswer)
                        intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList?.size)
                        startActivity(intent)
                        finish()
                    }
                    }
                }else{
                    val question=mQuestionList?.get(mCurrentPosition -1)
                    if (question!!.crtAns != mSelectedOption){
                        answerView(mSelectedOption ,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.crtAns ,R.drawable.correct_option_border_bg)

                    // here we add functionality to the submit button

                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit?.text ="FINISH"
                    }else{
                        btnSubmit?.text ="GO TO THE NEXT QUESTION"
                    }
                    mSelectedOption = 0

                }
            }
        }
    }
    private fun selectedOptionView(tv:TextView , selectedOptionNumber: Int){
        defaultOptionView()
        mSelectedOption = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface ,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this ,R.drawable.selected_option_norder_bg
        )
    }

    private fun defaultOptionView(){
        val option = ArrayList<TextView>()
        tvOptionOne?.let{
            option.add(0,it)
        }
        tvOptionTwo?.let{
            option.add(1,it)
        }
        tvOptionThree?.let{
            option.add(2,it)
        }
        tvOptionFour?.let{
            option.add(3,it)
        }

        for (options in option){
            options.setTextColor(Color.parseColor("#7A8089"))
            options.typeface = Typeface.DEFAULT
            options.background= ContextCompat.getDrawable(
                this ,R.drawable.default_option_border_bg
            )
        }
    }
    private fun answerView(answer:Int ,drawableView: Int){
        when(answer){
            1 ->{
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 ->{
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 ->{
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 ->{
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }

    }
}