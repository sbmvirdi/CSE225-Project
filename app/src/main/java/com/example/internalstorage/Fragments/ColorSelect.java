package com.example.internalstorage.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.internalstorage.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorSelect extends Fragment {

    private RadioGroup radiogroup;
    private RadioButton selectedrb;
    private SendMessage SM;

    public ColorSelect() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_color_select, container, false);

        SharedPreferences preferences = this.getActivity().getSharedPreferences("color", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String selected = preferences.getString("selected","blue");



                radiogroup = v.findViewById(R.id.radiogroup);

        int resID = getResources().getIdentifier(selected, "id", getActivity().getPackageName());
                selectedrb = radiogroup.findViewById(resID);
                selectedrb.setChecked(true);

        radiogroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.red){
                Log.e("color",checkedId+"");
                editor.putString("colorval","#ee4848");
                editor.putString("selected","red");
                SM.sendData("#ee4848");
                editor.apply();
            }else if (checkedId == R.id.blue){
                Log.e("color",checkedId+"");
                editor.putString("colorval","#00adb5");
                editor.putString("selected","blue");
                SM.sendData("#00adb5");
                editor.apply();
            }else if (checkedId == R.id.green){
                Log.e("color",checkedId+"");
                editor.putString("selected","green");
                editor.putString("colorval","#00ff00");
                SM.sendData("#00ff00");
                editor.apply();
            }else if (checkedId == R.id.yellow){
                Log.e("color",checkedId+"");
                editor.putString("selected","yellow");
                editor.putString("colorval","#f1d18a");
                SM.sendData("#f1d18a");
                editor.apply();
            }else if (checkedId == R.id.pink){
                Log.e("color",checkedId+"");
                editor.putString("selected","pink");
                editor.putString("colorval","#c06c84");
                SM.sendData("#c06c84");
                editor.apply();
            }else if (checkedId == R.id.navyblue){
                Log.e("color",checkedId+"");
                editor.putString("selected","navyblue");
                editor.putString("colorval","#000080");
                SM.sendData("#000080");
                editor.apply();
            }else if (checkedId == R.id.orange){
                Log.e("color",checkedId+"");
                editor.putString("selected","orange");
                editor.putString("colorval","#ff7a5a");
                //SM.sendData("#ff7a5a");
                editor.apply();
            }else if (checkedId == R.id.black){
                Log.e("color",checkedId+"");
                editor.putString("selected","black");
                editor.putString("colorval","#000000");
                SM.sendData("#000000");
                editor.apply();
            }else if (checkedId == R.id.purple){
                Log.e("color",checkedId+"");
                editor.putString("selected","purple");
                editor.putString("colorval","#432160");
                SM.sendData("#432160");
                editor.apply();
            }else if (checkedId == R.id.mustard){
                Log.e("color",checkedId+"");
                editor.putString("selected","mustard");
                editor.putString("colorval","#cc7f2a");
                SM.sendData("#cc7f2a");
                editor.apply();
            }

        });
        return v;
    }


    public interface SendMessage {
        void sendData(String message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            SM = (SendMessage) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.e("OnStart()::","Executed");
    }
}
