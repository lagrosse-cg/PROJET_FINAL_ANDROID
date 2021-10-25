package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuModule extends AppCompatActivity {

    Button valider,afficher, retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_module);

        valider = findViewById(R.id.btnAjoutModule);
        afficher = findViewById(R.id.btnListeModules);
        retour = findViewById(R.id.btnRetourmod);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Am = new Intent(getApplicationContext(),AjouterModule.class);
                startActivity(Am);
            }
        });

        afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Ale = new Intent(getApplicationContext(), ListeModules.class);
                startActivity(Ale);
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ram = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(ram);
            }
        });

    }
}