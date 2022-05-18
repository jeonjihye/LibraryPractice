package com.asianaidt.librarypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // 안드로이드 빌드도구
    // 1. setting.gradle : 라이브러리를 검색하는 레포지터리를 추가하고 싶을 때 만 편집
    // 2. build.gradle(Module 단위) : 일반적인 라이브러리 설치 / 기타 앱의 개발레벨 세팅
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupEvents()
        setValues()
    }

    fun setupEvents(){

        img_profile.setOnClickListener {
            val myIntent = Intent(this,ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }
    }
    fun setValues(){

    }
}