package com.example.flickrbrowserappretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etPicId = findViewById<EditText>(R.id.etSearch)
        var searchBtn = findViewById<Button>(R.id.search)

        searchBtn.setOnClickListener {
            var item = etPicId.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("searchItem", item )
            startActivity(intent) }
    }
}