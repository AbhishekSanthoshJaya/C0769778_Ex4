package com.aby.c0769778_ex4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
private Spinner spnTitle;
private Spinner spnDesignation;

private TextView DisplayDate;
private TextInputLayout edtFirstName;
private TextInputLayout edtLastName;
private TextInputLayout  edtStreetNo;
private TextInputLayout  edtStreetName;
private TextInputLayout  edtProvince;
private TextInputLayout  edtPostalCode;
private TextInputLayout  edtCountry;
private TextInputLayout  edtNumber;
private EditText  edtIssueDetails;

private DatePickerDialog.OnDateSetListener mDateSetListener;

private RatingBar ratingBarSevere;
private Button btnClear;
private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnTitle = findViewById(R.id.spnTitle);
        spnDesignation = findViewById(R.id.spnDesignation);

        DisplayDate = findViewById(R.id.txtDate);
        edtIssueDetails = findViewById(R.id.edtIssueDetails);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtStreetNo = findViewById(R.id.edtStreetNo);
        edtStreetName = findViewById(R.id.edtStreetName);
        edtProvince = findViewById(R.id.edtProvince);
        edtPostalCode = findViewById(R.id.edtPostalCode);
        edtCountry = findViewById(R.id.edtCountry);
        edtNumber = findViewById(R.id.edtNumber);

        ratingBarSevere = findViewById(R.id.ratingBarSevere);
        btnClear = findViewById(R.id.btnClear);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clearing Spinners
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                        R.array.title_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnTitle.setAdapter(adapter);

                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(MainActivity.this,
                        R.array.designation_array, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnDesignation.setAdapter(adapter2);

                //Clearing EditText fields
                DisplayDate.setText("");
                edtIssueDetails.setText("");
                edtFirstName.getEditText().setText("");
                edtLastName.getEditText().setText("");
                edtStreetNo.getEditText().setText("");
                edtStreetName.getEditText().setText("");
                edtProvince.getEditText().setText("");
                edtPostalCode.getEditText().setText("");
                edtCountry.getEditText().setText("");
                edtNumber.getEditText().setText("");
            }
        });

        LayerDrawable layerDrawable = (LayerDrawable) ratingBarSevere.getProgressDrawable();
        DrawableCompat.setTint(DrawableCompat.wrap(layerDrawable.getDrawable(0)), Color.RED);
        DrawableCompat.setTint(DrawableCompat.wrap(layerDrawable.getDrawable(1)), Color.GREEN);
        DrawableCompat.setTint(DrawableCompat.wrap(layerDrawable.getDrawable(2)), Color.BLUE);

        edtIssueDetails.setScroller(new Scroller(MainActivity.this));
        edtIssueDetails.setMaxLines(3);
        edtIssueDetails.setMovementMethod(new ScrollingMovementMethod());

        DisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = month + "/" + day + "/" + year;
                DisplayDate.setText(date);
            }
        };
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.title_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTitle.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.designation_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDesignation.setAdapter(adapter2);
    }
}
