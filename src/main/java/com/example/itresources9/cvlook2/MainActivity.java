package com.example.itresources9.cvlook2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    Button login,registracia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        login = (Button)findViewById(R.id.login);
        registracia= (Button)findViewById(R.id.registr);

        login.setOnClickListener(this);
        registracia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.login:
                Intent intent = new Intent(MainActivity.this,registractivity.class);
                startActivity(intent);
                break;
                case R.id.registr:
                Intent intent2 = new Intent(MainActivity.this,registractivity.class);
                startActivity(intent2);
                break;
        }
    }
}
