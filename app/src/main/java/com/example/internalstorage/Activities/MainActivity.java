package com.example.internalstorage.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.internalstorage.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private static final String FILENAME = "shubamvirdi";
    private StringBuilder sb;
    private BufferedReader br;
    private EditText value;
    private Button readbtn,writebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value = findViewById(R.id.value);
        readbtn = findViewById(R.id.readbtn);
        writebtn = findViewById(R.id.writebtn);

        readbtn.setOnClickListener(v -> readData());

        writebtn.setOnClickListener(v -> writeData());


    }

    private void readData() {
        try {
            FileInputStream fis  =  this.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            sb = new StringBuilder();
            br  = new BufferedReader(isr);
            String line = br.readLine();
            while (line!=null){
                sb.append(line).append('\n');
                line = br.readLine();
            }
            String content = sb.toString();
            //this.value.setText(content);
            Toast.makeText(this, content, Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeData(){
        String value  = this.value.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = this.openFileOutput(FILENAME,MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(value);
            osw.close();
            Toast.makeText(this, "Data Written Successfully", Toast.LENGTH_SHORT).show();
            this.value.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
