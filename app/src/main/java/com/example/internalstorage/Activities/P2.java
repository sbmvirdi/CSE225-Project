package com.example.internalstorage.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.internalstorage.Fragments.Frag1;
import com.example.internalstorage.Fragments.Frag2;
import com.example.internalstorage.R;

public class P2 extends AppCompatActivity  implements Frag1.FragmentAListener, Frag2.FragmentBListener {
    private Frag1 frag1;
    private Frag2 frag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);


         frag1 = (Frag1) getSupportFragmentManager().findFragmentById(R.id.frag1);
         frag2 = (Frag2) getSupportFragmentManager().findFragmentById(R.id.frag2);

        //getSupportFragmentManager().beginTransaction().replace(R.id.frag1,frag1).replace(R.id.frag2,frag2).commit();



    }

    @Override
    public void onInputASent(String message) {
        frag2.updateEditText(message);
        Log.e("onInputASent","true");
    }

    @Override
    public void onInputBSent(String message) {
        frag1.updateEditText(message);
        Log.e("onInputBSent","true");

    }
}
