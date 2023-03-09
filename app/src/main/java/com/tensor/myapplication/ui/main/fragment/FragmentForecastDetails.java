package com.tensor.myapplication.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.tensor.myapplication.databinding.FragmentForecastDetailsBinding;
import com.tensor.myapplication.databinding.FragmentProfileBinding;
import com.tensor.myapplication.ui.main.MainActivity;
import com.tensor.myapplication.ui.main.MainViewModel;

public class FragmentForecastDetails extends Fragment {

    String TAG = "FragmentForecastDetails";
    FragmentForecastDetailsBinding binding;
    NavController navController;
    MainViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentForecastDetailsBinding.inflate(inflater, container, false);
        navController = ((MainActivity) getActivity()).navController;
        viewModel = ((MainActivity) getActivity()).viewModel;
        init();
        binding.btnGoBack.setOnClickListener(v -> {
            navController.popBackStack();
        });
        return binding.getRoot();
    }

    void init() {
        String temp = getArguments().getString("temprature", "0 C");
        String condition = getArguments().getString("condition", "-");
        String wind = getArguments().getString("humidity", "0 kph");
        String humidity = getArguments().getString("wind_speed", "0.0");

        binding.tvTemprature.setText(temp);
        binding.tvCondition.setText(condition);
        binding.tvHumidity.setText(humidity);
        binding.tvWindSpeed.setText(wind);
    }
}
