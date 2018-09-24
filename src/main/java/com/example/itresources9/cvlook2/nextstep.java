package com.example.itresources9.cvlook2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.itresources9.cvlook2.Fragment.rabotadatelActivity;
import com.example.itresources9.cvlook2.Fragment.rabotaiskatelActivity;

public class nextstep extends FragmentActivity implements View.OnClickListener{

    Button rabotadatel,rabotaiskatel;
    EditText ettext;

    private Fragment fragmentRabotadatel;
    private Fragment fragmentRabotaiskatel;

    private FragmentManager managerl;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextstep);

        rabotadatel = (Button)findViewById(R.id.rabotadatel);
        rabotaiskatel = (Button)findViewById(R.id.rabotaiskatel);
        //ettext = (EditText)findViewById(R.id.vacanses);

        managerl = getSupportFragmentManager();


        fragmentRabotadatel = new rabotadatelActivity();
        fragmentRabotaiskatel = new rabotaiskatelActivity();






    }

    @Override
    public void onClick(View v) {
        transaction = managerl.beginTransaction();
        switch(v.getId()){
            case R.id.rabotadatel:
                transaction.add(R.id.container,fragmentRabotadatel);
            break;

            case R.id.rabotaiskatel:
                transaction.add(R.id.container,fragmentRabotaiskatel);
                break;
        }

        transaction.commit();

    }
}
