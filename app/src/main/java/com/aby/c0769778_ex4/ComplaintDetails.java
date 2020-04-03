package com.aby.c0769778_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ComplaintDetails extends AppCompatActivity {

    Complaints cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_details);

        if(getIntent().getExtras()  != null) {
            cd = (Complaints) getIntent().getExtras().getSerializable("complaintKey");
            Toast.makeText(this, cd.toString(), Toast.LENGTH_LONG).show();
        }
    }
}


