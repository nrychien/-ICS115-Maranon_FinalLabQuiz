package com.maranon.maranon_finallabquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText etAuthor, etQuote;
    Button btnSave, btnDisplay;
    SharedPreferences preferences;
    FileOutputStream fos;
    FileInputStream fis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAuthor = (EditText) findViewById(R.id.et_author);
        etQuote = (EditText) findViewById(R.id.et_quote);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDisplay = (Button) findViewById(R.id.btnNext);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void save(View view) {
        String author = etAuthor.getText().toString();
        try {
            fos = openFileOutput("author.txt", Context.MODE_PRIVATE);
            fos.write(author.getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        String quote = etQuote.getText().toString();
        try {
            fos = openFileOutput("quote.txt", Context.MODE_PRIVATE);
            fos.write(quote.getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        Toast.makeText(this, "SAVED!!", Toast.LENGTH_LONG).show();
    }

    public void next(View view){
        Intent intent = new Intent(this,Display.class);
        startActivity(intent);
    }
}
