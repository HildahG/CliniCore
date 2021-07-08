package com.example.CliniCore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
Button save;
TextView patient, consult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        save=(Button) findViewById(R.id.button5);
        patient=(TextView) findViewById(R.id.pantientRecord);
        consult=(TextView) findViewById(R.id.consultationRecords);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(next);
            }
        });
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity4.this, MainActivity6.class);
                startActivity(next);

            }
        });
        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(next);
            }
        });
    }
}