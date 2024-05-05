package com.example.lab4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml, btnBlinkCode, btnZoomInXml, btnZoomInCode,
            btnZoomOutXml, btnZoomOutCode, btnRotateXml, btnRotateCode,
            btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml, btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();
        initVariables();

        //set start new activity when user clicks ivUitLogo;
        ivUitLogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent iNewActivity= new Intent(MainActivity.this,MainActivity.class);
                startActivity(iNewActivity);

                overridePendingTransition(R.anim.anim_fade_in,R.anim.anim_fade_out);}
        });

        //HandleClickAnimationXML
        handleClickAnimationXml(btnFadeInXml,R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml,R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml,R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml,R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml,R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml,R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml,R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml,R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml,R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml,R.anim.anim_combine);
        //handelclickAnimationCode
        handleClickAnimationCode(btnFadeInCode,initFadeInAnimation());
        handleClickAnimationCode(btnFadeOutCode,initFadeOutAnimation());
        handleClickAnimationCode(btnBlinkCode,initBlinkAnimation());
        handleClickAnimationCode(btnZoomInCode,initZoomInAnimation());
        handleClickAnimationCode(btnZoomOutCode,initZoomOutAnimation());
        handleClickAnimationCode(btnRotateCode,initRotateAnimation());
        handleClickAnimationCode(btnMoveCode,initMoveAnimation());
        handleClickAnimationCode(btnSlideUpCode,initSlideUpAnimation());
        handleClickAnimationCode(btnBounceCode,initBounceAnimation());
        handleClickAnimationCode(btnCombineCode,initCombineAnimation());

    }

    private AlphaAnimation initFadeInAnimation(){
        AlphaAnimation animation=new AlphaAnimation(0f,1f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private AlphaAnimation initFadeOutAnimation() {
        AlphaAnimation animation=new AlphaAnimation(1f,0f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initBlinkAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(300);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(3);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private ScaleAnimation initZoomInAnimation() {
        ScaleAnimation animation = new ScaleAnimation(
                1,   // fromXScale
                3,   // toXScale
                1,   // fromYScale
                3,   // toYScale
                Animation.RELATIVE_TO_SELF, 0.5f,   // pivotX
                Animation.RELATIVE_TO_SELF, 0.5f    // pivotY
        );
        animation.setDuration(1000);
        animation.setAnimationListener(animationListener);
        animation.setFillAfter(true);
        return animation;
    }

    private ScaleAnimation initZoomOutAnimation() {
        ScaleAnimation animation = new ScaleAnimation(
                1,   // fromXScale
                0.5f,   // toXScale
                1,   // fromYScale
                0.5f,   // toYScale
                Animation.RELATIVE_TO_SELF, 0.5f,   // pivotX
                Animation.RELATIVE_TO_SELF, 0.5f    // pivotY
        );
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private RotateAnimation initRotateAnimation() {
        RotateAnimation animation = new RotateAnimation(
                0,    // fromDegrees
                360,  // toDegrees
                Animation.RELATIVE_TO_SELF, 0.5f,   // pivotX
                Animation.RELATIVE_TO_SELF, 0.5f    // pivotY
        );
        animation.setDuration(600);
        animation.setRepeatMode(Animation.RESTART);
        animation.setRepeatCount(2);
        animation.setInterpolator(new LinearInterpolator());
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private TranslateAnimation initMoveAnimation() {
        TranslateAnimation animation = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,  // fromXDelta
                TranslateAnimation.RELATIVE_TO_PARENT, 0.75f,  // toXDelta
                TranslateAnimation.RELATIVE_TO_SELF, 0f,  // fromYDelta
                TranslateAnimation.RELATIVE_TO_SELF, 0f   // toYDelta
        );
        animation.setDuration(800);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private ScaleAnimation initSlideUpAnimation() {
        ScaleAnimation animation = new ScaleAnimation(
                1.0f,   // fromXScale
                1.0f,   // toXScale
                1.0f,   // fromYScale
                0.0f   // toYScale
        );
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private ScaleAnimation initBounceAnimation() {
        ScaleAnimation animation = new ScaleAnimation(
                1.0f,   // fromXScale
                1.0f,   // toXScale
                0.0f,   // fromYScale
                1.0f   // toYScale
        );
        animation.setDuration(500);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initCombineAnimation() {
        Context context = btnCombineCode.getContext();

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1,   // fromXScale
                3,   // toXScale
                1,   // fromYScale
                3,   // toYScale
                Animation.RELATIVE_TO_SELF, 0.5f,   // pivotX
                Animation.RELATIVE_TO_SELF, 0.5f    // pivotY
        );
        scaleAnimation.setDuration(4000);

        RotateAnimation rotateAnimation = new RotateAnimation(
                0,    // fromDegrees
                360,  // toDegrees
                Animation.RELATIVE_TO_SELF, 0.5f,   // pivotX
                Animation.RELATIVE_TO_SELF, 0.5f    // pivotY
        );
        rotateAnimation.setDuration(500);
        rotateAnimation.setRepeatCount(2);
        rotateAnimation.setRepeatMode(Animation.RESTART);

        AnimationSet animationSet = new AnimationSet(context, null);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        rotateAnimation.setAnimationListener(animationListener);
        return animationSet;
    }


    private void handleClickAnimationCode(Button btn, final Animation animation) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });
    }


    private void handleClickAnimationXml(Button btn, int animId)
    {
        //fadein
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_fade_in);
        animation.setAnimationListener(animationListener);
        btnFadeInXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation);
            }
        });

        //fadeout
        final Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_fade_out);
        animation1.setAnimationListener(animationListener);
        btnFadeOutXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation1);
            }
        });

        //blink
        final Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_blink);
        animation2.setAnimationListener(animationListener);
        btnBlinkXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation2);
            }
        });

        //bounce
        final Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_bounce);
        animation4.setAnimationListener(animationListener);
        btnBounceXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation4);
            }
        });

        //combine
        final Animation animation5 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_combine);
        animation5.setAnimationListener(animationListener);
        btnCombineXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation5);
            }
        });

        //move
        final Animation animation6 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_move);
        animation6.setAnimationListener(animationListener);
        btnMoveXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation6);
            }
        });

        //rotate
        final Animation animation7 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_rotate);
        animation7.setAnimationListener(animationListener);
        btnRotateXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation7);
            }
        });

        //zoom in
        final Animation animation8 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_zoom_in);
        animation8.setAnimationListener(animationListener);
        btnZoomInXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation8);
            }
        });

        //zoomout
        final Animation animation9 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_zoom_out);
        animation9.setAnimationListener(animationListener);
        btnZoomOutXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation9);
            }
        });

        //slideup
        final Animation animation10 = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_slide_up);
        animation10.setAnimationListener(animationListener);
        btnSlideUpXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUitLogo.startAnimation(animation10);
            }
        });


        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out);
            }
        });
    }
}