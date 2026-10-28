package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogoutActivity extends AppCompatActivity {
    String tag = "Events";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.logout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.logout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.volverInicio);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(LogoutActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        TextView textView = findViewById(R.id.hastaPronto);
        textView.setText("Hasta pronto " + getIntent().getStringExtra("USUARIO") + "!");
    }

    public void onStart() {
        super.onStart();
        Log.d(tag, "A l'event onStart()");
    }

    public void onRestart() {
        super.onRestart();
        Log.d(tag, "A l'event onRestart()");
    }

    public void onResume() {
        super.onResume();
        Log.d(tag, "A l'event onResume()");
    }

    public void onPause() {
        super.onPause();
        Log.d(tag, "A l'event onPause()");
    }

    public void onStop() {
        super.onStop();
        Log.d(tag, "A l'event onStop()");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "A l'event onDestroy()");
    }
}
