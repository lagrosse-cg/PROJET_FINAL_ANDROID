package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailsEtudiant extends AppCompatActivity {

    EditText matriculeDetEtud,nomDetEtud,naissanceDetEtud,adresseDetEtud,telephoneDetEtud,emailDetEtud,classeDetEtud;
    Button modifierDetEtud,supprimerDetEtud,retourDetEtud;
    int position;
    ParametresEtudiants pDe = new ParametresEtudiants();
    HashMap<String,String> mDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_etudiant);

        matriculeDetEtud = findViewById(R.id.txtMatricule);
        nomDetEtud = findViewById(R.id.txtNomEtudDet);
        naissanceDetEtud = findViewById(R.id.txtNaissanceEtudDet);
        adresseDetEtud = findViewById(R.id.txtAdresseEtudDet);
        telephoneDetEtud = findViewById(R.id.txtTelephoneEtudDet);
        emailDetEtud = findViewById(R.id.txtEmailEtudDet);
        classeDetEtud = findViewById(R.id.txtClasseEtudDet);
        modifierDetEtud = findViewById(R.id.btnModifierEtud);
        supprimerDetEtud = findViewById(R.id.btnSupprimerEtud);
        retourDetEtud = findViewById(R.id.btnRetourEtudDet);

        Bundle extrasDe = getIntent().getExtras();
        if (extrasDe != null)
        {
            position = extrasDe.getInt("position");
        }
        mDe = ParametresEtudiants.values.get(position);
        matriculeDetEtud.setText(mDe.get("MatriculeEt"));
        nomDetEtud.setText(mDe.get("NomEt"));
        naissanceDetEtud.setText(mDe.get("NaissanceEt"));
        adresseDetEtud.setText(mDe.get("AdresseEt"));
        telephoneDetEtud.setText(mDe.get("TelephoneEt"));
        emailDetEtud.setText(mDe.get("EmailEt"));
        classeDetEtud.setText(mDe.get("ClasseEt"));

        modifierDetEtud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDe.put("MatriculeDetEtud",matriculeDetEtud.getText().toString());
                mDe.put("NomDetEtud",nomDetEtud.getText().toString());
                mDe.put("NaissanceDetEtud",naissanceDetEtud.getText().toString());
                mDe.put("AdresseDetEtud",adresseDetEtud.getText().toString());
                mDe.put("TelephoneDetEtud",telephoneDetEtud.getText().toString());
                mDe.put("EmailDetEtud",emailDetEtud.getText().toString());
                mDe.put("ClasseDetEtud",classeDetEtud.getText().toString());
                Intent moDe = new Intent(getApplicationContext(), ListeEtudiants.class);
                startActivity(moDe);
                finish();
            }
        });

        supprimerDetEtud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pDe.values.remove(position);
                Intent suDe = new Intent(getApplicationContext(), ListeEtudiants.class);
                startActivity(suDe);
                finish();
            }
        });

        retourDetEtud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reDe = new Intent(getApplicationContext(), MenuEtudiants.class);
                startActivity(reDe);
                finish();
            }
        });
    }
}