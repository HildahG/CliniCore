package com.example.CliniCore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;

public class MainActivity6 extends AppCompatActivity {

        private EditText fn, ln, phone, age,  add,date, type ;
        private  Spinner gender, condition;
        private Button sendDatabtn;


        FirebaseDatabase firebaseDatabase;

        DatabaseReference databaseReference;

        PatientRecord PatientRecord;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main6);

            // initializing our edittext and button
            fn = findViewById(R.id.ed1);
            ln = findViewById(R.id.ed2);
            phone = findViewById(R.id.ed3);
            age = findViewById(R.id.ed5);
            add= findViewById(R.id.ed7);
            date= findViewById(R.id.ed8);
            gender = findViewById(R.id.ed4);
            condition= findViewById(R.id.ed6);
            type= findViewById(R.id.ed9);

            firebaseDatabase = FirebaseDatabase.getInstance();

            databaseReference = firebaseDatabase.getReference("PatientRecord");


            PatientRecord = new PatientRecord();

            sendDatabtn = findViewById(R.id.button7);

            // adding on click listener for our button.
            sendDatabtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // getting text from our edittext fields.
                    String firstName = fn.getText().toString();
                    String lastName = ln.getText().toString();
                    String mobile = phone.getText().toString();
                    String myGender = gender.toString();
                    String myAge = age.getText().toString();
                    String myCondition = condition.toString();
                    String myAddress = add.getText().toString();
                    String dates = date.getText().toString();
                    String patientType = type.getText().toString();


                    if (TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(mobile) &&
                            TextUtils.isEmpty(myGender) && TextUtils.isEmpty(myAge) && TextUtils.isEmpty(myCondition) &&
                            TextUtils.isEmpty(myAddress) && TextUtils.isEmpty(dates) && TextUtils.isEmpty(patientType)


                    ) {

                        Toast.makeText(MainActivity6.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                    } else {
                        // else call the method to add
                        // data to our database.
                        addDatatoFirebase(firstName,lastName,mobile,myGender,myAge,myCondition,myAddress,dates,patientType);
                    }
                }
            });
        }
        private void addDatatoFirebase(String firstName, String lastName, String mobile,
        String myGender, String myAge, String myCondition, String myAddress, String dates, String patientType


        ) {

            PatientRecord.setFirstName(firstName);
            PatientRecord.setLastName(lastName);
            PatientRecord.setMobileNumbers(mobile);
          PatientRecord.setPatientGender(myGender);
            PatientRecord.setPatientAge(myAge);
            PatientRecord.setPatientConditions(myCondition);
           PatientRecord.setPatientAddress(myAddress);
           PatientRecord.setDate(dates);
            PatientRecord.setTypeOfPatient(patientType);

            // we are use add value event listener method
            // which is called with database reference.
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    // inside the method of on Data change we are setting
                    // our object class to our database reference.
                    // data base reference will sends data to firebase.
                    databaseReference.setValue(PatientRecord);

                    // after adding this data we are showing toast message.
                    Toast.makeText(MainActivity6.this, "data added", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // if the data is not added or it is cancelled then
                    // we are displaying a failure toast message.
                    Toast.makeText(MainActivity6.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
                }
   });
    }
}