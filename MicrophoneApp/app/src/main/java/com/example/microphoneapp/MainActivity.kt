package com.example.microphoneapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    
    private lateinit var audioManager: AudioManager
    private var isMicrophoneMode = false
    private lateinit var toggleButton: Button
    private lateinit var statusText: TextView
    
    private val PERMISSION_REQUEST_CODE = 200
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        
        toggleButton = findViewById(R.id.toggleButton)
        statusText = findViewById(R.id.statusText)
        
        requestPermissions()
        
        toggleButton.setOnClickListener {
            toggleAudioRoute()
        }
        
        updateUI()
    }
    
    private fun requestPermissions() {
        val permissions = arrayOf(
            Manifest.permission.MODIFY_AUDIO_SETTINGS,
            Manifest.permission.RECORD_AUDIO
        )
        
        val permissionsToRequest = mutableListOf<String>()
        
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                permissionsToRequest.add(permission)
            }
        }
        
        if (permissionsToRequest.isNotEmpty()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toTypedArray(),
                    PERMISSION_REQUEST_CODE
                )
            }
        }
    }
    
    private fun toggleAudioRoute() {
        isMicrophoneMode = !isMicrophoneMode
        
        if (isMicrophoneMode) {
            // Mikrofona yönlendir
            audioManager.setSpeakerphoneOn(false)
            audioManager.routing = AudioManager.ROUTE_EARPIECE
            audioManager.setMicrophoneMute(false)
        } else {
            // Normal hoparlöre dön
            audioManager.setSpeakerphoneOn(true)
            audioManager.routing = AudioManager.ROUTE_SPEAKER
            audioManager.setMicrophoneMute(false)
        }
        
        updateUI()
    }
    
    private fun updateUI() {
        if (isMicrophoneMode) {
            toggleButton.text = getString(R.string.button_normal)
            statusText.text = getString(R.string.status_mic)
            toggleButton.setBackgroundColor(getColor(R.color.mic_active))
        } else {
            toggleButton.text = getString(R.string.button_mic)
            statusText.text = getString(R.string.status_normal)
            toggleButton.setBackgroundColor(getColor(R.color.normal_active))
        }
    }
    
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // İzin verildi
                updateUI()
            }
        }
    }
}
