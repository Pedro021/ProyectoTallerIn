package com.example.antonio.encenderledwifi;

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

                    //getActivity().startService(new Intent(getActivity(),TimbreService.class));
                    Log.d("TAG", "Arranca Servicio");

                }
                else
                {
                    //getActivity().stopService(new Intent(getActivity(),TimbreService.class));
                    Log.d("TAG","Detiene Servicio");
                }

                return true;
            }
        });
    }
}
