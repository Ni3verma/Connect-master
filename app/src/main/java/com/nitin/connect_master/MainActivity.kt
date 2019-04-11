package com.nitin.connect_master

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)
        db = FirebaseDatabase.getInstance().reference.child("settings")

        vol_seekbar.setOnSeekBarChangeListener(volListener)
        brightness_seekbar.setOnSeekBarChangeListener(brightnessListener)
        play.setOnClickListener { view ->
            db.child("state").setValue("play")
        }
        pause.setOnClickListener { view ->
            db.child("state").setValue("pause")
        }
    }

    object volListener : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

        }

        override fun onStartTrackingTouch(p0: SeekBar?) {

        }

        override fun onStopTrackingTouch(p0: SeekBar?) {
            FirebaseDatabase.getInstance().reference.child("settings").child("volume").setValue(p0?.progress)
        }
    }

    object brightnessListener : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

        }

        override fun onStartTrackingTouch(p0: SeekBar?) {

        }

        override fun onStopTrackingTouch(p0: SeekBar?) {
            FirebaseDatabase.getInstance().reference.child("settings").child("brightness").setValue(p0?.progress)
        }
    }

}
