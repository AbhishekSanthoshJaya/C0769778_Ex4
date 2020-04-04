package com.aby.c0769778_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.aby.c0769778_ex4.model.Complaints;

import butterknife.ButterKnife;

public class ComplaintDetails extends AppCompatActivity {

    Complaints cd;
    private TextView txtCompName;
    private TextView txtCompLastName;
    private TextView txtCompDescription;
    private TextView txtCompDate;
    private TextView txtCompDesignation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_details);
        ButterKnife.inject(this);

        txtCompName = findViewById(R.id.txtCompName);
        txtCompLastName = findViewById(R.id.txtCompLastName);
        txtCompDescription = findViewById(R.id.txtCompDescription);
        txtCompDate = findViewById(R.id.txtDate);
        txtCompDesignation = findViewById(R.id.txtCompDesignation);

        if(getIntent().getExtras()  != null) {
            cd = (Complaints) getIntent().getExtras().getSerializable("complaintKey");
           //Toast.makeText(this, cd.toString(), Toast.LENGTH_LONG).show();
            txtCompName.setText(cd.getFirstName());
            txtCompLastName.setText(cd.getLastName());
            txtCompDescription.setText(cd.getComplaintDescription());
            //txtCompDate.setText(cd.getIssueDate());
            txtCompDesignation.setText(cd.getDesignation());
        }
    }
}


