package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//         writeData();
        readData();



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
            Log.e("VALUE",content);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeData(){
        String value  = "sample data to write";
        FileOutputStream fos = null;
        try {
            fos = this.openFileOutput(FILENAME,MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(value);
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
