package com.example.mobiledevelopment3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DarkMode.newInstance] factory method to
 * create an instance of this fragment.
 */
class DarkMode : Fragment() {
    private var startTime: Long = 0
    private lateinit var timeTextView: TextView
    private var elapsedTimeSeconds: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dark_mode, container, false)

        val button1 = view.findViewById<Button>(R.id.button1)
        val button2 = view.findViewById<Button>(R.id.button2)
        val button3 = view.findViewById<Button>(R.id.button3)
        val button4 = view.findViewById<Button>(R.id.button4)
        timeTextView = view.findViewById<TextView>(R.id.timeTextView)
        button1.setOnClickListener { onButtonClicked() }
        button2.setOnClickListener { onButtonClicked() }
        button3.setOnClickListener { onButtonClicked() }
        button4.setOnClickListener { onButtonClicked() }

        val saveScoreButton = view.findViewById<Button>(R.id.saveScore)
        saveScoreButton.setOnClickListener {
            val intent = Intent(requireActivity(), ScoreBoard::class.java)
            intent.putExtra("darkModeScore", elapsedTimeSeconds)
            startActivity(intent)
        }

        return view
    }

    private fun startTimer() {
        startTime = System.currentTimeMillis()
    }

    private fun onButtonClicked() {
        if (startTime == 0L) {
            startTimer()
        } else {
            val currentTime = System.currentTimeMillis()
            val elapsedTimeMillis = currentTime - startTime
            elapsedTimeSeconds = elapsedTimeMillis / 1000.0

            // Display the elapsed time in seconds
            timeTextView.text = "Waktu: $elapsedTimeSeconds Detik"

            // Reset the start time
            startTime = 0
        }
    }
}