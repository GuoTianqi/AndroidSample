package com.daybreak.androidsample.sensor.items

import android.annotation.TargetApi
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

@TargetApi(26)
class AccelerometerUnCalibratedActivity : SensorBaseActivity() {
    override fun getSensorType(): Int {
        return Sensor.TYPE_ACCELEROMETER_UNCALIBRATED
    }

    override fun onSensorChanged(event: SensorEvent?) {

    }
}
