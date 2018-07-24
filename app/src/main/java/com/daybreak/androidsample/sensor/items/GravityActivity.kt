package com.daybreak.androidsample.sensor.items

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import com.daybreak.androidsample.BaseToolBarActivity
import com.daybreak.androidsample.R

class GravityActivity : SensorBaseActivity() {
    override fun getSensorType(): Int {
        return Sensor.TYPE_GRAVITY
    }

    override fun onSensorChanged(event: SensorEvent?) {
    }
}
