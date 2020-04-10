package com.example.internalstorage.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.internalstorage.Adapters.MyPageAdapter;
import com.example.internalstorage.Fragments.ColorSelect;
import com.example.internalstorage.Fragments.ShowColor;
import com.example.internalstorage.R;
import com.google.android.material.tabs.TabLayout;

public class P5 extends AppCompatActivity
        implements ColorSelect.SendMessage
{

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5);


        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        MyPageAdapter adapter = new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void sendData(String message) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
        ShowColor showColor = (ShowColor) getSupportFragmentManager().getFragments().get(1);
        showColor.setColor(message);

    }
}
