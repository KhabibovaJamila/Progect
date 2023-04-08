package com.example.mysmartlab.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mysmartlab.Activity.CreatCartActiviry;
import com.example.mysmartlab.R;

public class RegistrationActivity extends AppCompatActivity {
    EditText email ;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email2(email);
            }
        });
    }
    private boolean email2(EditText email) {
        String emailInput = email.getText().toString();

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {


            button.setBackgroundColor(Color.parseColor("#1A6FEE"));
            Intent intent = new Intent(RegistrationActivity.this, PostCodeActivity.class) ;
            startActivity(intent);

        }else{
            Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}