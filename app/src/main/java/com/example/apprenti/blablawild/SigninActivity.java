package com.example.apprenti.blablawild;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import static com.example.apprenti.blablawild.R.id.editTextEmail;
import static com.example.apprenti.blablawild.R.id.editTextPseudo;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private EditText editextEmail;
    private EditText editTextPassword;
    private Button buttonSignup;
    private Button buttonSeConnecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        firebaseAuth = FirebaseAuth.getInstance();

        editextEmail = (EditText) findViewById(editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignup = (Button) findViewById(R.id.buttonSignup);
        buttonSignup.setOnClickListener(this);
        buttonSeConnecter = (Button) findViewById(R.id.buttonSeConnecter);
        buttonSeConnecter.setOnClickListener(this);


    }

    public void login() {
        String password = editTextPassword.getText().toString();
        String email = editextEmail.getText().toString();


        if (TextUtils.isEmpty(password)) {
            Toast.makeText(SigninActivity.this, R.string.motdepasse, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(SigninActivity.this, "tu n'as pas remplis ton e-mail", Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SigninActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intentSeConnecter = new Intent(SigninActivity.this, MainActivity.class);
                            startActivity(intentSeConnecter);
                            finish();

                        }

                        // ...
                    }
                });
    }


    @Override
    public void onClick(View v) {

        if (v == buttonSignup) {
            Intent intentSignup = new Intent(SigninActivity.this, Signup.class);
            startActivity(intentSignup);
            finish();
        }

        if (v == buttonSeConnecter) {
            login();

        }

    }
}

