package com.example.internalstorage.Adapters;

import android.content.SharedPreferences;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.internalstorage.Fragments.ColorSelect;
import com.example.internalstorage.Fragments.ShowColor;

public class MyPageAdapter extends FragmentStatePagerAdapter {
    private static final int no_of_pages = 2;

    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment f = null;

        switch(i) {
            case 0:
                f = new ColorSelect();
                break;
            case 1:
                f = new ShowColor();
                break;

        }

        return f;
    }

    @Override
    public int getCount() {
        return no_of_pages;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Color Select";
            default: return "Show Color";
        }
    }
}
