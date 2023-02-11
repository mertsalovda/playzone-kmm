package com.example.playzonekmm.android

import GamesRepository
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import di.Inject.instance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val gamesRepository: GamesRepository = instance()
        CoroutineScope(context = Dispatchers.IO).launch {
            val games = gamesRepository.fetchAllGames()
            withContext(Dispatchers.Main) {
                val tv = findViewById<TextView>(R.id.text)
                tv.text = "Title: $games"
            }
        }
    }
}
