package com.example.androtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculButton = (Button) findViewById(R.id.button1);
        Button contactsButton = (Button) findViewById(R.id.button2);

        calculButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Calcul","Execution de la calculatrice");

                Intent calculIntent = new Intent(MainActivity.this, CalculActivity.class);
                startActivity(calculIntent);

            }
        });

        contactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Contacts","Execution des contacts");

                Intent contactsIntent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(contactsIntent);
            }
        });

    }
}
