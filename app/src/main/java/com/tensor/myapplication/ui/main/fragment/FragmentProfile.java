package com.tensor.myapplication.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.bumptech.glide.Glide;
import com.tensor.myapplication.R;
import com.tensor.myapplication.databinding.FragmentProfileBinding;
import com.tensor.myapplication.helpers.ForecastAdapter;
import com.tensor.myapplication.model.Forecastday;
import com.tensor.myapplication.ui.main.MainActivity;
import com.tensor.myapplication.ui.main.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentProfile extends Fragment {

    String TAG = "FragmentProfile";
    FragmentProfileBinding binding;
    NavController navController;
    MainViewModel viewModel;
    ForecastAdapter adapter;
    List<Forecastday> days = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        navController = ((MainActivity) getActivity()).navController;
        viewModel = ((MainActivity) getActivity()).viewModel;
        viewModel.init();


        viewModel.userLive.observe(getActivity(), s -> {
            binding.setUser(s);
            Glide.with(getContext()).load(s.getPhoto()).placeholder(R.drawable.ic_placeholder).into(binding.ivProfilePic);
        });

        binding.btnSearch.setOnClickListener(view -> {
            showProgress();
            if (binding.evSearch.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), "Please enter any city to search", Toast.LENGTH_SHORT).show();
                hideProgress();
                return;
            }

            fetchData(binding.evSearch.getText().toString());
        });

        return binding.getRoot();
    }

    void fetchData(String city) {
        viewModel.getWeatherData(city).observe(getActivity(), s -> {
            binding.tvCurrentCondtion.setText(s.getCurrent().getCondition().getText());
            binding.tvCurrentTemp.setText(s.getCurrent().getTempC().toString() + " C");
            binding.tvLocation.setText(s.getLocation().getName() + "," + s.getLocation().getRegion() + "," + s.getLocation().getCountry());
            days = s.getForecast().getForecastday();
            adapter = new ForecastAdapter(days, getActivity(), data -> {
                Bundle bundle = new Bundle();
                bundle.putString("temprature", data.getDay().getMaxtempC().toString() + " C");
                bundle.putString("condition", data.getDay().getCondition().getText());
                bundle.putString("humidity", data.getDay().getAvghumidity().toString());
                bundle.putString("wind_speed", data.getDay().getMaxwindKph().toString() + " kph");

                navController.navigate(R.id.action_forecast_details, bundle);
            });
            hideProgress();
            binding.rvItems.setAdapter(adapter);
        });
    }

    void showProgress() {
        if (binding.progressbar.getVisibility() == View.INVISIBLE) {
            binding.progressbar.setVisibility(View.VISIBLE);
            binding.btnSearch.setVisibility(View.INVISIBLE);
        }
    }

    void hideProgress() {
        if (binding.progressbar.getVisibility() == View.VISIBLE) {
            binding.progressbar.setVisibility(View.INVISIBLE);
            binding.btnSearch.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        showProgress();
        fetchData("");
    }
}
