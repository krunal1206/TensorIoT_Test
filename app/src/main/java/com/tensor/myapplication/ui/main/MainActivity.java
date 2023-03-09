package com.tensor.myapplication.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.tensor.myapplication.R;
import com.tensor.myapplication.databinding.ActivityMainBinding;
import com.tensor.myapplication.helpers.PreferenceHelper;
import com.tensor.myapplication.ui.authentication.AcitivityAuthentication;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    public MainViewModel viewModel;
    ActivityMainBinding binding;
    public NavController navController;
    NavGraph navGraph;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.main_nav_host_fragment);
        navController = navHostFragment.getNavController();
        navGraph = navController.getNavInflater().inflate(R.navigation.auth_nav);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout) {
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.signOut();

            viewModel.clearPrefs();

            Intent intent = new Intent(getApplicationContext(), AcitivityAuthentication.class);
            startActivity(intent);
            finish();
        }
        return true;
    }
}
