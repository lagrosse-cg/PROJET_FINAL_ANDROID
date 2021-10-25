package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button AcceuilEtudiant,AcceuilProfesseurs,AcceuilModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AcceuilEtudiant = findViewById(R.id.btnEtudiants);
        AcceuilProfesseurs = findViewById(R.id.btnProf);
        AcceuilModule = findViewById(R.id.btnModules);

        AcceuilEtudiant.setOnClickListener(view -> {
            Intent Ae = new Intent(getApplicationContext(), MenuEtudiants.class);
            startActivity(Ae);
        });

        AcceuilProfesseurs.setOnClickListener(view -> {
            Intent Ap = new Intent(getApplicationContext(), MenuProfesseur.class);
            startActivity(Ap);
        });

        AcceuilModule.setOnClickListener(view -> {
            Intent Am = new Intent(getApplicationContext(), MenuModule.class);
            startActivity(Am);
        });
    }
}