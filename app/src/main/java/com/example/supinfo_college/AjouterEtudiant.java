package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AjouterEtudiant extends AppCompatActivity {

    EditText matriculeEt,nomEt,naissanceEt,adresseEt,telephoneEt,emailEt,classeEt;
    Button ajoutEt, retourEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_etudiants);

        matriculeEt = findViewById(R.id.txtMatEtud);
        nomEt = findViewById(R.id.txtNomEtud);
        naissanceEt = findViewById(R.id.txtNaissEtud);
        adresseEt = findViewById(R.id.txtAdresseEtud);
        telephoneEt = findViewById(R.id.txtTelephoneEtud);
        emailEt = findViewById(R.id.txtEmailEtud);
        classeEt = findViewById(R.id.txtClasseEtud);
        ajoutEt = findViewById(R.id.btnAjouterEtud);
        retourEt = findViewById(R.id.btnRetourEtAj);

        ajoutEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ae = new Intent(getApplicationContext(), ListeEtudiants.class);
                ae.putExtra("MatriculeEt",matriculeEt.getText().toString());
                ae.putExtra("NomEt",nomEt.getText().toString());
                ae.putExtra("NaissanceEt",naissanceEt.getText().toString());
                ae.putExtra("AdresseEt",adresseEt.getText().toString());
                ae.putExtra("TelephoneEt",telephoneEt.getText().toString());
                ae.putExtra("EmailEt",emailEt.getText().toString());
                ae.putExtra("ClasseEt",classeEt.getText().toString());
                startActivity(ae);
            }
        });

        retourEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent re = new Intent(getApplicationContext(), MenuEtudiants.class);
                startActivity(re);
                finish();
            }
        });
    }
}