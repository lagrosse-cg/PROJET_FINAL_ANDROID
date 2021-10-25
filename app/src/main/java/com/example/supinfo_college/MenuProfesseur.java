package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuProfesseur extends AppCompatActivity {

    Button valider,afficher,retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_professeur);

        valider = findViewById(R.id.btnAjoutProf);
        afficher = findViewById(R.id.btnListeProf);
        retour = findViewById(R.id.btnRetourProf);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Aap = new Intent(getApplicationContext(),AjouterProfesseur.class);
                startActivity(Aap);
            }
        });

        afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Ale = new Intent(getApplicationContext(), ListeProfesseurs.class);
                startActivity(Ale);
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rap = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(rap);
            }
        });


    }
}