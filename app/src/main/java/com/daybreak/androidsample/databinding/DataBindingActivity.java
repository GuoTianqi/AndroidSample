package com.daybreak.androidsample.databinding;

import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

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

        binding.changeTextBtn.setOnClickListener(v -> {
            binding.customView.setCustomText("Hello World2222");
        });
    }

}
