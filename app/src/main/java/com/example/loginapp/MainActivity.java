package com.example.loginapp;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String tag = "Events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> {
            EditText usuario = findViewById(R.id.usuario);
            EditText email = findViewById(R.id.email);
            EditText password = findViewById(R.id.password);

            String userText = (usuario != null) ? usuario.getText().toString().trim() : "";
            String emailText = (email != null) ? email.getText().toString().trim() : "";
            String passwordText = (password != null) ? password.getText().toString().trim() : "";
            if (userText.isEmpty()) {
                mostrarMensaje("El nombre de usuario no puede estar vacío");
            } else if (emailText.isEmpty()) {
                mostrarMensaje("El email no puede estar vacío");
            } else if (passwordText.isEmpty()) {
                mostrarMensaje("La contraseña no puede estar vacía");
            } else {
                Intent intent = new Intent(MainActivity.this, AccountActivity.class);
                intent.putExtra("USUARIO", userText);
                intent.putExtra("EMAIL", emailText);
                startActivity(intent);
                finish();
            }
        });
    }

    private void mostrarMensaje(String mensaje) {
        TextView error = findViewById(R.id.error);
        error.setVisibility(VISIBLE);
        error.setText(mensaje);
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