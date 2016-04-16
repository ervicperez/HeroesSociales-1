package com.heroes.nouveau.hackmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class Principal extends AppCompatActivity {

    ImageButton co;
    ImageButton ro;
    ImageButton sa;
    ImageButton me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        co = (ImageButton) findViewById(R.id.comidaP);
        ro = (ImageButton) findViewById(R.id.ropaP);
        sa = (ImageButton) findViewById(R.id.sangreP);
        me = (ImageButton) findViewById(R.id.saludP);
    }

    /*public void animarBM(View view){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.mostrar);
        anim.reset();

        switch (view.getId()){
            case R.id.comidaP:
                co.startAnimation(anim);
                break;
            case R.id.ropaP:
                ro.startAnimation(anim);
                break;
            case R.id.sangreP:
                sa.startAnimation(anim);
                break;
            case R.id.saludP:
                me.startAnimation(anim);
                break;
            default:
                break;
        }
    }*/

    public void aniBH(View view){
        /*Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mostrar);
        //anim.reset();
        me.startAnimation(anim);*/
        Intent intent = new Intent(Principal.this, MapsActivity.class);
        startActivity(intent);
    }

    public void aniBC(View view){
        /*Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mostrar);
        //anim.reset();
        ro.startAnimation(anim);*/
        Intent intent = new Intent(Principal.this, MapsActivity.class);
        startActivity(intent);
    }

    public void aniBF(View view){
        /*Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mostrar);
        //anim.reset();
        co.startAnimation(anim);*/
        Intent intent = new Intent(Principal.this, MapsActivity.class);
        startActivity(intent);
    }

    public void aniBB(View view){
        /*Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mostrar);
        //anim.reset();
        sa.startAnimation(anim);*/
        Intent intent = new Intent(Principal.this, MapsActivity.class);
        startActivity(intent);
    }
}
