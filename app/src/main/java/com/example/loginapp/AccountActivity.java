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

public class AccountActivity extends AppCompatActivity {
    String tag = "Events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.account), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String nombre = getIntent().getStringExtra("USUARIO");
        TextView bienvenido = findViewById(R.id.bienvenido);
        if (nombre != null && !nombre.isEmpty()) {
            bienvenido.setText("Bienvenido " + nombre);
        } else {
            bienvenido.setText("Bienvenido");
        }

        String email = getIntent().getStringExtra("EMAIL");
        TextView emailTextView = findViewById(R.id.email);
        if (email != null && !email.isEmpty()) {
            emailTextView.setText(email);
        } else {
            emailTextView.setText("Email no disponible");
        }
        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, LogoutActivity.class);
            intent.putExtra("USUARIO", nombre);
            startActivity(intent);
            finish();
        });
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
