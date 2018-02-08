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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements ActionBar.OnNavigationListener {

    private Spinner mySpinner;
    private int flag=0;
    private EditText txtFirstName,txtLastName,txtEmail,txtMobile,txtAge;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtAge=findViewById(R.id.txtAge);
        txtEmail=findViewById(R.id.txtEmail);
        txtFirstName=findViewById(R.id.txtEmail);
        txtLastName=findViewById(R.id.txtLastName);
        txtMobile=findViewById(R.id.txtMobile);

        registerButton=findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((txtAge.getText().toString()=="")||(txtEmail.getText().toString()=="")||(txtFirstName.getText().toString()=="")||(txtLastName.getText().toString()=="")||(txtMobile.getText().toString()=="")){
                    Toast.makeText(MainActivity.this,"No Field should be left blank",LENGTH_LONG) ;
                }
                else{
                    Intent intent = new Intent(MainActivity.this,SensorsActivity.class);
                }
            }
        });



        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mySpinner = findViewById(R.id.tSpinner);


        ArrayAdapter<String> spinnerAdapter1 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.titles));
        spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(spinnerAdapter1);
        getSupportActionBar().setIcon(R.drawable.ic_icon2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setDisplayShowHomeEnabled(true);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               // if (++flag > 1) {
                    if (mySpinner.getSelectedItem().toString().equalsIgnoreCase("sensors")) {
                        Intent intent = new Intent(MainActivity.this, SensorsActivity.class);
                        startActivity(intent);
                    }
                if (mySpinner.getSelectedItem().toString().equalsIgnoreCase("record")) {
                    Intent intent = new Intent(MainActivity.this, RecordActivity.class);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,RecordActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        return false;
    }
}
