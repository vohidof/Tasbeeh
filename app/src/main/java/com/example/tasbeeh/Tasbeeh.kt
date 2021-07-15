package com.example.tasbeeh

import Cache.MySharedPreference
import Model.Remembrance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tasbeeh.*
import java.util.*

class Tasbeeh : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasbeeh)
        supportActionBar?.hide()


        MySharedPreference.init(this)

        val date = Calendar.getInstance().time


        val nameArabic = intent.getStringExtra("nameArabic")
        val nameLatin = intent.getStringExtra("nameLatin")

        val position = intent.getIntExtra("position", 0)

        txtArabicRemembrance.text = nameArabic.toString()
        txtLatineRemembrance.text = nameLatin.toString()
        txtDateLatine.text = date.toString()

        val list = MySharedPreference.objectString
        var default = 0

        imgPressCount.setOnClickListener {



            default += 1

            txtTotal.text = default.toString()

            when(default){
                33 -> Toast.makeText(this, "Mashaallah 33 zikr aytingiz", Toast.LENGTH_SHORT).show()
            }
        }


        btnclose.setOnClickListener {

            Toast.makeText(this, "Closed", Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}
