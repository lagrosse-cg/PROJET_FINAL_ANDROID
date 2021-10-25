package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuEtudiants extends AppCompatActivity {

    Button valider,afficher, retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_etudiants);

        valider = findViewById(R.id.btnAjoutEtud);
        afficher = findViewById(R.id.btnListeEtud);
        retour = findViewById(R.id.btnRetourEtud);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Aae = new Intent(getApplicationContext(), AjouterEtudiant.class);
                startActivity(Aae);
            }
        });
        afficher.setOnClickListener(view -> {
            Intent Ale = new Intent(getApplicationContext(), ListeEtudiants.class);
            startActivity(Ale);
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rae = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(rae);
            }
        });

    }
}