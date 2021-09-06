package com.example.s4ping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingActivity extends AppCompatActivity {
    private TextView textPing;
    private Button bRegresarDePing;
    private  Boolean conectado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping);
        //referenciar
        textPing = findViewById(R.id.textPing);
        bRegresarDePing = findViewById(R.id.bRegresarDePing);

        String Ips = getIntent().getExtras().getString("Ips");

        new Thread(
                () -> {
                    for (int i = 0; i < 4; i++) {
                        try {
                            InetAddress inetAddress = InetAddress.getByName(Ips);
                            String IpEscrita = inetAddress.getHostAddress();
                            //System.out.println(huawei);
                            Log.d("ipEscrita", "" + IpEscrita);

                            conectado = inetAddress.isReachable(500);

                            Log.d("conectado", "" + conectado);
                            runOnUiThread(
                                    () -> {
                                        if (conectado == true) {
                                            textPing.append("Recibido\n");
                                        } else {
                                            textPing.append("Perdido\n");
                                        }
                                    });
                            Thread.sleep(2000);

                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        bRegresarDePing.setOnClickListener(
                (view) -> {

                    Intent p = new Intent(this, MainActivity.class);



                    startActivity(p);
                });
    }

}