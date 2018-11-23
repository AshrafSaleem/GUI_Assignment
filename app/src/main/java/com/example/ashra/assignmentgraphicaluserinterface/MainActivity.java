package com.example.ashra.assignmentgraphicaluserinterface;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;

    private Button countDown1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);

        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        countDown1 = (Button) findViewById(R.id.countDown1);
        countDown1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendar1();
            }
        });
    }
    public void openCalendar1(){
        Intent calendar1 = new Intent(this, Calendar1.class);
        startActivity(calendar1);
    }
}
