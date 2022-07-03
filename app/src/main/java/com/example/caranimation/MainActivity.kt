package com.example.caranimation

import android.animation.ObjectAnimator
import android.graphics.Path
import android.graphics.RectF
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.graphics.translationMatrix
import com.example.caranimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.car.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val path = Path().apply {
                    arcTo(0f, 500f, 500f, 1600f, 90f, -100f, true)
                    arcTo(0f, 0f, 900f, 1000f, 150f, 100f, true)
                    rLineTo(500f,0f)
                }
                val animator = ObjectAnimator.ofFloat(it, View.X, View.Y, path).apply {
                    duration = 4000
                    start()
                }
            } else {
                Toast.makeText(
                    this,
                    "Для воспроизведения анимации обновите версию Android",
                    LENGTH_SHORT
                ).show()
            }
        }
    }}