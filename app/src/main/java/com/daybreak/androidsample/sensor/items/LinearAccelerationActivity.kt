package com.daybreak.androidsample.sensor.items

import android.hardware.Sensor
import android.hardware.SensorEvent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daybreak.androidsample.BaseToolBarActivity
import com.daybreak.androidsample.R

class LinearAccelerationActivity : SensorBaseActivity() {
    override fun onSensorChanged(event: SensorEvent?) {
    }

    override fun getSensorType(): Int {
        return Sensor.TYPE_LINEAR_ACCELERATION
    }
}
