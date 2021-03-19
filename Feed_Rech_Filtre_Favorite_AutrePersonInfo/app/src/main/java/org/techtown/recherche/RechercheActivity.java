//Recherche

package org.techtown.recherche;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.myapplication2.R;

public class RechercheActivity extends AppCompatActivity {

    RecyclerView recyclerView3;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche);

        recyclerView3 = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView3.setLayoutManager(layoutManager);
        adapter = new PersonAdapter();

        adapter.addItem(new Person("Hellen", "Hi"));
        adapter.addItem(new Person("Romeo", "Bye"));


        recyclerView3.setAdapter(adapter);

        Button btnFilter = findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                ComponentName name = new ComponentName(getApplicationContext(),
                        FilterActivity.class);
                intent.setComponent(name);
                startActivityForResult(intent, 101);
            }

        });

        ImageButton btnFavorite3 = findViewById(R.id.btnFavorite3);
        btnFavorite3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RechercheActivity.this, FriendActivity.class);
                RechercheActivity.this.startActivityForResult(intent, 103);
            }
        });

        ImageButton btnHome = findViewById(R.id.btnBack);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RechercheActivity.this, FeedActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        ImageButton btnChat = findViewById(R.id.btnChat);
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RechercheActivity.this, MessageList.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        ImageButton myProfile = findViewById(R.id.btnMyProfil);
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RechercheActivity.this, ProfilActivity.class);
                RechercheActivity.this.startActivityForResult(intent, 102);
            }
        });

        adapter.onBind = (viewHolder, position) -> {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RechercheActivity.this,ProfilAutreActivity.class);
                    RechercheActivity.this.startActivityForResult(intent,101);
                }
            });
        };
    }
}
