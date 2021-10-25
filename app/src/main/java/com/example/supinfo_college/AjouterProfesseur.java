package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AjouterProfesseur extends AppCompatActivity {

    EditText matriculeProf,nomProf,naissanceProf,adresseProf,telephoneProf,emailProf,classeProf,moduleProf;
    Button ajoutProf, retourProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_professeur);

        matriculeProf = findViewById(R.id.txtMatriculeProf);
        nomProf = findViewById(R.id.txtNomProf);
        naissanceProf = findViewById(R.id.txtNaissanceProf);
        adresseProf = findViewById(R.id.txtAdresseProf);
        telephoneProf = findViewById(R.id.txtTelephoneProf);
        emailProf = findViewById(R.id.txtEmailProf);
        classeProf = findViewById(R.id.txtClasseProf);
        moduleProf = findViewById(R.id.txtModuleProf);
        ajoutProf = findViewById(R.id.btnAjouterProf);
        retourProf = findViewById(R.id.btnRetourProfAj);

        ajoutProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aP = new Intent(getApplicationContext(), ListeProfesseurs.class);
                aP.putExtra("MatriculeProf",matriculeProf.getText().toString());
                aP.putExtra("NomProf",nomProf.getText().toString());
                aP.putExtra("NaissanceProf",naissanceProf.getText().toString());
                aP.putExtra("AdresseProf",adresseProf.getText().toString());
                aP.putExtra("TelephoneProf",telephoneProf.getText().toString());
                aP.putExtra("EmailProf",emailProf.getText().toString());
                aP.putExtra("ClasseProf",classeProf.getText().toString());
                aP.putExtra("ModuleProf",moduleProf.getText().toString());
                startActivity(aP);
            }
        });

        retourProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = new Intent(getApplicationContext(), MenuProfesseur.class);
                startActivity(r);
                finish();
            }
        });
    }
}