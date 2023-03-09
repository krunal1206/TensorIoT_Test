package com.tensor.myapplication.helpers;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.tensor.myapplication.model.User;

public class PreferenceHelper {
    String TAG = "PreferenceHelper";
    private static PreferenceHelper me;
    private static String sharedPrefName;
    private static Context context;

    private PreferenceHelper() {
    }

    public static PreferenceHelper getInstance(Context cntx, PrefFiles sharedPrefFileName) {
        if (me == null) {
            me = new PreferenceHelper();
        }
        context = cntx;
        sharedPrefName = sharedPrefFileName.name();
        return me;
    }

    public void clearValues() {
        SharedPreferences prefs = context.getSharedPreferences(sharedPrefName, MODE_PRIVATE);
        prefs.getAll().clear();
    }

    public String getValue(String key) {
        SharedPreferences prefs = context.getSharedPreferences(sharedPrefName, MODE_PRIVATE);
        return prefs.getString(key, null);
    }

    public boolean getBooleanValue(String key) {
        SharedPreferences prefs = context.getSharedPreferences(sharedPrefName, MODE_PRIVATE);
        return prefs.getBoolean(key, false);
    }

    public PreferenceHelper add(String key, String value) {
        try {
            context.getSharedPreferences(sharedPrefName, MODE_PRIVATE).edit().putString(key, value).apply();
            return me;
        } catch (Exception ex) {
            Log.e(TAG, "PreferenceHelper: AddSharedPref: Exception: " + ex.getMessage(), ex);
            throw ex;
        }
    }

    public PreferenceHelper add(String key, boolean value) {
        try {
            context.getSharedPreferences(sharedPrefName, MODE_PRIVATE).edit().putBoolean(key, value).apply();
            return me;
        } catch (Exception e) {
            Log.e(TAG, "PreferenceHelper: AddSharedPref: Exception: " + e.getMessage(), e);
            throw e;
        }
    }

    public PreferenceHelper remove(String key) {
        try {
            context.getSharedPreferences(sharedPrefName, MODE_PRIVATE).edit().remove(key).apply();
            return me;
        } catch (Exception ex) {
            Log.e(TAG, "PreferenceHelper: AddSharedPref: Exception: " + ex.getMessage(), ex);
            throw ex;
        }
    }

    public void saveUser(User user) {
        if (user != null) {
            add(Keys.USERNAME, user.getUsername());
            add(Keys.EMAIL, user.getEmail());
            add(Keys.UID, user.getUid());
            add(Keys.PHOTO_URL, user.getPhoto());
            add(Keys.BIO, user.getBio());
        }
    }

    public User getUser() {
        User user = new User();
        user.setUid(getValue(Keys.UID));
        user.setUsername(getValue(Keys.USERNAME));
        user.setBio(getValue(Keys.BIO));
        user.setEmail(getValue(Keys.EMAIL));
        user.setPhoto(getValue(Keys.PHOTO_URL));
        return user;
    }

    public enum PrefFiles {
        USER_DETAILS_PREF
    }

    public final class Keys {
        public final static String USERNAME = "USERNAME";
        public final static String PHOTO_URL = "PHOTO_URL";
        public final static String EMAIL = "EMAIL";
        public final static String BIO = "BIO";
        public final static String UID = "UID";
    }

}
