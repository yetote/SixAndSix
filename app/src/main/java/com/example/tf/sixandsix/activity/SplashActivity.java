package com.example.tf.sixandsix.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.tf.sixandsix.R;

public class SplashActivity extends AppCompatActivity {
    private LottieAnimationView animationView;
    private TextView tv1, tv2, tv3;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initViews();

        beginAnimation();
    }

    private void beginAnimation() {
        //开启lottie动画
        beginLottieAnimation();
    }

    private void beginLottieAnimation() {
        animationView.setAnimation("data.json");
        animationView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                tv1.setVisibility(View.VISIBLE);
                //tv1的动画
                ObjectAnimator oa = ObjectAnimator.ofFloat(tv1, "translationY", -500f, 0f);
                oa.setDuration(1000);
                oa.start();
                oa.setInterpolator(new BounceInterpolator());
                oa.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        tv2.setVisibility(View.VISIBLE);
                        //tv2的动画
                        ObjectAnimator oa2 = ObjectAnimator.ofFloat(tv2, "translationX", -500f, 0f);

                        oa2.setDuration(1000);
                        oa2.setInterpolator(new BounceInterpolator());
                        oa2.start();
                        oa2.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                tv3.setVisibility(View.VISIBLE);
                                //tv3的动画
                                ObjectAnimator oa3 = ObjectAnimator.ofInt(tv3, "textColor", 0xffff0000, 0xff00ff00);
                                oa3.setDuration(5000);
//                                oa3.setEvaluator(new ArgbEvaluator());
                                oa3.start();
                                oa3.addListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        btn.setVisibility(View.VISIBLE);
                                        //btn的动画
                                        ObjectAnimator oa4 = ObjectAnimator.ofFloat(btn, "alpha", 0f, 1f);
                                        oa4.setDuration(2000);
                                        oa4.start();
                                        oa4.setInterpolator(new LinearInterpolator());
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
        animationView.playAnimation();
    }

    private void initViews() {
        animationView = findViewById(R.id.splash_lottieView);
        tv1 = findViewById(R.id.slpash_firstText1);
        tv2 = findViewById(R.id.slpash_firstText2);
        tv3 = findViewById(R.id.slpash_firstText3);
        btn = findViewById(R.id.splash_btn);
        btn.setOnClickListener(view -> startActivity(new Intent(SplashActivity.this, MainActivity.class)));
    }
}
