package com.example.antonio.encenderledwifi;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Antonio on 14/04/2015.
 */
public class Configuracion extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new Preference())
                .commit();
    }
}
