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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity8 extends AppCompatActivity {
 EditText edtext7, edtext8, edtext9, edtext10, edtext11, edtext12, edtext13 ;
 Button button8;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    ConsultationRecords2 ConsultationRecords2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        edtext7=(EditText) findViewById(R.id.edtext7);
        edtext8= (EditText) findViewById(R.id.edtext8);
        edtext9=(EditText) findViewById(R.id.edtext9);
        edtext10=(EditText) findViewById(R.id.edtext10);
        edtext11= (EditText) findViewById(R.id.edtext11);
        edtext12=(EditText) findViewById(R.id.edtext12);
        edtext13=(EditText) findViewById(R.id.edtext13);
        button8=(Button) findViewById(R.id.button8);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("ConsultationRecords2");


        ConsultationRecords2 = new ConsultationRecords2();
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String myBMR = edtext7.getText().toString();
                String myTemperature = edtext8.getText().toString();
                String bloodPressure =  edtext9.getText().toString();
                String medicalHistory = edtext10.toString();
                String clinicalNotes = edtext11.getText().toString();
                String recommendations = edtext12.getText().toString();
                String consultations = edtext13.toString();



                if (TextUtils.isEmpty(myBMR) && TextUtils.isEmpty(myTemperature) && TextUtils.isEmpty(bloodPressure) &&
                        TextUtils.isEmpty(medicalHistory) &&       TextUtils.isEmpty(clinicalNotes) && TextUtils.isEmpty(recommendations) && TextUtils.isEmpty(consultations)


                ) {

                    Toast.makeText(MainActivity8.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(myBMR, myTemperature, bloodPressure, medicalHistory, clinicalNotes, recommendations,consultations);
                }
            }
        });
    }
    private void addDatatoFirebase(String myBMR, String myTemperature, String bloodPressure,
                                   String medicalHistory, String clinicalNotes, String recommendations,  String consultations


    ) {

        ConsultationRecords2.setBMR(myBMR);
        ConsultationRecords2.setTemperature(myTemperature);
        ConsultationRecords2.setBloodPressure(bloodPressure);
        ConsultationRecords2.setMedicalHistory(medicalHistory);
        ConsultationRecords2.setClinicalNotes(clinicalNotes);
        ConsultationRecords2.setRecommendations(recommendations);
        ConsultationRecords2.setConsultations(consultations);

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(ConsultationRecords2);

                // after adding this data we are showing toast message.
                Toast.makeText(MainActivity8.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(MainActivity8.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
