package com.simtrayclub.batterycontrolbroadcastreceiver

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    //liste içerisinde yer almayan broadcast
    private lateinit var batteryControl: BatteryControl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batteryControl = BatteryControl()

    }


    override fun onResume() {
        super.onResume()

        val filter = IntentFilter()
        filter.addAction("android.intent.action.BATTERY_LOW")

        registerReceiver(batteryControl, filter)
    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(batteryControl)
    }

}