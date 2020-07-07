package com.example.walmarthackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Description extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button a,b;
    Spinner spin;
    EditText f,s,t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        // Spinner element
        spin = findViewById(R.id.spinner);

        // Spinner click listener
        spin.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Laptops");
        categories.add("Television Sets");
        categories.add("Speaker Systems");
        categories.add("Mobile Phones");
        categories.add("Gaming Consoles");
        categories.add("Smart Watches");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spin.setAdapter(dataAdapter);
        f=findViewById(R.id.t1);
        s=findViewById(R.id.t2);
        t=findViewById(R.id.t3);
        a=findViewById((R.id.s1));
        b=findViewById((R.id.s2));
        f.setText("Lenovo Ideapad       In Stock");
        s.setText("HP Envy              In Stock");
        t.setText("Dell Inspiron     Out of Stock");

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainAisleMenu.class));
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        if(item=="Laptops"){
            f.setText("Lenovo Ideapad       In Stock");
            s.setText("HP Envy              In Stock");
            t.setText("Dell Inspiron     Out of Stock");

        }

        if(item=="Television Sets"){
            f.setText("LG Television       In Stock");
            s.setText("Samsung Curved TV   In Stock");
            t.setText("Sony Bravia     Out of Stock");


        }

        if(item=="Speaker Systems"){
            f.setText("Bose Home Theatre       In Stock");
            s.setText("Samsung Surround      In Stock");
            t.setText("JBL                Out of Stock");

        }


        if(item=="Mobile Phones"){
            f.setText("Iphone 11       In Stock");
            s.setText("Google Pixel 3      In Stock");
            t.setText("Oneplus 8 pro      Out of Stock");

        }

        if(item=="Gaming Consoles"){
            f.setText("PS4       In Stock");
            s.setText("XBOX One      In Stock");
            t.setText("Wii U2      Out of Stock");

        }

        if(item=="Smart Watches"){
            f.setText("FitBit Versa              In Stock");
            s.setText("Apple Smart Watch      In Stock");
            t.setText("Samsung Galaxy Watch   Out of Stock");

        }

        // Showing selected spinner item

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}

