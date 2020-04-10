package com.example.internalstorage.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.internalstorage.R;


public class Frag2 extends Fragment {

    private View v;
    private EditText editText;
    private Button send;
    private FragmentBListener listener;

    public Frag2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_frag2, container, false);
        editText = v.findViewById(R.id.edittext);
        send = v.findViewById(R.id.send);

        send.setOnClickListener(v->{
            String input = editText.getText().toString();
            listener.onInputBSent(input);
        });
        return v;
    }

    public interface FragmentBListener {
        void onInputBSent(String message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


        if (context instanceof FragmentBListener) {
            listener = (FragmentBListener) context;
        }else{
            throw new RuntimeException("Must Implement Fragment B Listener");
        }
    }

    public void updateEditText(String text){
        editText.setText(text);
        Log.e("Data Updated in B::","TRUE");
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
