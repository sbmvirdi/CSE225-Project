package com.example.internalstorage.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.internalstorage.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowColor extends Fragment {
    private View v;

    public ShowColor() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_show_color, container, false);
        SharedPreferences preferences = getActivity().getSharedPreferences("color",Context.MODE_PRIVATE);
        String colorval = preferences.getString("colorval","#00adb5");
        v.setBackgroundColor(Color.parseColor(colorval));
        Toast.makeText(getContext(), "Color changed", Toast.LENGTH_SHORT).show();
        return  v;
    }



    public void setColor(String message)
    {
        v.setBackgroundColor(Color.parseColor(message));
       // Toast.makeText(getContext(), "Color changed", Toast.LENGTH_SHORT).show();
    }
}
