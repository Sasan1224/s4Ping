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

public class HostActivity extends AppCompatActivity {
    private TextView textHost;
    private Button bRegresarDeHost;
    private String aiuda;
    private int digito = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        textHost = findViewById(R.id.textHost);
        bRegresarDeHost = findViewById(R.id.bRegresarDeHost);



    new Thread(
            () -> {
                while (digito < 255) {

                    try {
                        aiuda = "192.168.0." + digito;
                        InetAddress i = InetAddress.getByName(aiuda);
                        Boolean p = i.isReachable(500);

                        runOnUiThread(
                                ()->{
                                    if (p == true) {
                                        textHost.append("" + aiuda+"\n");
                                    }
                                }
                        );
                        digito++;
                        Log.d("cuenta",""+digito);

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                }
            }

        }
    ).start();




        bRegresarDeHost.setOnClickListener(
                (view)->{
                    Intent i = new Intent(this,MainActivity.class);
                    startActivity(i);
                }

        );

    }

}