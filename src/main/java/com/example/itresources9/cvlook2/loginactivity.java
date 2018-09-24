package com.example.itresources9.cvlook2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginactivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    EditText emaillogin,passwordlogin;
    Button buttonlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        mAuth = FirebaseAuth.getInstance();

        emaillogin = (EditText)findViewById(R.id.emaillogin);
        passwordlogin = (EditText)findViewById(R.id.password);

        buttonlogin = (Button)findViewById(R.id.loginbutton);

        buttonlogin.setOnClickListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentuser = mAuth.getCurrentUser();

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.loginbutton){
            login(emaillogin.getText().toString(),passwordlogin.getText().toString());
        }
    }

    public void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email,password);
    }

}
