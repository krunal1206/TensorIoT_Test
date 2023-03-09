package com.tensor.myapplication.network.repository;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.tensor.myapplication.helpers.PreferenceHelper;
import com.tensor.myapplication.listeners.CreateUserListener;
import com.tensor.myapplication.listeners.LoginListener;
import com.tensor.myapplication.listeners.PhotoStoreListener;
import com.tensor.myapplication.listeners.UserDetailsListener;
import com.tensor.myapplication.model.User;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

import javax.inject.Inject;

public class AuthRepository {

    private final FirebaseAuth mAuth;
    private FirebaseStorage storage;
    private final FirebaseDatabase mFirebaseDatabase;
    private final PreferenceHelper mPreferenceHelper;

    @Inject
    public AuthRepository(FirebaseAuth firebaseAuth, FirebaseStorage storage, FirebaseDatabase mFirebaseDatabase, PreferenceHelper helper) {
        this.mAuth = firebaseAuth;
        this.storage = storage;
        this.mFirebaseDatabase = mFirebaseDatabase;
        this.mPreferenceHelper = helper;
    }

    public void login(String email, String password, LoginListener listener) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        getUserDetails(mAuth.getCurrentUser().getUid(), new UserDetailsListener() {
                            @Override
                            public void onDetailsFetched(User user) {
                                mPreferenceHelper.saveUser(user);
                                listener.onSuccess(user);
                            }

                            @Override
                            public void onDetailFetchFailure(String message) {
                                listener.onFailure(message);
                            }
                        });
                    } else {
                        listener.onFailure(task.getException().getMessage());
                    }
                });

    }


    public void createUser(String email, String password, CreateUserListener listener) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        listener.onSuccess(mAuth.getCurrentUser().getUid());
                    } else {
                        listener.onFailure(Objects.requireNonNull(task.getException()).getMessage());
                    }
                });
    }

    public void getUserDetails(String uid, UserDetailsListener listener) {
        DatabaseReference databaseRef = mFirebaseDatabase.getReference("users");

        databaseRef.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (user != null) {
                    mPreferenceHelper.saveUser(user);
                }
                listener.onDetailsFetched(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onDetailFetchFailure(databaseError.getMessage());
            }
        });
    }


    public void storeUserPhoto(String uid, Bitmap photo, PhotoStoreListener listener) {
        storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        StorageReference profileRef = storageRef.child("profiles/" + uid + ".jpg");

        UploadTask uploadTask = profileRef.putBytes(data);

        uploadTask.addOnSuccessListener(taskSnapshot -> {

            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl();

            downloadUri.addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    if (uri != null) {
                        listener.onSuccess(downloadUri.getResult().toString());

                    } else {
                        listener.onFailure("Enable to make fetch Path");
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    listener.onFailure("Enable to make fetch Path");
                }
            });


        }).addOnFailureListener(e -> {
            listener.onFailure(e.getMessage());
        });
    }

    public void storeUserDetails(String uid, String username, String email, String password, String bio, String link, CreateUserListener listener) {
        DatabaseReference databaseRef = mFirebaseDatabase.getReference();

        User user = new User(uid, username, email, bio, link);

        databaseRef.child("users").child(uid).setValue(user).addOnSuccessListener(unused -> {
            mPreferenceHelper.saveUser(user);
            listener.onSuccess("User registerd successfully");
        }).addOnFailureListener(e -> {
            listener.onFailure(e.getMessage());
        });
    }

}
