package com.example.mysmartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysmartlab.AnalyzeActivity;
import com.example.mysmartlab.R;

public class CreatCartActiviry extends AppCompatActivity {
    TextView name, firstname, surname, maleOrfemale, data;
    Button button;
    TextView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_cart_activiry);
        name = findViewById(R.id.editTextTextPersonName2);
        firstname = findViewById(R.id.editTextTextPersonName3);
        surname = findViewById(R.id.editTextTextPersonName4);
        data = findViewById(R.id.editTextDate);
        maleOrfemale = findViewById(R.id.editTextTextPersonName6);
        button = findViewById(R.id.button3) ;
        next = findViewById(R.id.textView22);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatCartActiviry.this, AnalyzeActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty() && firstname.getText().toString().isEmpty() && surname.getText().toString().isEmpty()
                 &&  maleOrfemale.getText().toString().isEmpty()  && data.getText().toString().isEmpty()) {

                    Toast.makeText(CreatCartActiviry.this, "Заполните все поля ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CreatCartActiviry.this, "Сохранено", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreatCartActiviry.this, AnalyzeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


}