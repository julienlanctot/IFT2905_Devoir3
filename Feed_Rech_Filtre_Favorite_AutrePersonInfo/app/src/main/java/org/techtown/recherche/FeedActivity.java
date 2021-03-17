package org.techtown.recherche;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.techtown.myapplication2.R;


    public class FeedActivity extends AppCompatActivity {

        RecyclerView recyclerView5;
        FeedAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.feed);
        /*
        Intent intent = new Intent();
        ComponentName name = new ComponentName(getApplicationContext(),
                RechercheActivity.class);
        intent.setComponent(name);
        startActivityForResult(intent, 101);
        */

            recyclerView5 = findViewById(R.id.recyclerView5);

            LinearLayoutManager layoutManager =
                    new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView5.setLayoutManager(layoutManager);
            adapter = new FeedAdapter();

            adapter.addItem(new Feed("Hellen", "Mais quelle belle journée!"));
            adapter.addItem(new Feed("Lee", "J'en peux plus de l'école! ZUT!"));
            adapter.addItem(new Feed("Sara", "Je pense donc je suis"));
            adapter.addItem(new Feed("Romeo", "Omae wa mou shindeiru"));
            adapter.addItem(new Feed("Romeo", "skd"));
            adapter.addItem(new Feed("Romeo", "skd"));



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

