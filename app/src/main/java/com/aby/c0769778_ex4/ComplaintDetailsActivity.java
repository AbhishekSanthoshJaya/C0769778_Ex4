package com.aby.c0769778_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.aby.c0769778_ex4.model.Complaints;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class ComplaintDetailsActivity extends AppCompatActivity {

    Complaints cd;
    private TextView txtCompName;
    private TextView txtCompLastName;
    private TextView txtCompIssues;
    private TextView txtCompDate;
    private TextView txtCompDesignation;
    private TextView txtCompNumber;
    private TextView txtCompPostal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_details);
        ButterKnife.inject(this);

        txtCompName = findViewById(R.id.txtCompName);
        txtCompLastName = findViewById(R.id.txtCompLastName);
        txtCompIssues = findViewById(R.id.txtCompIssues);
        txtCompDate = findViewById(R.id.txtDate);
        txtCompDesignation = findViewById(R.id.txtCompDesignation);
        txtCompNumber = findViewById(R.id.txtCompNumber);
        txtCompPostal = findViewById(R.id.txtCompPostal);

        if(getIntent().getExtras()  != null) {
            cd = (Complaints) getIntent().getExtras().getSerializable("complaintKey");
            txtCompName.setText(cd.getFirstName());
            txtCompLastName.setText(cd.getLastName());
            txtCompIssues.setText(cd.getAllIssues().toString());
            //txtCompDate.setText(cd.getIssueDate());
            txtCompDesignation.setText(cd.getDesignation());
            txtCompNumber.setText(cd.getNumber());
            txtCompPostal.setText(cd.getPostalCode());
        }
    }
}


