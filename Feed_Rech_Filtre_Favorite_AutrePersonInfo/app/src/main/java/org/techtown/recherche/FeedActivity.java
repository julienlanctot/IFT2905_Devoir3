package org.techtown.recherche;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import org.techtown.myapplication2.R;


    public class FeedActivity extends AppCompatActivity {

        RecyclerView recyclerView5;
        FeedAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.feed);


            recyclerView5 = findViewById(R.id.recyclerView5);

            LinearLayoutManager layoutManager =
                    new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView5.setLayoutManager(layoutManager);
            adapter = new FeedAdapter();

            adapter.addItem(new Feed("Hellen", "Mais quelle belle journée!"));
            adapter.addItem(new Feed("Lee", "J'aime l'école!"));
            adapter.addItem(new Feed("Sara", "Je pense donc je suis"));
            adapter.addItem(new Feed("Romeo", "Omae wa mou shindeiru"));




            recyclerView5.setAdapter(adapter);
            ImageButton btnSearch = findViewById(R.id.btnSearch2);
            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FeedActivity.this, RechercheActivity.class);
                    FeedActivity.this.startActivityForResult(intent, 102);
                }
            });

            ImageButton btnFavorite2 = findViewById(R.id.btnFavorite2);
            btnFavorite2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FeedActivity.this, FriendActivity.class);
                    FeedActivity.this.startActivityForResult(intent, 103);
                }
            });

            ImageButton btnChat = findViewById(R.id.btnChat);
            btnChat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FeedActivity.this, MessageList.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });

            adapter.onBind = (viewHolder, position) -> {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(FeedActivity.this,ProfilAutreActivity.class);
                        FeedActivity.this.startActivityForResult(intent,101);
                    }
                });
            };


        }

    }

