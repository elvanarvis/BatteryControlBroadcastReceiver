package com.simtrayclub.batterycontrolbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {

        val b = p1?.extras

        if (b !== null){

            val pdusObj = b.get("pdus") as Array<Any>

            for(i in pdusObj.indices){

                val currentMessage:SmsMessage

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                    val format = b.getString("format")
                    currentMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray,format)

                }else{
                    currentMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray)
                }

                val telNo = currentMessage.displayOriginatingAddress
                val mesaj = currentMessage.displayMessageBody

                Toast.makeText(p0, "$telNo - $mesaj", Toast.LENGTH_SHORT).show()

            }
        }

    }
}