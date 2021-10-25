package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ListeProfesseurs extends AppCompatActivity {

    ListView lsLp;
    String matriculeListProf,nomListProf,naissanceListProf,adresseListProf,telephoneListProf,emailListProf,classeListProf,moduleListProf;
    HashMap<String,String> mapLp;
    ParametresProfesseurs pLp = new ParametresProfesseurs();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_professeur);

        lsLp = findViewById(R.id.ItemProfesseurs);

        Bundle extrasLp = getIntent().getExtras();
        if (extrasLp != null)
        {
            matriculeListProf = extrasLp.getString("MatriculeProf");
            nomListProf = extrasLp.getString("NomProf");
            naissanceListProf = extrasLp.getString("NaissanceProf");
            adresseListProf = extrasLp.getString("AdresseProf");
            telephoneListProf = extrasLp.getString("TelephoneProf");
            emailListProf = extrasLp.getString("EmailProf");
            classeListProf = extrasLp.getString("ClasseProf");
            moduleListProf = extrasLp.getString("ModuleProf");

            mapLp = new HashMap<String, String>();
            mapLp.put("MatriculeProf",matriculeListProf);
            mapLp.put("NomProf",nomListProf);
            mapLp.put("NaissanceProf",naissanceListProf);
            mapLp.put("AdresseProf",adresseListProf);
            mapLp.put("TelephoneProf",telephoneListProf);
            mapLp.put("EmailProf",emailListProf);
            mapLp.put("ClasseProf",classeListProf);
            mapLp.put("ModuleProf",moduleListProf);
            pLp.valuesPro.add(mapLp);

        }

        SimpleAdapter adapterLp = new SimpleAdapter(ListeProfesseurs.this,
                pLp.valuesPro,R.layout.liste_professeurs,new String[]{"MatriculeProf"
                },
                new int[]{R.id.MatProf
                       });
        lsLp.setAdapter(adapterLp);

        lsLp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent Lp = new Intent(getApplicationContext(),DetailsProfesseur.class);
                Lp.putExtra("position",i);
                startActivity(Lp);
            }
        });
    }
}