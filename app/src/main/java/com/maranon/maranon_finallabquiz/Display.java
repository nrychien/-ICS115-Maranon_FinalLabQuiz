package com.maranon.maranon_finallabquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Display extends AppCompatActivity {
    TextView author, quote; FileInputStream fis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        author = (TextView) findViewById(R.id.tvAuthor);
        quote = (TextView) findViewById(R.id.tvQuote);

        String filename = "author.txt";
        String filename1 = "quote.txt";
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer1 = new StringBuffer();
        String quota = "''";
        int read = 0;

        try{
            fis = openFileInput(filename);
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }

            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            fis = openFileInput(filename1);

            buffer1.append(quota);
            while((read = fis.read()) != -1){
                buffer1.append((char)read);
            }

            buffer1.append(quota);

            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        author.setText(buffer.toString());
        quote.setText(buffer1.toString());

    }
    public void back(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
