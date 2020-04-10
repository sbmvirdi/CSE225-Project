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

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    private FragmentAListener listener;
    private EditText editText;
    private Button send;

    public Frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_frag1, container, false);
        editText = v.findViewById(R.id.edittext);
        send = v.findViewById(R.id.send);

        send.setOnClickListener(v1 -> {
            String input = editText.getText().toString();
            listener.onInputASent(input);
        });
        return v;
    }

    public interface FragmentAListener {
        void onInputASent(String message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof FragmentAListener) {
            listener = (FragmentAListener) context;
        }else{
            throw new RuntimeException("Must Implement Fragment A Listener");
        }
    }

    public void updateEditText(String text){
            editText.setText(text);
            Log.e("Data Updated in A::","TRUE");
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
