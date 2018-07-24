package com.daybreak.androidsample.sensor.items

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class RotationVectorActivity : SensorBaseActivity() {
    override fun getSensorType(): Int {
        return Sensor.TYPE_ROTATION_VECTOR
    }

    override fun onSensorChanged(event: SensorEvent?) {

    }
}
