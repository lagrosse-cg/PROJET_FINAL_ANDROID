package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AjouterModule extends AppCompatActivity {

    EditText matriculeMod,nomMod,volumeHoraireMod,dateDebutMod,dateFinMod,salleMod,professeurMod;
    Button ajoutMod, retourMod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_module);

        matriculeMod = findViewById(R.id.txtMatriculeMod);
        nomMod = findViewById(R.id.txtNomMod);
        volumeHoraireMod = findViewById(R.id.txtVolHoraireMod);
        dateDebutMod = findViewById(R.id.txtDateDebutMod);
        dateFinMod = findViewById(R.id.txtDateFinMod);
        salleMod = findViewById(R.id.txtSalleMod);
        professeurMod = findViewById(R.id.txtProfesseurMod);
        ajoutMod = findViewById(R.id.btnAjouterMod);
        retourMod = findViewById(R.id.btnRetourMod);

        ajoutMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent am = new Intent(getApplicationContext(), ListeModules.class);
                am.putExtra("MatriculeMod",matriculeMod.getText().toString());
                am.putExtra("NomMod",nomMod.getText().toString());
                am.putExtra("VolumeHoraireMod",volumeHoraireMod.getText().toString());
                am.putExtra("DateDebutMod",dateDebutMod.getText().toString());
                am.putExtra("DateFinMod",dateFinMod.getText().toString());
                am.putExtra("SalleMod",salleMod.getText().toString());
                am.putExtra("ProfesseurMod",professeurMod.getText().toString());
                startActivity(am);
            }
        });

        retourMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rm = new Intent(getApplicationContext(), MenuModule.class);
                startActivity(rm);
                finish();
            }
        });

    }
}