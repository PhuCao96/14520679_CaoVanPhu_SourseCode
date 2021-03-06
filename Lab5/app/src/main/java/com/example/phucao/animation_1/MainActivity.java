package com.example.phucao.animation_1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;
    private Button btnFadeInXml,btnFadeInCode,btnFadeOutXml,btnFadeOutCode,btnBlinkXml,btnBlinkCode,
            btnZoomInXml,btnZoomInCode,btnZoomOutXml,btnZoomOutCode,btnRotateXml,btnRotateCode,
            btnMoveXml,btnMoveCode,btnSlideUpXml,btnSlideUpCode,btnBounceXml,btnBounceCode,btnCombineXml,btnCombineCode;

    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }

    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
    }

    private void handleClickAnimationXml(Button btn, int animId) {
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this,animId);
        animation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }
    private Animation initFadeInAnimation(){
        AlphaAnimation animation = new AlphaAnimation(0f,1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return  animation;
    }
    private Animation initBlinkAnimation(){

        AlphaAnimation animation = new AlphaAnimation(0f,1f);
        animation.setDuration(300);
        animation.setRepeatMode(2);
        animation.setRepeatCount(3);
        animation.setAnimationListener(animationListener);
        return animation;

    }
    private Animation initBounceAnimation(){

        ScaleAnimation animation = new ScaleAnimation(1f,1f,0f,1f);
        animation.setDuration(500);
        animation.setInterpolator(new BounceInterpolator());
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;

    }
    private Animation initFadeOutAnimation(){

        AlphaAnimation animation = new AlphaAnimation(1f,0f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initMoveAnimation(){

        TranslateAnimation animation = new TranslateAnimation(0,700,0,0);
        animation.setInterpolator(new LinearInterpolator());
        animation.setFillAfter(true);
        animation.setDuration(800);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initRoateAnimation(){

        RotateAnimation animation = new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(600);
        animation.setRepeatMode(1);
        animation.setRepeatCount(2);
        animation.setAnimationListener(animationListener);
        return animation;

    }
    private Animation initSlideUpAnimation(){

        ScaleAnimation animation = new ScaleAnimation(1f,1f,1f,0f);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;

    }
    private Animation initZoomInAnimation(){

        ScaleAnimation animation = new ScaleAnimation(1f,3f,1f,3f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initZoomOutAnimation(){
        ScaleAnimation animation = new ScaleAnimation(1f,0.5f,1f,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initCombineAnimation(){
        ScaleAnimation animation1 = new ScaleAnimation(1f,3f,1f,3f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation1.setDuration(4000);
        animation1.setFillAfter(true);

        RotateAnimation animation2 = new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation2.setDuration(500);
        animation2.setRepeatMode(1);
        animation2.setRepeatCount(2);

        AnimationSet animationSet = new AnimationSet(true);

        animationSet.addAnimation(animation1);
        animationSet.addAnimation(animation2);
        animationSet.setAnimationListener(animationListener);
        return animationSet;

    }

    private void handleClickAnimationCode(Button btn, final Animation animation) {

        // Handle onclickListenner to start animation
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsByIds();
        initVariables();

        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNewActivity = new Intent(MainActivity.this,NewActivity.class);
                startActivity(iNewActivity);
                overridePendingTransition(R.anim.anim_fade_in,R.anim.anim_from_left_out);
            }
        });

        handleClickAnimationXml(btnBlinkXml,R.anim.anim_blink);
        handleClickAnimationXml(btnBounceXml,R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml,R.anim.anim_combine);
        handleClickAnimationXml(btnFadeInXml,R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml,R.anim.anim_fade_out);
        handleClickAnimationXml(btnMoveXml,R.anim.anim_move);
        handleClickAnimationXml(btnRotateXml,R.anim.anim_rotate);
        handleClickAnimationXml(btnSlideUpXml,R.anim.anim_slide_up);
        handleClickAnimationXml(btnZoomInXml,R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml,R.anim.anim_zoom_out);

        handleClickAnimationCode(btnFadeInCode,initFadeInAnimation());
        handleClickAnimationCode(btnBlinkCode,initBlinkAnimation());
        handleClickAnimationCode(btnBounceCode,initBounceAnimation());
        handleClickAnimationCode(btnFadeOutCode,initFadeOutAnimation());
        handleClickAnimationCode(btnMoveCode,initMoveAnimation());
        handleClickAnimationCode(btnRotateCode,initRoateAnimation());
        handleClickAnimationCode(btnSlideUpCode,initSlideUpAnimation());
        handleClickAnimationCode(btnZoomInCode,initZoomInAnimation());
        handleClickAnimationCode(btnZoomOutCode,initZoomOutAnimation());
        handleClickAnimationCode(btnCombineCode,initCombineAnimation());
    }
}
