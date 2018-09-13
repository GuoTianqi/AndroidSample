package com.daybreak.androidsample.databinding;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import com.daybreak.androidsample.R;
import com.daybreak.androidsample.databinding.viewmodel.DataBindingViewModel;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingBinding
                binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        DataBindingViewModel viewModel = ViewModelProviders.of(this).get(DataBindingViewModel.class);
        viewModel.getDesc().setValue("Hello world!");
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }

}
