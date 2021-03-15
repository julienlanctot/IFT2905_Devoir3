package com.example.devoir3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class Connexion extends AppCompatActivity {

    Button connexion;
    TextView email_textview;
    TextView password_textview;
    TextView result;
    TextView inscription;
    HashMap<String, String> test = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        connexion = findViewById(R.id.connexionBouton);
        email_textview = findViewById(R.id.Email);
        password_textview = findViewById(R.id.Password);
        result = findViewById(R.id.result);
        inscription = findViewById(R.id.inscription);

        connexion.setOnClickListener(connexion_listener);
        inscription.setOnClickListener(inscription_listener);
    }

   View.OnClickListener connexion_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            test.put("test", "test2");
            String username = email_textview.getText().toString();
            String password = password_textview.getText().toString();
            if(test.containsKey("test")) {
                if (test.get(username).equals(password)) {
                        result.setVisibility(View.VISIBLE);
                        result.setText(getResources().getString(R.string.Succes));
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText(getResources().getString(R.string.Echec));
                }
            }
            else{
                result.setVisibility(View.VISIBLE);
                result.setText(getResources().getString(R.string.NoExist));
            }
        }
    };


    View.OnClickListener inscription_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setContentView(R.layout.inscription);
        }

    };

}