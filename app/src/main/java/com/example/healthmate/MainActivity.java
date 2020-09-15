package com.example.healthmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

   private Button saveDataButton, loadDataButton;
   private EditText hospitalEditText, locationEditText;
   DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("user");

        saveDataButton = findViewById(R.id.saveDataButtonId);
        loadDataButton = findViewById(R.id.loadDataButtonId);

        hospitalEditText = findViewById(R.id.hospitalEditTextId);
        locationEditText = findViewById(R.id.locationEditTextId);

        loadDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }


        });
    }

        public void saveData()
        {
            String hospital = hospitalEditText.getText().toString().trim();
            String location = locationEditText.getText().toString().trim();

            String key = databaseReference.push().getKey();

            User user = new User(hospital, location);

            databaseReference.child(key).setValue(user);
            Toast.makeText(getApplicationContext(), "Hospital info is added", Toast.LENGTH_LONG).show();

            hospitalEditText.setText("");
            locationEditText.setText("");
        }

    }
