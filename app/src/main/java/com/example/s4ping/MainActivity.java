package com.example.s4ping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    private EditText editn1;
    private EditText editn2;
    private EditText editn3;
    private  EditText editn4;
    private Button bPing;
    private  Button bHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //referencias

        editn1 = findViewById(R.id.editn1);
        editn2 = findViewById(R.id.editn2);
        editn3 = findViewById(R.id.editn3);
        editn4 = findViewById(R.id.editn4);
        bPing = findViewById(R.id.bPing);
        bHost = findViewById(R.id.bHost);


        bPing.setOnClickListener(
                (view)->{

                    String en1 = editn1.getText().toString();
                    String en2 = editn2.getText().toString();
                    String en3 = editn3.getText().toString();
                    String en4 = editn4.getText().toString();
                    String Ips = en1 + "."+en2+"."+en3+"."+en4;


                    Intent i = new Intent(this,PingActivity.class);
                    i.putExtra("Ips",Ips);
                    startActivity(i);

                }

        );

        bHost.setOnClickListener(
                (view)-> {

                    Intent p = new  Intent(this,HostActivity.class);

                    startActivity(p);
                }
        );






    }

}

