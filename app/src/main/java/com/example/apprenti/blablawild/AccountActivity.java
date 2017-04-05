package com.example.apprenti.blablawild;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonDisconnect;
    private TextView textViewDisplayName;
    private TextView textViewEmail;
    private ImageView imageViewProfile;
    private FirebaseUser mFirebaseUser;
    private FirebaseAuth mAuth;
    private Button buttonMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        this.buttonDisconnect = (Button) findViewById(R.id.buttonDisconnect) ;
        this.buttonDisconnect.setOnClickListener(this);
        this.textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        this.textViewDisplayName = (TextView) findViewById(R.id.textViewDisplayName);
        this.imageViewProfile = (ImageView) findViewById(R.id.imageViewProfile);
        this.buttonMenu= (Button)findViewById(R.id.buttonMenu);
        this.buttonMenu.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();


        if (user == null){
            finish();
            startActivity(new Intent(this,SigninActivity.class));
        } else {

            textViewDisplayName.setText(user.getDisplayName());
            textViewEmail.setText(user.getEmail());


        }
    }

    @Override
    public void onClick(View v) {

            if (v ==buttonDisconnect){
                mAuth.signOut();
                FirebaseAuth.getInstance().signOut();
                finish();

                Intent intentToSigninActivity = new Intent(AccountActivity.this, SigninActivity.class);
                startActivity(intentToSigninActivity);
        }
        if (v == buttonMenu){
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}