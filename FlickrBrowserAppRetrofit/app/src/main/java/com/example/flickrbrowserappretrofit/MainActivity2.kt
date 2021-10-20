package com.example.flickrbrowserappretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    var picList = arrayListOf<FlickrPic>()
    var name = ""
    lateinit var rvMain: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportActionBar?.hide()
        rvMain = findViewById(R.id.rvMain)

//        rvMain.adapter =PicAdapter(this,picList)
//        rvMain.layoutManager = LinearLayoutManager(this)

        val intent = intent
        name = intent.getStringExtra("searchItem").toString().replace(" " , "&")

        getUser()
    }

    private fun getUser(){
        val apiInterface = APIClient.getClient()?.create(APIInterface::class.java)

        apiInterface?.getPhoto(name)?.enqueue(object : Callback<Photos> {
            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
               /// val resource = response.body()!!.photos.photo
                val list = response.body()!!.photos.photo
                rvMain.adapter = PicAdapter(list)
                rvMain.layoutManager = LinearLayoutManager(applicationContext)

                    rvMain.adapter?.notifyDataSetChanged()


            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                call.cancel()
            }
        })

    }
}

data class FlickrPic(val imageView: String, val title: String)