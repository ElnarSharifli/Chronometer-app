package com.example.chronomrter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import androidx.core.view.isVisible
import com.example.chronomrter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("ResourceType", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var stopTime : Long = 0

        binding.btnStart.setOnClickListener {
            binding.idChronometer.base = SystemClock.elapsedRealtime() + stopTime
            binding.idChronometer.start()
            binding.btnStart.visibility = View.GONE
            binding.btnPause.visibility = View.VISIBLE
            binding.ivStart.setImageDrawable(getDrawable(R.drawable.pause))
        }
        binding.btnPause.setOnClickListener {
            stopTime = binding.idChronometer.base-SystemClock.elapsedRealtime()
            binding.idChronometer.stop()
            binding.btnStart.visibility = View.VISIBLE
            binding.btnPause.visibility = View.GONE
            binding.ivStart.setImageDrawable(getDrawable(R.drawable.start))
        }
        binding.btnReset.setOnClickListener {
            binding.idChronometer.base = SystemClock.elapsedRealtime()
            binding.idChronometer.stop()
            stopTime = 0
            binding.btnStart.visibility = View.VISIBLE
            binding.btnPause.visibility = View.GONE
            binding.ivStart.setImageDrawable(getDrawable(R.drawable.start))
        }
    }
}