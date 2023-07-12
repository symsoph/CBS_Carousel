package com.example.funapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.funapi.ui.OpeningActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

import okhttp3.Headers

class MainActivity : AppCompatActivity() {

    private lateinit var petList: MutableList<String>
    lateinit var idList: MutableList<String>
    private lateinit var rvPets: RecyclerView
    private lateinit var rvPetsID: RecyclerView
    val openact_object = OpeningActivity()

    var dog: Int = 0
    var cat: Int = 0
    var bird: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPets = findViewById(R.id.pet_list)
        rvPetsID = findViewById(R.id.imageId_list)
        petList = mutableListOf()
        idList = mutableListOf()
        getAminalImagesURL()



        val float_button = findViewById<FloatingActionButton>(R.id.refresh_float_button)
       val back_button = findViewById<FloatingActionButton>(R.id.floatingBackButton)


        float_button.setOnClickListener {
            getAminalImagesURL()
        }
        back_button.setOnClickListener{
            val returnToStart = Intent(this, OpeningActivity::class.java)
            startActivity(returnToStart)
        }    }

    fun makefullscreen(imageView: ImageView) {
        imageView.adjustViewBounds(true)
    }


    fun getAminalImagesURL() {
        val client = AsyncHttpClient()
        val urls = mutableListOf<String>()
        val types = mutableListOf<String>()
        if (intent.getIntExtra("dog", 0) == 1){
            urls.add("https://shibe.online/api/shibes?count=20&urls=false&httpsUrls=false")
            types.add("shibes")
        }
        if (intent.getIntExtra("cat", 0) == 2){
            urls.add( "https://shibe.online/api/cats?count=20&urls=false&httpsUrls=false")
            types.add("cats")
        }
        if (intent.getIntExtra("bird", 0) == 3){
            urls.add("https://shibe.online/api/birds?count=20&urls=false&httpsUrls=false")
            types.add("birds")
        }

        for ((index, url) in urls.withIndex()) {
            val type = types[index]

            client[url, object : JsonHttpResponseHandler() {
                override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                    val imageArray = json.jsonArray
                    for (i in 0 until imageArray.length()) {
                        petList.add("https://cdn.shibe.online/$type/" + imageArray.getString(i) + ".jpg")
                    }

                    petList.shuffle()
                    val adapter = PetAdapter(petList)
                    rvPets.adapter = adapter
                    rvPets.layoutManager = LinearLayoutManager(this@MainActivity)
                    rvPets.addItemDecoration(
                        DividerItemDecoration(
                            this@MainActivity,
                            LinearLayoutManager.VERTICAL
                        )
                    )

                }

                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    errorResponse: String,
                    throwable: Throwable?
                ) {
                    Log.d("Dog Error", errorResponse)
                }
            }]
        }
    }
}

private fun ImageView.adjustViewBounds(b: Boolean) {

}
