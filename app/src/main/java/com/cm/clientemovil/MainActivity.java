package com.cm.clientemovil;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendRequestButton = findViewById(R.id.btn_boton);

        sendRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ejecutar la solicitud HTTP usando Volley
                Solicitud();
            }
        });

    }

    private void Solicitud() {
        // Crear una nueva solicitud de tipo GET
        String url = "http://10.10.35.81:3000/mensaje"; // Cambia esto si usas un dispositivo físico, como http://192.168.x.x:3000/mensaje

        // Crear un StringRequest
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Si la solicitud es exitosa
                        Toast.makeText(MainActivity.this, "Respuesta del servidor: " + response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Si ocurre un error en la solicitud
                        Toast.makeText(MainActivity.this, "Error en la solicitud: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Crear un RequestQueue para gestionar la solicitud
        Volley.newRequestQueue(this).add(stringRequest);
    }
}