package com.example.lab4_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Button btnExecute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnExecute = findViewById(R.id.button); // Tìm lại button
        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNewActivity = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(iNewActivity);
                overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_move);
            }
        });
    }
}

