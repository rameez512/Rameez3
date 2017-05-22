package com.example.seemy.assgmnt3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.seemy.assgmnt3.R.id.etpass;

public class Login extends AppCompatActivity implements View.OnClickListener {
  private Button Login,register;
    private EditText etEmail,etPass;
    private DbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=new DbHelper(this);

        Login =(Button)findViewById(R.id.btnlogin);
        register =(Button)findViewById(R.id.btnReg);
        etEmail=(EditText) findViewById(R.id.etEmail);
        etPass=(EditText) findViewById(etpass);

        Login.setOnClickListener(this);
        register.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnlogin:
                Intent i=new Intent(getApplicationContext(),Login.class);
startActivity(i);
            break;

            case R.id.btnReg:
                Intent b=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(b);
                break;


            default:

        }
    }
}
