package com.daybreak.androidsample.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.daybreak.androidsample.R;
import com.daybreak.androidsample.databinding.model.User;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.daybreak.androidsample.databinding.ActivityDataBindingBinding
                binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        User user = new User("Test", "User");
        binding.setUser(user);
    }

}
