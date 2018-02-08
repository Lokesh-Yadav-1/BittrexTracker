package com.example.lokesh.a173050049app;

import android.content.Intent;
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
import android.widget.Spinner;

public class SensorsActivity extends AppCompatActivity {
    private Spinner mySpinner;
    //private int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mySpinner = findViewById(R.id.tSpinner);


        ArrayAdapter<String> spinnerAdapter1 = new ArrayAdapter<String>(SensorsActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.titles));
        spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(spinnerAdapter1);
        getSupportActionBar().setIcon(R.drawable.ic_icon2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //  getSupportActionBar().setDisplayShowHomeEnabled(true);
        mySpinner.setSelection(1);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

              //  if (++flag > 1) {
                if(mySpinner.getSelectedItem().toString().equalsIgnoreCase("register")){
                    Intent intent = new Intent(SensorsActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                if(mySpinner.getSelectedItem().toString().equalsIgnoreCase("record")){
                    Intent intent = new Intent(SensorsActivity.this,RecordActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(SensorsActivity.this,RecordActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
