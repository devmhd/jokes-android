package me.mehedee.jokes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import me.mehedee.jokes.R;
import me.mehedee.jokes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        MainActivityViewModel vm = new ViewModelProvider(this).get(MainActivityViewModel.class);
        binding.setVm(vm);

    }
}
