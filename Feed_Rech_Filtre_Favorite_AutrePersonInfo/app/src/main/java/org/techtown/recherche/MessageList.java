package org.techtown.recherche;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.techtown.myapplication2.R;

import java.util.ArrayList;

public class MessageList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_list);

        ListView view = findViewById(R.id.listview);

        ArrayList<Messages> list = new ArrayList<>();

        list.add(new Messages("Pablo", getResources().getString(R.string.message3), "Il y a 5 min"));
        list.add(new Messages("Maya", getResources().getString(R.string.message4), "Hier à 3h00"));

        view.setAdapter(new customMessageAdapter(this,list));
    }
}