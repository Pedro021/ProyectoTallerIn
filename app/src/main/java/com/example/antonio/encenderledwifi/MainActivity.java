package com.example.antonio.encenderledwifi;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar();

    }

    private void actionBar() {
        ab = getActionBar();                        //Se crea la Action Bar
        ab.setDisplayShowHomeEnabled(true);         //Se muestra el icono de la App
        ab.setDisplayHomeAsUpEnabled(true);         //Se muestra el boton de retroceso
        ab.setHomeButtonEnabled(true);              //Se habilita el boton de retroceso
        ab.setDisplayShowTitleEnabled(false);       //Se oculta el titulo de la App
        ab.show();
    }

    //<editor-fold desc="MENU">
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                FragmentManager fragmentManager = getFragmentManager();
                DialogoInformacion dialogo = new DialogoInformacion();
                dialogo.show(fragmentManager, "TAG");
                break;
            case R.id.Connect:
                //TODO: Hacer clase de conexion ethernet
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //</editor-fold>
}
