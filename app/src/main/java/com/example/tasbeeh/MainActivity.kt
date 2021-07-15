package com.example.tasbeeh

import Adapter.RvAdapter
import Cache.MySharedPreference
import Model.Remembrance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

    }

    override fun onStart() {
        super.onStart()

        MySharedPreference.init(this)
        val list = MySharedPreference.objectString

        list.add(Remembrance("Subhanallah", "سبحان الله", 0))
        list.add(Remembrance("Alhamdulillah", "الحمد لله", 0))
        list.add(Remembrance("Allah Akbar", "الله أكبر", 0))
        list.add(Remembrance("Astaghfirullah", "أستغفر الله", 0))
        list.add(Remembrance("Astaghfirullah wa atubu ilaih", "أستغفر الله وأتوب عليه", 0))

        rvAdapter = RvAdapter(this, list)

        rvAdapter.notifyDataSetChanged()
        recyclerMovies.adapter = rvAdapter

    }
}