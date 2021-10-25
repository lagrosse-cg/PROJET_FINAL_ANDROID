package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailsProfesseur extends AppCompatActivity {

    EditText matriculeDetProf,nomDetProf,naissanceDetProf,adresseDetProf,telephoneDetProf,emailDetProf,classeDetProf,moduleDetProf;
    Button modifierDetProf,supprimerDetProf,retourDetProf;
    int position;
    ParametresProfesseurs pDp = new ParametresProfesseurs();
    HashMap<String,String> mDp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_professeur);

        matriculeDetProf = findViewById(R.id.txtMatriculePofDet);
        nomDetProf = findViewById(R.id.txtNomProfDet);
        naissanceDetProf = findViewById(R.id.txtNaissProfDet);
        adresseDetProf = findViewById(R.id.txtAdresseProfDet);
        telephoneDetProf = findViewById(R.id.txtTelephoneProfDet);
        emailDetProf = findViewById(R.id.txtEmailProfDet);
        classeDetProf = findViewById(R.id.txtClasseProfDet);
        moduleDetProf = findViewById(R.id.txtModuleProfDet);
        modifierDetProf = findViewById(R.id.btnModifierProfDet);
        supprimerDetProf = findViewById(R.id.btnSupprimerProfDet);
        retourDetProf = findViewById(R.id.btnRetourProfDet);

        Bundle extrasDp = getIntent().getExtras();
        if (extrasDp != null)
        {
            position = extrasDp.getInt("position");
        }
        mDp = pDp.valuesPro.get(position);
        matriculeDetProf.setText(mDp.get("MatriculeProf"));
        nomDetProf.setText(mDp.get("NomProf"));
        naissanceDetProf.setText(mDp.get("NaissanceProf"));
        adresseDetProf.setText(mDp.get("AdresseProf"));
        telephoneDetProf.setText(mDp.get("TelephoneProf"));
        emailDetProf.setText(mDp.get("EmailProf"));
        classeDetProf.setText(mDp.get("ClasseProf"));
        moduleDetProf.setText(mDp.get("ModuleProf"));

        modifierDetProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDp.put("MatriculeProf",matriculeDetProf.getText().toString());
                mDp.put("NomProf",nomDetProf.getText().toString());
                mDp.put("NaissanceProf",naissanceDetProf.getText().toString());
                mDp.put("AdresseProf",adresseDetProf.getText().toString());
                mDp.put("TelephoneProf",telephoneDetProf.getText().toString());
                mDp.put("EmailProf",emailDetProf.getText().toString());
                mDp.put("ClasseProf",classeDetProf.getText().toString());
                mDp.put("ModuleProf",moduleDetProf.getText().toString());
                Intent moDp = new Intent(getApplicationContext(), ListeProfesseurs.class);
                startActivity(moDp);
                finish();
            }
        });

        supprimerDetProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pDp.valuesPro.remove(position);
                Intent suDp = new Intent(getApplicationContext(), ListeProfesseurs.class);
                startActivity(suDp);
                finish();
            }
        });

        retourDetProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reDp = new Intent(getApplicationContext(), MenuProfesseur.class);
                startActivity(reDp);
                finish();
            }
        });

    }
}