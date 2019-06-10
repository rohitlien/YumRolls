package com.yummrolls.yumrolls.activities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.yummrolls.yumrolls.R;
import com.yummrolls.yumrolls.utils.UserPreferences;

public class SplashActivity extends AppCompatActivity {

    ProgressBar progressBar;
    LinearLayout mainzoomimg_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=null;
                if(!UserPreferences.getInstance().getLoginStatus()){
                    intent=new Intent(SplashActivity.this,LoginActivity.class);
                }else{

                }
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in,
                        R.anim.push_left_out);
                finish();
            }
        },2000);


    }

    private void animateLoginWindow() {
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(mainzoomimg_layout, "scaleX", 0.0f, 1);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(mainzoomimg_layout, "scaleY", 0.0f, 1);
        scaleDownX.setDuration(400);
        scaleDownY.setDuration(400);
        scaleDownX.setInterpolator(new DecelerateInterpolator());
        scaleDownY.setInterpolator(new DecelerateInterpolator());
        AnimatorSet scaleDown = new AnimatorSet();
        scaleDown.play(scaleDownX).with(scaleDownY);
        scaleDown.start();
        mainzoomimg_layout.setVisibility(View.VISIBLE);
    }
}
