package com.daybreak.androidsample.sensor.items

import android.hardware.Sensor
import android.hardware.SensorEvent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AccelerometerActivity : SensorBaseActivity() {
    override fun getSensorType(): Int {
        return Sensor.TYPE_ACCELEROMETER
    }

    override fun onSensorChanged(event: SensorEvent?) {

    }

}
