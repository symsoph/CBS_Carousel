package com.example.funapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.OnScrollChangeListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.android.material.floatingactionbutton.FloatingActionButton

import okhttp3.Headers
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var petList: MutableList<String>
    lateinit var idList: MutableList<String>
    private lateinit var rvPets: RecyclerView
    private lateinit var rvPetsID: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //might need to specify val title
        rvPets = findViewById(R.id.pet_list)
        rvPetsID = findViewById(R.id.imageId_list)
        petList = mutableListOf()
        idList = mutableListOf()
        getAminalImagesURL()

        //Log.d("imageURL", " image URL set")


        val float_button = findViewById<FloatingActionButton>(R.id.refresh_float_button)


        float_button.setOnClickListener {
            getAminalImagesURL()
        }
    }

    private fun getNextImage(button: Button, imageView: ImageView) {
        button.setOnClickListener {


            //random between two apis
//            var choice = Random.nextInt(2)

        }
    }

    fun getAminalImagesURL() {
        val client = AsyncHttpClient()
        val urls = listOf(
            "https://shibe.online/api/shibes?count=20&urls=false&httpsUrls=false",
            "https://shibe.online/api/birds?count=20&urls=false&httpsUrls=false",
            "https://shibe.online/api/cats?count=20&urls=false&httpsUrls=false"
        )
        val types = listOf("shibes", "birds", "cats")
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