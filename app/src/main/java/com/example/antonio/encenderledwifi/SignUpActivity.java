package com.example.antonio.encenderledwifi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class SignUpActivity extends OrmLiteBaseActivity<DbHelper> implements View.OnClickListener {

    private EditText etUserName, etEmail, etPassword;
    private Button btnSignUp;
    DbHelper helper;
    Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        helper = OpenHelperManager.getHelper(this, DbHelper.class);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        etUserName = (EditText) findViewById(R.id.etUserName2);
        etEmail = (EditText) findViewById(R.id.etEmail2);
        etPassword = (EditText) findViewById(R.id.etPass2);
        btnSignUp = (Button) findViewById(R.id.btnSingUp2);

        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSingUp2) {
            //Comprobamos que no exista campos vacios
            if(!etEmail.getText().toString().trim().isEmpty() && !etUserName.getText().toString().trim().isEmpty()
                    && !etPassword.getText().toString().trim().isEmpty()) {
                try{
                    dao = getHelper().getUsuarioDao();
                    Usuario usser = new Usuario();
                    usser.setEmail(etEmail.getText().toString());
                    usser.setNombre(etUserName.getText().toString());
                    usser.setContrasena(etPassword.getText().toString());
                    dao.create(usser);
                    Toast.makeText(this, "Usuario creado: " + usser.getNombre(),Toast.LENGTH_SHORT).show();
                    //Si se crea el usuario abrimos la actividad SignIn
                    Intent i = new Intent(this, SignInActivity.class);
                    startActivity(i);
                }catch (SQLException e){
                    Toast.makeText(this, "No se pudo crear el usuario", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "Falta un campo", Toast.LENGTH_SHORT).show();

            }
        }
    }

    //<editor-fold desc="MENU">
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //</editor-fold>
}
