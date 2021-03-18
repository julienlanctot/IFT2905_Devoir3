package org.techtown.recherche;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.myapplication2.R;

public class FriendActivity extends AppCompatActivity {


    RecyclerView recyclerView6;
    FriendAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend);

        recyclerView6 = findViewById(R.id.recyclerView6);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView6.setLayoutManager(layoutManager);
        adapter = new FriendAdapter();

        adapter.addItem(new Friend("Hellen", "Hi"));
        adapter.addItem(new Friend("Romeo", "Bye"));


        recyclerView6.setAdapter(adapter);

        adapter.onBind = (viewHolder, position) -> {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FriendActivity.this,ProfilAutreActivity.class);
                    FriendActivity.this.startActivityForResult(intent,101);
                }
            });
        };

        ImageButton btnSearch = findViewById(R.id.btnSearch3);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FriendActivity.this, RechercheActivity.class);
                FriendActivity.this.startActivityForResult(intent, 102);
            }
        });

        ImageButton btnHome = findViewById(R.id.btnBack5);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FriendActivity.this, FeedActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        ImageButton btnChat = findViewById(R.id.btnChat);
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FriendActivity.this, MessageList.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
