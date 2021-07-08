package com.example.CliniCore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;

public class MainActivity7 extends AppCompatActivity {
Button butn;
    EditText name, age, patient, mobile, height,  weight;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    ConsultationRecords1 ConsultationRecords1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        butn=(Button) findViewById(R.id.button7);
        name= (EditText) findViewById(R.id.edtext1);
        age= (EditText) findViewById(R.id.edtext2);
        patient= (EditText) findViewById(R.id.edtext3);
        mobile= (EditText) findViewById(R.id.edtext4);
        height= (EditText) findViewById(R.id.edtext5);
        weight= (EditText) findViewById(R.id.edtext6);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("ConsultationRecords1");


        ConsultationRecords1 = new ConsultationRecords1();

        butn = findViewById(R.id.button7);

        // adding on click listener for our button.
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String myName =name .getText().toString();
                String myAge = age.getText().toString();
                String patientType2 =patient .getText().toString();
                String contact = mobile.toString();
                String myHeight = height.getText().toString();
                String myWeight = weight.toString();



                if (TextUtils.isEmpty(myName) && TextUtils.isEmpty(myAge) && TextUtils.isEmpty(patientType2) &&
                        TextUtils.isEmpty(contact) && TextUtils.isEmpty(myHeight) && TextUtils.isEmpty(myWeight)


                ) {

                    Toast.makeText(MainActivity7.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(myName, myAge, patientType2, contact, myHeight, myWeight);
                }
            }
        });
    }
    private void addDatatoFirebase(String myName, String myAge, String patientType2,
                                   String contact, String myHeight, String myWeight


    ) {

        ConsultationRecords1.setName(myName);
        ConsultationRecords1.setAge(myAge);
        ConsultationRecords1.setPatientType(patientType2);
        ConsultationRecords1.setContact(contact);
        ConsultationRecords1.setHeight(myHeight);
       ConsultationRecords1.setWeight(myWeight);

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(ConsultationRecords1);

                // after adding this data we are showing toast message.
                Toast.makeText(MainActivity7.this, "data added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity7.this , MainActivity8.class));
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(MainActivity7.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });}


}