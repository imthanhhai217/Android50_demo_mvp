package com.jaroid.android50_demo_mvp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnimationActivity extends AppCompatActivity {

    View vObject;
    RadioGroup rdListAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animation);

        initView();
    }

    private void initView() {
        vObject = findViewById(R.id.vObject);
        rdListAnimation = findViewById(R.id.rdListAnimation);

        rdListAnimation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbScale:
                        startScaleAnimation();
                        break;
                    case R.id.rbRotate:
                        startRotateAnimation();
                        break;
                    case R.id.rbSlideIn:
                        startSlideInAnimation();
                        break;
                    case R.id.rbSlideOut:
                        startSlideOutAnimation();
                        break;
                    case R.id.rbSlideDown:
                        startSlideDownAnimation();
                        break;
                    case R.id.rbFadeIn:
                        startFadeInAnimation();
                        break;
                    case R.id.rbFadeout:
                        startFadeOutAnimation();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void startFadeOutAnimation() {
        Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out_animation);
        translate.setFillAfter(true);
        vObject.startAnimation(translate);
    }

    private void startFadeInAnimation() {
        Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
//        translate.setFillAfter(true);
        vObject.startAnimation(translate);
    }

    private void startSlideOutAnimation() {
        Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_animation);
        translate.setFillAfter(true);
        vObject.startAnimation(translate);
    }

    private void startSlideInAnimation() {
        Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_animation);
        translate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(AnimationActivity.this, "SlideIn finish", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        vObject.startAnimation(translate);
    }

    private void startSlideDownAnimation() {
        Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down_animation);
        translate.setInterpolator(new AccelerateInterpolator());
        vObject.startAnimation(translate);
    }

    private void startRotateAnimation() {
        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_animation);
        vObject.startAnimation(rotate);
    }

    private void startScaleAnimation() {
        Animation scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_animation);
        scale.setFillAfter(true);
        scale.setInterpolator(new BounceInterpolator());
//        scale.setRepeatCount(Animation.INFINITE);
//        scale.setRepeatMode(Animation.REVERSE);
        vObject.startAnimation(scale);
    }
}
