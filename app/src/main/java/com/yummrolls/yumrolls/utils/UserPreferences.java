package com.yummrolls.yumrolls.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.Window;
import android.widget.LinearLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserPreferences {

    private static UserPreferences userPreferences;
    private SharedPreferences sharedPreferences;

    private UserPreferences() {
        sharedPreferences = AppController.getSharedPreferences("volt");
    }

    public static UserPreferences getInstance() {
        if (userPreferences == null) {
            userPreferences = new UserPreferences();
        }

        return userPreferences;
    }

    public int getCurrentSlideNumber() {
        return sharedPreferences.getInt("SlideCount", 0);
    }

    public void setCurrentSlideNumber(int number) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("SlideCount", number);
        editor.apply();
    }


    public void setScreeHeight(int number) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("SCHEIGHT", number);
        editor.apply();
    }


    public void setLoginstatus(boolean loginStatus) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("LOGIN_STATUS", loginStatus);
        editor.apply();
    }

    public boolean isSubscribed() {
        return sharedPreferences.getBoolean("isSubscribe", false);
    }


    public void setSubscribe(boolean subscribeUser) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isSubscribe", subscribeUser);
        editor.apply();
    }

    public boolean isUpdated() {
        return sharedPreferences.getBoolean("isUpdated", false);
    }


    public void setUpdated(boolean loginStatus) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isUpdated", loginStatus);
        editor.apply();
    }



    public boolean getLoginStatus() {
        return sharedPreferences.getBoolean("LOGIN_STATUS", false);
    }


    public void setProfileImageUrl(String photoUrl) {
        if (photoUrl != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("PROFILE_URL", photoUrl);
            editor.apply();
        }
    }

    public String getProfileImageUrl() {
        return sharedPreferences.getString("PROFILE_URL", "");
    }


    public void setUsername(String username) {
        if (username != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("USER_NAME", username);
            editor.apply();
        }
    }

    public String getuserName() {
        return sharedPreferences.getString("USER_NAME", "");
    }

    public String getUserLoginType() {
        return sharedPreferences.getString("LOGINTYPE_", "");
    }


    public void setUserLoginType(String loginType) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("LOGINTYPE_", loginType);
        editor.apply();
    }

    public boolean isAlreadyRated() {
        return sharedPreferences.getBoolean("ISRATED", false);
    }

    public void setBooleanIsAlreadyRated(boolean isRated) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("ISRATED", isRated);
        editor.apply();
    }

    public String getUserMobileNo() {
        return sharedPreferences.getString("mobile_number", "");
    }

    public void setUserMobile(String number) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("mobile_number", number);
        editor.apply();
    }
    public boolean isFacebookLogin() {
        return sharedPreferences.getBoolean("isFblogin", false);
    }

    public void setIsFacebookLogin(boolean isFblog) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isFblogin", isFblog);
        editor.apply();
    }

    public void clearSharedPreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }


}




