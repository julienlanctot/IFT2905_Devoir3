package com.example.devoir3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MessageView extends AppCompatActivity
{
    public static MessageView m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m = this;
        setContentView(R.layout.message_viewer);
    }
}
