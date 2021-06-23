package com.example.example

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.example.viewmodles.JoystickViewModel
import com.jackandphantom.joystickview.JoyStickView
import java.lang.Math.cos
import java.lang.Math.sin

class JoyStick(joyStickView: JoyStickView, viewModelJ: JoystickViewModel): AppCompatActivity() {
    var joyStick: JoyStickView = joyStickView
    var joystickViewModel: JoystickViewModel = viewModelJ

      fun setMove(angle: Double, strength: Float) {
            joystickViewModel.writeJoystick(

                (strength * cos(angle)).toFloat() / 100,
                (strength * sin(angle)).toFloat() / 100
            )
        }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val joyStick: JoyStickView = findViewById<JoyStickView>(R.id.joy)
        }

    }
