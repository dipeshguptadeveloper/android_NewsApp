package com.dkgtech.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkgtech.newsapp.adapters.RecyclerNewsAdapter
import com.dkgtech.newsapp.databinding.ActivityMainBinding
import com.dkgtech.newsapp.repo.NewsRepository

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiHelper = ApiHelper.create()

        val repo = NewsRepository(apiHelper)

        mainActivityViewModel = ViewModelProvider(
            this@MainActivity,
            MainActivityViewModelFactory(repo)
        )[MainActivityViewModel::class.java]

        with(binding) {

            rcViewNews.layoutManager = LinearLayoutManager(this@MainActivity)

            mainActivityViewModel.getNews("b379a8cb98154c3f871919ff5d66cad5", "apple")


            mainActivityViewModel.listPhotos.observe(this@MainActivity) { photos ->
                Log.d("main", "${photos}")
                rcViewNews.adapter = RecyclerNewsAdapter(this@MainActivity, photos)
            }

        }

    }
}