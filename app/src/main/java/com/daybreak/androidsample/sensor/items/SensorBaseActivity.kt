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

abstract class SensorBaseActivity : BaseToolBarActivity() {
    private lateinit var sensorManager: SensorManager
    private lateinit var sensor: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout(R.layout.activity_gravity)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(getSensorType())
    }

    abstract fun getSensorType(): Int
    abstract fun onSensorChanged(event: SensorEvent?)

    open fun getTag(): String {
        return TAG
    }

    override fun onResume() {
        super.onResume()

        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        sensorManager.unregisterListener(sensorEventListener)

        super.onPause()
    }

    private val sensorEventListener = object: SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

        }

        override fun onSensorChanged(event: SensorEvent?) {
            Log.d(TAG, event?.values?.joinToString())

            this@SensorBaseActivity.onSensorChanged(event)
        }

    }

    companion object {
        val TAG = SensorBaseActivity::class.java.simpleName!!
    }
}
