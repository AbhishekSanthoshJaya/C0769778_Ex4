package com.aby.c0769778_ex4.model;

import android.text.Editable;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Complaints implements Serializable {

    private String firstName;
    private String lastName;
    private ArrayList allIssues;
    private String complaintDescription;
    private String designation;
    private String issueDate;
    private String number;
    private ArrayList address;
    private String postalCode;
    private String description;

    public Complaints(String firstName,
                      String lastName,
                      ArrayList allIssues,
                      String designation,
                      String issueDate,
                      String number,
                      String postalCode,
                      ArrayList address,
                      String description)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.allIssues = allIssues;
        this.designation = designation;
        this.issueDate = issueDate;
        this.number = number;
        this.address = address;
        this.postalCode = postalCode;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList getAddress() {
        return address;
    }

    public ArrayList getAllIssues() {
        return allIssues;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return "Complaint{" +
                "firstName=" + firstName +
                ", secondName='" + lastName + '\'' +
                '}';
    }
}
