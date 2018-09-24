package com.example.itresources9.cvlook2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registractivity extends Activity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    EditText emailtext,passwordtext;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registractivity);
        mAuth = FirebaseAuth.getInstance();

        emailtext= (EditText)findViewById(R.id.emailregistr);
        passwordtext = (EditText)findViewById(R.id.passwordregistr);

        next = (Button)findViewById(R.id.next);

        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.next){
            registr(emailtext.getText().toString(),passwordtext.getText().toString());
            Intent intent = new Intent(registractivity.this, uploadPhoto.class);
            startActivity(intent);


        }
    }
   public void registr(String mail,String password){
        mAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();

                }
            }
        });
   }
}
