package com.heroes.nouveau.hackmap;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class HelpActivity extends AppCompatActivity {

    ImageButton com;
    ImageButton sal;
    ImageButton rop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        com = (ImageButton) findViewById(R.id.food);
        sal = (ImageButton) findViewById(R.id.health);
        rop = (ImageButton) findViewById(R.id.wear);
    }

    public void animarB(View view){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.mostrar);
        anim.reset();

        switch (view.getId()){
            case R.id.food:
                com.startAnimation(anim);
                break;
            case R.id.health:
                sal.startAnimation(anim);
                break;
            case R.id.wear:
                rop.startAnimation(anim);
                break;
            default:
                break;
        }
    }
}
