package com.example.antonio.encenderledwifi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Antonio on 13/04/2015.
 */
public class DialogoInformacion extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Instituto Tecnologico de Los Mochis\nIngenieria Mecatronica\nWatchDog S\n\n" +
                "Creadores:\nAntonio de Jesus Ortiz Gonzalez\nPedro Ruiz Soto\n" +
                "Serrano Sergio Arredondo\nJesus Alejandro Angel Verdugo")
                .setTitle("Informacion")
                .setIcon(R.drawable.informacion)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}
