package com.simtrayclub.batterycontrolbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BatteryControl :BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {

        Toast.makeText(p0, "your battery is running out :(", Toast.LENGTH_SHORT).show()

    }
}