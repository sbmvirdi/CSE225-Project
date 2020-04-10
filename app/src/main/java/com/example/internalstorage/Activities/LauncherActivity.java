package com.example.internalstorage.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.internalstorage.R;

public class LauncherActivity extends AppCompatActivity {

    private Button p2,p4,p5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        p2 =findViewById(R.id.p2);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);



        p2.setOnClickListener(v -> {

            Intent i = new Intent(this,P2.class);
            startActivity(i);
        });


        p4.setOnClickListener(v -> {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);

        });

        p5.setOnClickListener(v->{

            Intent i = new Intent(this,P5.class);
            startActivity(i);
        });



    }
}
