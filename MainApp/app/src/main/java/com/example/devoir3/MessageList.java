package com.example.devoir3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MessageList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_list);

        ListView view = findViewById(R.id.listview);

        ArrayList<Messages> list = new ArrayList<>();

        list.add(new Messages("Pablo", "Hello dear", "Hier à 3h00", "yoloswag"));
        list.add(new Messages("Pablo", "Hello dear", "Hier à 3h00", "yoloswag"));
        list.add(new Messages("Pablo", "Hello dear", "Hier à 3h00", "yoloswag"));

        view.setAdapter(new customMessageAdapter(this,list));


    }
}