package com.example.lokesh.a173050049app;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordActivity extends AppCompatActivity {
    private Spinner mySpinner;
    private TextView txtTime1,txtTime2,txtTime3,txtTime4,txtTime5;
    private ToggleButton toggleButton;
    public int count=-1;
   // private int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        txtTime1=findViewById(R.id.txtTime1);
        txtTime2=findViewById(R.id.txtTime2);
        txtTime3=findViewById(R.id.txtTime3);
        txtTime4=findViewById(R.id.txtTime4);
        txtTime5=findViewById(R.id.txtTime5);
        toggleButton=findViewById(R.id.toggleButton);

        if(savedInstanceState!=null){
            txtTime1.setText(savedInstanceState.getString("txt1"));
        }

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled

                } else {
                    // The toggle is disabled
                    count++;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
                    String currentDateandTime = sdf.format(new Date());
                    String temp;
                    if(count==0){
                        txtTime1.setText(currentDateandTime);
                    }
                    else if(count==1){
                        txtTime2.setText(txtTime1.getText().toString());
                        txtTime1.setText(currentDateandTime);

                    }
                    else if(count==2){
                        txtTime3.setText(txtTime2.getText().toString());
                        txtTime2.setText(txtTime1.getText().toString());
                        txtTime1.setText(currentDateandTime);

                    }
                    else if(count==3){
                        txtTime4.setText(txtTime3.getText().toString());
                        txtTime3.setText(txtTime2.getText().toString());
                        txtTime2.setText(txtTime1.getText().toString());
                        txtTime1.setText(currentDateandTime);
                    }
                    else if(count==4){
                        txtTime5.setText(txtTime4.getText().toString());
                        txtTime4.setText(txtTime3.getText().toString());
                        txtTime3.setText(txtTime2.getText().toString());
                        txtTime2.setText(txtTime1.getText().toString());
                        txtTime1.setText(currentDateandTime);
                    }
                    else if(count>4){
                        txtTime5.setText(txtTime4.getText().toString());
                        txtTime4.setText(txtTime3.getText().toString());
                        txtTime3.setText(txtTime2.getText().toString());
                        txtTime2.setText(txtTime1.getText().toString());
                        txtTime1.setText(currentDateandTime);

                    }





                }
            }
        });





        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mySpinner = findViewById(R.id.tSpinner);
        ArrayAdapter<String> spinnerAdapter1 = new ArrayAdapter<String>(RecordActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.titles));
        spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(spinnerAdapter1);
        getSupportActionBar().setIcon(R.drawable.ic_icon2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //  getSupportActionBar().setDisplayShowHomeEnabled(true);
        mySpinner.setSelection(2);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //if (++flag > 1) {
                    if (mySpinner.getSelectedItem().toString().equalsIgnoreCase("sensors")) {
                        Intent intent = new Intent(RecordActivity.this, SensorsActivity.class);
                        startActivity(intent);

                    } else if (mySpinner.getSelectedItem().toString().equalsIgnoreCase("register")) {
                        Intent intent = new Intent(RecordActivity.this, MainActivity.class);
                        startActivity(intent);

                    }


            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {


        super.onSaveInstanceState(outState, outPersistentState);
        outPersistentState.putString("txt1",txtTime1.getText().toString());
        outState.putString("txt2",txtTime2.getText().toString());
        outState.putString("txt3",txtTime3.getText().toString());
        outState.putString("txt4",txtTime4.getText().toString());
        outState.putString("txt5",txtTime5.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {


        super.onRestoreInstanceState(savedInstanceState);
        txtTime1.setText(savedInstanceState.getString("txt1"));
        txtTime2.setText(savedInstanceState.getString("txt2"));
        txtTime3.setText(savedInstanceState.getString("txt3"));
        txtTime4.setText(savedInstanceState.getString("txt4"));
        txtTime5.setText(savedInstanceState.getString("txt5"));
    }

}
