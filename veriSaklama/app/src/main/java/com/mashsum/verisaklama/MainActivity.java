package com.mashsum.verisaklama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);

    // kucuk verileri saklamak islemi yapcaz bunuda SharedPreferences ile yapcaz veri saklma.
        sharedPreferences = this.getSharedPreferences("com.mashsum.verisaklama", Context.MODE_PRIVATE);

        int StronAge =  sharedPreferences.getInt("stronAge",0);

        if (StronAge == 0){
            textView.setText("Your Age");
        }else{
            textView.setText("Your Age :" + StronAge);
        }
    }

    public void save(View view){
        if (!editText.getText().toString().matches("")){
            int userAge = Integer.parseInt(editText.getText().toString());
            textView.setText("Your Age = " + userAge);


            sharedPreferences.edit().putInt("stronAge",userAge).apply();
            // kucuk veri kayıt etik ve app kapansada yine aynı değer acılacak
        }
    }

    // Veri silme işlemi
    public void delete(View view){
        int storedData = sharedPreferences.getInt("stronAge",0);

        if (storedData != 0){
            sharedPreferences.edit().remove("StronAge").apply();
            textView.setText("Your Age :");
        }
    }
}