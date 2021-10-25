package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailsModule extends AppCompatActivity {

    EditText matriculeDetMod,nomDetMod,volumeHoraireDetMod,dateDebutDetMod,dateFinDetMod,salleDetMod,professeurDetMod;
    Button modifierDetMod,supprimerDetMod,retourDetMod;
    int position;
    ParametresModules pDm = new ParametresModules();
    HashMap<String,String> mDm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_module);

        matriculeDetMod = findViewById(R.id.txtMatriculeModDet);
        nomDetMod = findViewById(R.id.txtNomModDet);
        volumeHoraireDetMod = findViewById(R.id.txtVolHoraireModDet);
        dateDebutDetMod = findViewById(R.id.txtDateDebutModDet);
        dateFinDetMod = findViewById(R.id.txtDateFinModDet);
        salleDetMod = findViewById(R.id.txtSalleModDet);
        professeurDetMod = findViewById(R.id.txtProfesseurModDet);
        modifierDetMod = findViewById(R.id.btnModifierModDet);
        supprimerDetMod = findViewById(R.id.btnSupprimerModDet);
        retourDetMod = findViewById(R.id.btnRetourModDet);

        Bundle extrasDm = getIntent().getExtras();
        if (extrasDm != null)
        {
            position = extrasDm.getInt("position");
        }

        mDm = pDm.valuesMod.get(position);
        matriculeDetMod.setText(mDm.get("MatriculeMod"));
        nomDetMod.setText(mDm.get("NomMod"));
        volumeHoraireDetMod.setText(mDm.get("VolumeHoraireMod"));
        dateDebutDetMod.setText(mDm.get("DateDebutMod"));
        dateFinDetMod.setText(mDm.get("DateFinMod"));
        salleDetMod.setText(mDm.get("SalleMod"));
        professeurDetMod.setText(mDm.get("ProfesseurMod"));

        modifierDetMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDm.put("MatriculeDetMod",matriculeDetMod.getText().toString());
                mDm.put("NomDetMod",nomDetMod.getText().toString());
                mDm.put("VolumeHoraireDetMod",volumeHoraireDetMod.getText().toString());
                mDm.put("DateDebutDetMod",dateDebutDetMod.getText().toString());
                mDm.put("DateFinDetMod",dateFinDetMod.getText().toString());
                mDm.put("SalleDetMod",salleDetMod.getText().toString());
                mDm.put("ProfesseurDetMod",professeurDetMod.getText().toString());
                Intent moDm = new Intent(getApplicationContext(), ListeModules.class);
                startActivity(moDm);
                finish();
            }
        });

        supprimerDetMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pDm.valuesMod.remove(position);
                Intent suDm = new Intent(getApplicationContext(), ListeModules.class);
                startActivity(suDm);
                finish();
            }
        });

        retourDetMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reDm = new Intent(getApplicationContext(), MenuModule.class);
                startActivity(reDm);
                finish();
            }
        });


    }
}