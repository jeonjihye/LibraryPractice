package com.asianaidt.librarypractice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

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


        btnCall.setOnClickListener{
//            Intent - CALL : 권한이 없어서 앱이 죽는다

            val permissionListener = object : PermissionListener {

//               1. 실제 Call
                override fun onPermissionGranted() {
//                    실제 Call Action
                    val myUri = Uri.parse("tel:01091133538")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(this@MainActivity,"권한이 없어서 통화가 불가능합니다.",Toast.LENGTH_SHORT).show()
                }
            }

//            2. 실제 권한요청
            TedPermission.create()
                .setPermissionListener( permissionListener)
                .setPermissions(android.Manifest.permission.CALL_PHONE)
                .check()

        }

        img_profile.setOnClickListener {
            val myIntent = Intent(this,ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }
    }
    fun setValues() {
        Glide.with(this)
            .load("https://img.insight.co.kr/static/2020/08/03/700/8vjgm707xl34n29lp4ut.jpg")
            .into(imgWeb)
    }
}