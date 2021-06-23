package com.example.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.example.databinding.ActivityMainBinding
import com.example.example.viewmodles.NoteViewModel
import android.widget.SeekBar
import com.example.example.model.OurModel
import com.example.example.viewmodles.JoystickViewModel
import com.jackandphantom.joystickview.JoyStickView


class MainActivity : AppCompatActivity() {
    val model = OurModel()
    private lateinit var viewModel: NoteViewModel
    private lateinit var databinding: ActivityMainBinding
    private lateinit var viewModelJOYSTICK : JoystickViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        databinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel = NoteViewModel(model)

        viewModelJOYSTICK = JoystickViewModel(model)
        databinding.notesViewModel = viewModel
        databinding.lifecycleOwner = this

        val rudderSeek = findViewById<SeekBar>(R.id.rudder)
        val throttleSeek = findViewById<SeekBar>(R.id.throttle)
        rudderSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                viewModel.writeRudder(progress.toFloat()/100)
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })
        throttleSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {

                viewModel.writeThrottle(progress.toFloat()/100)

            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })


        var joyStick : JoyStick = JoyStick(findViewById<JoyStickView>(R.id.joy), viewModelJOYSTICK)

        val joyStickView = findViewById<JoyStickView>(R.id.joy)
        joyStickView.setOnMoveListener(object : JoyStickView.OnMoveListener {
            override fun onMove(angle: Double, strength: Float) {
                joyStick.setMove(angle, strength)
            }
        })
    }
}