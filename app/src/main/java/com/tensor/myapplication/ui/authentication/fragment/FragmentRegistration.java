package com.tensor.myapplication.ui.authentication.fragment;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.tensor.myapplication.R;
import com.tensor.myapplication.databinding.FragmentRegisterBinding;
import com.tensor.myapplication.helpers.Utils;
import com.tensor.myapplication.listeners.CreateUserListener;
import com.tensor.myapplication.model.User;
import com.tensor.myapplication.ui.authentication.AcitivityAuthentication;
import com.tensor.myapplication.ui.authentication.AuthenticationViewModel;

import java.io.FileDescriptor;
import java.io.IOException;

public class FragmentRegistration extends Fragment {

    String TAG = "FragmentRegistration";


    FragmentRegisterBinding binding;
    NavController navController;
    AuthenticationViewModel viewModel;

    Uri image_uri;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = ((AcitivityAuthentication) getActivity()).navController;
        viewModel = ((AcitivityAuthentication) getActivity()).viewModel;

        binding.ivProfilePic.setOnClickListener(v -> {
            openCamera();
        });


        binding.btnSignUp.setOnClickListener(v -> {

            String email = binding.edtEmail.getText().toString();
            String username = binding.edtUsername.getText().toString();
            String bio = binding.edtBio.getText().toString();
            String password = binding.edtPassword.getText().toString();
            String confirm_password = binding.edtConfirmPassword.getText().toString();

            if (email.isEmpty()) {
                Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_email), Toast.LENGTH_SHORT).show();
                return;
            } else if (username.isEmpty()) {
                Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_username), Toast.LENGTH_SHORT).show();
                return;
            } else if (password.isEmpty() || confirm_password.isEmpty()) {
                Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_password_correctly), Toast.LENGTH_SHORT).show();
                return;
            } else if (!password.equals(confirm_password)) {
                Toast.makeText(getActivity(), getResources().getString(R.string.password_confirm_password_not_matching), Toast.LENGTH_SHORT).show();
                return;
            } else if (bio.isEmpty()) {
                Toast.makeText(getActivity(), getResources().getString(R.string.please_write_bio), Toast.LENGTH_SHORT).show();
                return;
            } else if (image_uri == null) {
                Toast.makeText(getActivity(), getResources().getString(R.string.please_capture_image), Toast.LENGTH_SHORT).show();
                return;
            } else {
                showProgress();
                viewModel.SignUpUser(getContext()
                        , email
                        , username
                        , Utils.uriToBitmap(image_uri, getActivity())
                        , bio
                        , password, new CreateUserListener() {
                            @Override
                            public void onSuccess(String uid) {
                                hideProgress();
                            }
                            @Override
                            public void onFailure(String message) {
                                hideProgress();
                                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    //Open Camera to set profile pic
    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        image_uri = getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        activityResultLauncher.launch(cameraIntent);
    }

    // Managing On Activity Result
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        binding.ivProfilePic.setImageURI(image_uri);
                    }
                }
            });


    void showProgress() {
        if (binding.progressbar.getVisibility() == View.INVISIBLE) {
            binding.progressbar.setVisibility(View.VISIBLE);
            binding.btnSignUp.setVisibility(View.INVISIBLE);
        }
    }

    void hideProgress() {
        if (binding.progressbar.getVisibility() == View.VISIBLE) {
            binding.progressbar.setVisibility(View.INVISIBLE);
            binding.btnSignUp.setVisibility(View.VISIBLE);
        }
    }
}
