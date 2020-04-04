package com.aby.c0769778_ex4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.aby.c0769778_ex4.model.Complaints;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
private Spinner spnTitle;
private Spinner spnDesignation;

private TextView DisplayDate;
private TextInputLayout edtFirstName;
private TextInputEditText edtFirstNameText;

private TextInputLayout edtLastName;
private TextInputEditText edtLastNameText;

private TextInputLayout edtStreetNo;
private TextInputEditText edtStreetNoText;

private TextInputLayout edtStreetName;
private TextInputEditText edtStreetNameText;

private TextInputLayout edtProvince;
private TextInputEditText edtProvinceText;

private TextInputLayout edtPostalCode;
private TextInputEditText edtPostalCodeText;

private TextInputLayout edtCountry;
private TextInputEditText edtCountryText;

private TextInputLayout edtNumber;
private TextInputEditText edtNumberText;

private EditText edtIssueDetails;
private CheckBox chkNetwork;
private CheckBox chkPerformance;
private CheckBox chkOther;
private CheckBox chkInstallation;
private DatePickerDialog.OnDateSetListener mDateSetListener;

private RadioButton rdBtnTrainee;
private RadioButton rdBtnParttime;
private RadioButton rdBtnFulltime;

private RatingBar ratingBarSevere;
private Button btnClear;
private Button btnSubmit;


    @Override
    protected void onStart() {
        super.onStart();
        clearAll();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnTitle = findViewById(R.id.spnTitle);
        spnDesignation = findViewById(R.id.spnDesignation);

        chkNetwork = findViewById(R.id.chkNetwork);
        chkInstallation = findViewById(R.id.chkInstallation);
        chkOther = findViewById(R.id.chkOther);
        chkPerformance = findViewById(R.id.chkPerformance);

        rdBtnFulltime = findViewById(R.id.rdBtnFulltime);
        rdBtnParttime = findViewById(R.id.rdBtnParttime);
        rdBtnTrainee = findViewById(R.id.rdBtnTrainee);

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

        edtFirstNameText = findViewById(R.id.edtFirstNameText);
        edtLastNameText = findViewById(R.id.edtLastNameText);
        edtStreetNoText = findViewById(R.id.edtStreetNoText);
        edtStreetNameText = findViewById(R.id.edtStreetNameText);
        edtProvinceText = findViewById(R.id.edtStreetNameText);
        edtPostalCodeText = findViewById(R.id.edtPostalCodeText);
        edtCountryText = findViewById(R.id.edtCountryText);
        edtNumberText = findViewById(R.id.edtNumberText);

        ratingBarSevere = findViewById(R.id.ratingBarSevere);
        btnClear = findViewById(R.id.btnClear);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtFirstNameText.getText().toString().isEmpty()) {
                    errorToast();
                    edtFirstNameText.setError("Enter first name");
                }
                if(edtLastNameText.getText().toString().isEmpty()){
                    errorToast();
                    edtLastNameText.setError("Enter last name");
                }
                if(edtNumberText.getText().toString().isEmpty()){
                    errorToast();
                    edtNumberText.setError("Enter number");
                }
                if(edtIssueDetails.getText().toString().isEmpty()){
                    errorToast();
                    edtIssueDetails.setError("Enter your issue");
                }
                if(edtStreetNameText.getText().toString().isEmpty()){
                    errorToast();
                    edtStreetNameText.setError("Enter your Street Name");
                }
                if(edtStreetNoText.getText().toString().isEmpty()){
                    errorToast();
                    edtStreetNoText.setError("Enter your Street Number");
                }
                if(edtPostalCodeText.getText().toString().isEmpty()){
                    errorToast();
                    edtPostalCodeText.setError("Enter your Postal Code");
                }
                if(edtCountryText.getText().toString().isEmpty()){
                    errorToast();
                    edtCountryText.setError("Enter your country");
                }
                if(edtProvinceText.getText().toString().isEmpty()){
                    errorToast();
                    edtProvinceText.setError("Enter your province");
                }
                else {
                    new MaterialAlertDialogBuilder(MainActivity.this)
                            .setTitle("CONFIRM COMPLAINT")
                            .setMessage("Would you like to register this complaint?")
                            .setPositiveButton("PROCEED", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String designation = spnDesignation.getSelectedItem().toString();
                                    Complaints complaintDetails = new Complaints(edtFirstNameText.getText().toString(),
                                            edtLastNameText.getText().toString(),
                                            getIssues(),
                                            designation,
                                            DisplayDate.getText().toString(),
                                            edtNumberText.getText().toString(),
                                            edtPostalCodeText.getText().toString());
                                    Intent complaintIntent = new Intent(MainActivity.this, ComplaintDetailsActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable("complaintKey",complaintDetails);
                                    complaintIntent.putExtras(bundle);
                                    startActivity(complaintIntent);
                                }
                            })
                            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .show();
                }
            }
        });

                ratingBarSevere.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                        Toast.makeText(MainActivity.this,
                                "Rating changed, current severity " + ratingBar.getRating(),
                                Toast.LENGTH_SHORT).show();
                        setColors(ratingBar.getRating());
                    }
                });

                Drawable stars = ratingBarSevere.getProgressDrawable();
                stars.setTint(Color.YELLOW);
                DrawableCompat.setTint(stars, getResources().getColor(R.color.rating_severe));

                btnClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clearAll();
                    }
                });

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
                                year, month, day);
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
    private void errorToast(){
        Toast.makeText(MainActivity.this, "Please fill the mandatory fields", Toast.LENGTH_LONG).show();
    }

    private void clearAll(){
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

        //Clearing Previous Errors
        edtFirstNameText.setError(null);
        edtLastNameText.setError(null);
        edtIssueDetails.setError(null);
        edtNumberText.setError(null);
        edtCountryText.setError(null);
        edtStreetNameText.setError(null);
        edtStreetNoText.setError(null);
        edtPostalCodeText.setError(null);
        edtProvinceText.setError(null);
        edtPostalCodeText.setError(null);

        //Clearing Checkbox, Rating bar, Radiobuttons
        chkNetwork.setChecked(false);
        chkInstallation.setChecked(false);
        chkPerformance.setChecked(false);
        chkOther.setChecked(false);

        rdBtnFulltime.setChecked(false);
        rdBtnParttime.setChecked(false);
        rdBtnTrainee.setChecked(false);

        ratingBarSevere.setRating(0F);
    }
    private void setColors(float rating) {
        LayerDrawable stars = (LayerDrawable)ratingBarSevere.getProgressDrawable();
        switch (Math.round(rating)) {
            case 1:
                stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.very_low), PorterDuff.Mode.SRC_ATOP);
                break;
            case 2:
                stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.low), PorterDuff.Mode.SRC_ATOP);
                break;
            case 3:
                stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.medium), PorterDuff.Mode.SRC_ATOP);
                break;
            case 4:
                stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.high), PorterDuff.Mode.SRC_ATOP);
                break;
            case 5:
                stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.critical), PorterDuff.Mode.SRC_ATOP);
                break;
        }
    }

    private ArrayList<String> getIssues(){
        ArrayList<String> issueList= new ArrayList<>();
        if(chkNetwork.isChecked()){
            issueList.add("Network");
        }
        if(chkPerformance.isChecked()){
            issueList.add("Performance");
        }
        if(chkInstallation.isChecked()){
            issueList.add("Installation");
        }
        if(chkOther.isChecked()){
            issueList.add("Other");
        }
        return issueList;
    }
}



