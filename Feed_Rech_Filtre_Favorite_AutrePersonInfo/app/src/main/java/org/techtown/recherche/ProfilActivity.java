package org.techtown.recherche;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.techtown.myapplication2.R;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Button infoPersoBtn = (Button)findViewById(R.id.profile_btn1);
        Button notificationBtn = (Button)findViewById(R.id.profile_btn2);
        Button contactsBtn = (Button)findViewById(R.id.profile_btn3);
        Button favBtn = (Button) findViewById(R.id.profile_btn4);
        ImageButton backBtn = (ImageButton) findViewById(R.id.btnBack);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(ProfilActivity.this, FeedActivity.class);
                startActivity(intent);
            }
        });

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