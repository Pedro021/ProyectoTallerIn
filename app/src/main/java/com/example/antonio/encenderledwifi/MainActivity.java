package com.example.antonio.encenderledwifi;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnSignIn;
    private Button btnSignUp;
    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarcomponentes();
        actionBar();

    }

    private void inicializarcomponentes() {
        btnSignIn = (Button) findViewById(R.id.btnSingIn);
        btnSignUp = (Button) findViewById(R.id.btnSingUp);

        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()){
            case R.id.btnSingIn:
                i = new Intent(this, SignInActivity.class);
                break;
            case R.id.btnSingUp:
                i = new Intent(this, SignUpActivity.class);
                break;
        }
        startActivity(i);
    }

    private void actionBar() {
        ab = getActionBar();
        ab.setDisplayShowTitleEnabled(false);
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
        }
        return super.onOptionsItemSelected(item);
    }

    //</editor-fold>
}
