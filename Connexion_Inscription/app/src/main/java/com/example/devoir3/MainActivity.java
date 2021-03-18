package com.example.devoir3;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button connexion;
    Button confirm_inscription;
    TextView email_textview;
    TextView password_textview;
    TextView result;
    TextView inscription;
    TextView result_inscription;
    TextView email_inscription;
    TextView password_inscription;
    TextView confirm_password;
    HashMap<String, String> test = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            confirm_inscription = findViewById(R.id.conifrmerInscription);
            result_inscription = findViewById(R.id.message_inscription);
            email_inscription = findViewById(R.id.email_input);
            password_inscription = findViewById(R.id.motdepasseInscription2);
            confirm_password = findViewById(R.id.motdepasse_confirmer2);

            confirm_inscription.setOnClickListener(inscription_confirm);

        }
    };

    View.OnClickListener inscription_confirm = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(!isValidEmail(email_inscription.getText().toString()))
            {
                result_inscription.setVisibility(View.VISIBLE);
                result_inscription.setTextColor(getResources().getColor(R.color.red));
                result_inscription.setText("Format d'email invalide");
            }
            else if(!password_inscription.getText().toString().equals(confirm_password.getText().toString()))
            {
                result_inscription.setVisibility(View.VISIBLE);
                result_inscription.setTextColor(getResources().getColor(R.color.red));
                result_inscription.setText("Les 2 mots de passe doivent être identiques");
            }
            else{
                setContentView(R.layout.inscription_interets);
            }
        }
    };
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }







}