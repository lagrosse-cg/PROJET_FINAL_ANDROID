package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ListeEtudiants extends AppCompatActivity {

    ListView lsLe;
    String matriculeListEt,nomListEt,naissanceListEt,adresseListEt,telephoneListEt,emailListEt,classeListEt;
    HashMap<String,String> mapLe;
    ParametresEtudiants pLe = new ParametresEtudiants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_etudiant);

        lsLe = findViewById(R.id.ItemEtudiants);

        Bundle extrasLe = getIntent().getExtras();
        if (extrasLe != null)
        {
            matriculeListEt = extrasLe.getString("MatriculeEt");
            nomListEt = extrasLe.getString("NomEt");
            naissanceListEt = extrasLe.getString("NaissanceEt");
            adresseListEt = extrasLe.getString("AdresseEt");
            telephoneListEt = extrasLe.getString("TelephoneEt");
            emailListEt = extrasLe.getString("EmailEt");
            classeListEt = extrasLe.getString("ClasseEt");

            mapLe = new HashMap<String, String>();
            mapLe.put("MatriculeEt",matriculeListEt);
            mapLe.put("NomEt",nomListEt);
            mapLe.put("NaissanceEt",naissanceListEt);
            mapLe.put("AdresseEt",adresseListEt);
            mapLe.put("TelephoneEt",telephoneListEt);
            mapLe.put("EmailEt",emailListEt);
            mapLe.put("ClasseEt",classeListEt);
            pLe.values.add(mapLe);

        }

        SimpleAdapter adapterLe = new SimpleAdapter(ListeEtudiants.this,
                pLe.values,R.layout.liste_etudiants,new String[]{"MatriculeEt"
                },
                new int[]{R.id.MatEtu
                });
        lsLe.setAdapter(adapterLe);

        lsLe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent Le = new Intent(getApplicationContext(),DetailsEtudiant.class);
                Le.putExtra("position",i);
                startActivity(Le);
            }
        });
    }
}