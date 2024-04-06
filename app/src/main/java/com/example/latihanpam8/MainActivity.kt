package com.example.latihanpam8

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstaceState: Bundle?){
        super.onCreate(savedInstaceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(emptyList())
        recyclerView.adapter = adapter

        // mendapatkan data pengguna dari database Room
        Thread{
            val userdDao = MyApp.database.userDao()
            val users = userdDao.getAllUsers()
            runOnUiThread{
                adapter.setData(users)
            }
        }.start()
    }
}