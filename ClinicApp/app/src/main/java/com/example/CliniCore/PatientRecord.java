package com.example.CliniCore;

public class PatientRecord {
    // string variable for
    // storing employee name.
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String patientGender;
    private String patientAge;
    private String patientCondition;
    private String patientAddress;
    private String Date;
    private String typeOfPatient;

    public PatientRecord() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName= lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumbers(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // created getter and setter methods
    // for all our variables.
    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientCondition() {
        return patientCondition;
    }

    public void setPatientConditions(String patientCondition) {
        this.patientCondition = patientCondition;
    }
    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String Date() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTypeOfPatient() {
        return typeOfPatient;
    }

    public void setTypeOfPatient(String typeOfPatient) {
        this.typeOfPatient = typeOfPatient;
    }
}
