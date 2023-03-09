package com.tensor.myapplication.ui.authentication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.tensor.myapplication.R;
import com.tensor.myapplication.databinding.FragmentLoginBinding;
import com.tensor.myapplication.listeners.LoginListener;
import com.tensor.myapplication.model.User;
import com.tensor.myapplication.ui.authentication.AcitivityAuthentication;
import com.tensor.myapplication.ui.authentication.AuthenticationViewModel;
import com.tensor.myapplication.ui.main.MainActivity;

public class FragmentLogin extends Fragment {
    String TAG = "FragmentLogin";
    FragmentLoginBinding binding;
    NavController navController;
    AuthenticationViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = ((AcitivityAuthentication) getActivity()).navController;
        viewModel = ((AcitivityAuthentication) getActivity()).viewModel;
        binding.btnSignUp.setOnClickListener(v -> {
            navController.navigate(R.id.action_register);
        });

        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.edtEmail.getText().toString();
            String password = binding.edtPassword.getText().toString();

            if (email.isEmpty()) {
                Toast.makeText(getActivity(), getResources().getText(R.string.please_enter_email), Toast.LENGTH_SHORT).show();
                return;
            } else if (password.isEmpty()) {
                Toast.makeText(getActivity(),getResources().getText(R.string.please_enter_password), Toast.LENGTH_SHORT).show();
                return;
            } else {
                showProgress();
                viewModel.LoginUser(email, password, new LoginListener() {
                    @Override
                    public void onSuccess(User user) {
                        hideProgress();
                        Intent intent=new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(String message) {
                        hideProgress();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    void showProgress() {
        if (binding.progressbar.getVisibility() == View.INVISIBLE) {
            binding.progressbar.setVisibility(View.VISIBLE);
            binding.btnLogin.setVisibility(View.INVISIBLE);
        }
    }

    void hideProgress() {
        if (binding.progressbar.getVisibility() == View.VISIBLE) {
            binding.progressbar.setVisibility(View.INVISIBLE);
            binding.btnLogin.setVisibility(View.VISIBLE);
        }
    }
}
