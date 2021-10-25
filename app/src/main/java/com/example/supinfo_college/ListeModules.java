package com.example.supinfo_college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ListeModules extends AppCompatActivity {

    ListView lsLm;
    String matriculeListeMod,nomListeMod,volumeHoraireListeMod,dateDebutListeMod,dateFinListeMod,salleListeMod,professeurListeMod;
    HashMap<String,String> mapLm;
    ParametresModules pLm = new ParametresModules();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_module);

        lsLm = findViewById(R.id.ItemModules);

        Bundle extrasLm = getIntent().getExtras();
        if (extrasLm != null)
        {
            matriculeListeMod = extrasLm.getString("MatriculeMod");
            nomListeMod = extrasLm.getString("NomMod");
            volumeHoraireListeMod = extrasLm.getString("VolumeHoraireMod");
            dateDebutListeMod = extrasLm.getString("DateDebutMod");
            dateFinListeMod = extrasLm.getString("DateFinMod");
            salleListeMod = extrasLm.getString("SalleMod");
            professeurListeMod = extrasLm.getString("ProfesseurMod");


            mapLm = new HashMap<String, String>();
            mapLm.put("MatriculeMod",matriculeListeMod);
            mapLm.put("NomMod",nomListeMod);
            mapLm.put("VolumeHoraireMod",volumeHoraireListeMod);
            mapLm.put("DateDebutMod",dateDebutListeMod);
            mapLm.put("DateFinMod",dateFinListeMod);
            mapLm.put("SalleMod",salleListeMod);
            mapLm.put("ProfesseurMod",professeurListeMod);
            pLm.valuesMod.add(mapLm);
        }

        SimpleAdapter adapterLm = new SimpleAdapter(ListeModules.this,
                pLm.valuesMod,R.layout.liste_modules,new String[]{"MatriculeMod",
                "NomMod","VolumeHoraireMod", "DateDebutMod","DateFinMod","SalleMod",
                "ProfesseurMod"},
                new int[]{R.id.MatMod
                        });
        lsLm.setAdapter(adapterLm);

        lsLm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent Lm = new Intent(getApplicationContext(),DetailsModule.class);
                Lm.putExtra("position",i);
                startActivity(Lm);
            }
        });

    }
}