package com.example.mobiledevelopment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ScoreBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_board)

        val lightModescore = intent.getDoubleExtra("lightModeScore", 0.0)
        Log.d("Scoreboard", "Received score: $lightModescore")
        val darkModescore = intent.getDoubleExtra("darkModeScore", 0.0)
        Log.d("Scoreboard", "Received score: $darkModescore")

        val lightModeScoreTextView = findViewById<TextView>(R.id.lightModeScore)
        val darkModeScoreTextView = findViewById<TextView>(R.id.darkModeScore)

        lightModeScoreTextView.text = "Skor: $lightModescore Detik"
        darkModeScoreTextView.text = "Skor: $darkModescore Detik"
    }
}