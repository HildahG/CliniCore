package com.example.CliniCore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity5 extends AppCompatActivity {
    Button button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        button6= (Button) findViewById(R.id.button6);
button6.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent next = new Intent(MainActivity5.this, MainActivity.class);
        startActivity(next);

    }
});

    }
}