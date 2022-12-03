package com.sameh.contentprovider

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sameh.contentprovider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSms()
    }

    private fun getSms() {
        val uri = Uri.parse("content://sms/inbox")
        val SMS_BODY = "body"
        val SMS_ADDRESS = "address"
        val projection = arrayOf(SMS_ADDRESS, SMS_BODY)
        val cursor = contentResolver.query(uri, projection, null, null, null)
        while (cursor!!.moveToNext()) {
            for (i in 0 until cursor.columnCount) {
                Log.d("myTAG", "getSms: $i - ${cursor.getColumnName(i)} - ${cursor.getString(i)}")
            }
        }
    }
}