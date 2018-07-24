package com.daybreak.androidsample.sensor;


import com.daybreak.androidsample.BaseClassListActivity;
import com.daybreak.androidsample.sensor.items.AccelerometerActivity;
import com.daybreak.androidsample.sensor.items.AccelerometerUnCalibratedActivity;
import com.daybreak.androidsample.sensor.items.GravityActivity;
import com.daybreak.androidsample.sensor.items.LinearAccelerationActivity;
import com.daybreak.androidsample.sensor.items.RotationVectorActivity;

public class SensorActivity extends BaseClassListActivity {
    @Override
    public Class[] getClassList() {
        Class[] classes = new Class[] {
                GravityActivity.class,
                LinearAccelerationActivity.class,
                AccelerometerUnCalibratedActivity.class,
                RotationVectorActivity.class,
                AccelerometerActivity.class,
        };
        return classes;
    }
}
