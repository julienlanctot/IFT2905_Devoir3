//Filtre

package org.techtown.recherche;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.myapplication2.R;

public class FilterActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FilterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        recyclerView = findViewById(R.id.recyclerView2);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FilterAdapter();

        adapter.addItem(new Filter("Intérêts"));
        adapter.addItem(new Filter("Cours"));
        adapter.addItem(new Filter("Club"));
        adapter.addItem(new Filter("Personne"));


        recyclerView.setAdapter(adapter);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
        Button applyFilter = findViewById(R.id.btnApplyFilter);
        applyFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        adapter.onBind = (viewHolder, position) -> {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.togCheckBox();
                }
            });
        };

    }
}
