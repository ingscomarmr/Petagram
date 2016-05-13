package com.omunguia.petagram;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout srlRefresIndicator;
    private ListView lvPlanetasLista;
    private Adapter adapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //para soporte de actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        //findViewById busca el codigo generado por el xml y lo ocupa porque ya existe en memoria
        srlRefresIndicator = (SwipeRefreshLayout)findViewById(R.id.srlRefresIndicator);
        lvPlanetasLista = (ListView)findViewById(R.id.lvPlanetasLista);

        //para llenar la lista necesitamos un adaptador
        String[] planetas = getResources().getStringArray(R.array.planetas_lista);
        lvPlanetasLista.setAdapter(new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,planetas));

        srlRefresIndicator.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        //lvPlanetasLista.setAdapter(new ArrayAdapter<String>());
    }


    public void onClickSnakbar(View v){
        //simple snackbar
        Snackbar.make(v,"Test",Snackbar.LENGTH_LONG).show();
    }

    public void onClickAgregarElemento(View v){
        //Snackbar con mas cosas
        Snackbar.make(v,getResources().getString(R.string.editar_view_des),Snackbar.LENGTH_LONG).setAction(getResources().getString(R.string.editar_view), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Enviando a otra pantalla
                Intent intentEditar = new Intent(MainActivity.this,EditarActivity.class);
                startActivity(intentEditar);
            }
        }).show();
    }

}
