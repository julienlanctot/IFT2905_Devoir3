package org.techtown.recherche;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.techtown.myapplication2.R;

import java.util.ArrayList;

public class customMessageAdapter extends ArrayAdapter<Messages> {

    private Context c;

    public customMessageAdapter(Context context, ArrayList<Messages> messages) {
        super(context, 0, messages);
        this.c = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Source of code : https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView

        // Get the data item for this position
        Messages message = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.rows, parent, false);
        }
        // Lookup view for data population
        TextView username = (TextView) convertView.findViewById(R.id.username);
        TextView lastText = (TextView) convertView.findViewById(R.id.lastText);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        ImageView img = (ImageView) convertView.findViewById(R.id.message_image);
        // Populate the data into the template view using the data object
        username.setText(message.user);
        lastText.setText(message.lastText);
        date.setText(message.date);
        img.setImageResource(R.drawable.profile);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageView.class);
                c.startActivity(intent);
            }
        });
        return convertView;
    }
}