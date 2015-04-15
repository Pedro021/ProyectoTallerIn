package com.example.antonio.encenderledwifi;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ActividadCliente extends Activity {

    private TextView tvServerMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_cliente);

        tvServerMsg = (TextView) findViewById(R.id.tvServerMsg);

        ClienteAsyncTask clienteAST = new ClienteAsyncTask();

        //TODO: Aqui vas a poner el IP del servidor, el puerto del servidor y el mensaje que le quieres enviar al servidor
        //Pasamos el IP del servidor, el puerto y el mensaje del cliente a la tarea Asicrona
        clienteAST.execute(new String[]{"IP del server, portDelServer", "Msg a enviar al server"});
    }

    //<editor-fold desc="MENU">
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_cliente, menu);
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

    private class ClienteAsyncTask extends AsyncTask<String,    //Parametros que recibe
            Void,                                               //Progreso de la tarea en segundo plano
            String>{                                            //Parametros que devuelve

        @Override
        protected String doInBackground(String... params) {
            String result = null;
            try{
                //Socket cliente al cual le definimos la direccion IP y el puerto del servidor
                Socket socket = new Socket(params[0],Integer.parseInt(params[1]));

                //Obtener flujo de datos de entrada
                InputStream is = socket.getInputStream();

                //Obtener el flujo de salida del socket cliente
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

                //Datos de escritura en el flujo de salida del socket cliente
                out.println(params[2]);

                //Buffer que contiene los datos provenientes del servidor
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                //Leer datos del flujo de entrada
                result = br.readLine();

                //Cerramos el socket de cliente
                socket.close();

            }catch (NumberFormatException e){
                e.printStackTrace();
            } catch (UnknownHostException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

            //Duelve lo que contenga la variable result, para que lo reciba el metodo
            //onPostExecute y asi mostrarlo en el TextView
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            //Escribe el mensaje del server en el text view
            tvServerMsg.setText(s);
        }
    }
}
