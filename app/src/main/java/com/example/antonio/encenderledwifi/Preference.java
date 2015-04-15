package com.example.antonio.encenderledwifi;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.util.Log;

/**
 * Created by Antonio on 14/04/2015.
 */
public class Preference extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference);

        final SwitchPreference swGral;

        swGral = (SwitchPreference) findPreference("swGral");
        swGral.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(android.preference.Preference preference, Object o) {

                if(!swGral.isChecked())
                {
                    Log.d("TAG", "Arranca Servicio");
                    //getActivity().startService(new Intent(getActivity(), Servicio.class));
                }
                else
                {
                    Log.d("TAG", "Detiene Servicio");
                    //getActivity().stopService(new Intent(getActivity(), Servicio.class));
                }

                return true;
            }
        });

        final SwitchPreference swActividadCliente;

        swActividadCliente = (SwitchPreference) findPreference("swActividadCliente");
        swActividadCliente.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(android.preference.Preference preference, Object o) {

                if(!swGral.isChecked())
                {
                    Log.d("TAG", "Arranca Actividad Cliente");
                    getActivity().startActivity(new Intent(getActivity(), ActividadCliente.class));
                }
                else
                {

                }

                return true;
            }
        });
    }

}
