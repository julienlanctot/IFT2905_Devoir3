package com.example.profil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button infoPersoBtn = (Button)findViewById(R.id.infoBtn);
        Button notificationBtn = (Button)findViewById(R.id.notiBtn);
        Button contactsBtn = (Button)findViewById(R.id.contactBtn);
        Button favBtn = (Button) findViewById(R.id.favBtn);

        infoPersoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Info_Perso.class);
                startActivity(startIntent);
            }

        });

        contactsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Notifications.class);
                startActivity(startIntent);
            }
        });

        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Notifications.class);
                startActivity(startIntent);
            }
        });

    }
}