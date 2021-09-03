package com.example.timemanagementtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Timer extends AppCompatActivity {

    EditText assignment, date;
    Button back, insert, view;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(Timer.this, SecondActivity.class);
                startActivity(R);
                finish();
            }
        });

        assignment = findViewById(R.id.assignment);
        date = findViewById(R.id.date);

        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);

        db = new Database(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String assignmentTXT = assignment.getText().toString();
                String dateTXT = date.getText().toString();

                Boolean checkinsertdata = db.insertuserdata(assignmentTXT, dateTXT);
                if(checkinsertdata==true)
                    Toast.makeText(Timer.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Timer.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
    }
}