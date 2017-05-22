package com.example.seemy.assgmnt3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
  private Button reg;
    private TextView tvlogin;
    private EditText etEmail,etpass;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db= new DbHelper(this);
        reg =(Button)findViewById(R.id.btnReg);
        tvlogin=(TextView) findViewById(R.id. tvlogin);
        etEmail=(EditText) findViewById(R.id.etEmail);
        etpass=(EditText) findViewById(R.id.etpass);


        reg.setOnClickListener(this);
        tvlogin.setOnClickListener(this);

    }
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btnReg:

                break;

            case R.id.tvlogin:

                break;
            default:

        }

    }
    private void register() {
    String email=etEmail.getText().toString();
        String pass =etpass.getText().toString();
      if(email.isEmpty() && pass.isEmpty()) {
         displayToast("username/password invalid");

      }
    else {
            db.addUser(email,pass);
          displayToast("userregistered");
          finish();

      }
    }

private void displayToast(String message)
{
    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();


}
}
