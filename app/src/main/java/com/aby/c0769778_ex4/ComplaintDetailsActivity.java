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
    private TextView txtCompDescription;

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
        txtCompDescription = findViewById(R.id.txtCompDescription);


        if(getIntent().getExtras()  != null) {
            cd = (Complaints) getIntent().getExtras().getSerializable("complaintKey");
            txtCompName.setText(cd.getFirstName());
            txtCompLastName.setText(cd.getLastName());

            //Replacing contents of Arraylist as strings
            String issueListString = cd.getAllIssues().toString();
            issueListString = issueListString.replace("[", "")
                    .replace("]", "")
                    .replace(" ", "")
                    .replace(",", ", ");

            String addressString = cd.getAddress().toString();
            addressString = addressString.replace("[", "")
                    .replace("]", "")
                    .replace(" ", "")
                    .replace(",", ", ");

            txtCompIssues.setText(issueListString);
            //txtCompDate.setText(cd.getIssueDate());
            txtCompDesignation.setText(cd.getDesignation());
            txtCompNumber.setText(cd.getNumber());
            txtCompPostal.setText(addressString);
            txtCompDescription.setText(cd.getDescription());
        }
    }
}


