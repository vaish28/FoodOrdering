package com.example.registerr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button login;
    private TextView info;
    private TextView reg;
    private int cnt=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        login=(Button)findViewById(R.id.etButton);
        info=(TextView)findViewById(R.id.etInfo);
        reg=(Button)findViewById(R.id.btnReg);
        info.setText("No of attempts remaining: 5");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(Name.getText().toString(),Password.getText().toString()))
                {
                    startActivity(new Intent(Login.this,SecondActivityc.class));
                }
                else
                {
                    cnt--;
                    info.setText("No of attempts remaining: "+Integer.toString(cnt));
                    if(cnt==0)
                    {
                        login.setEnabled(false);
                    }
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register_act.class));
            }
        });
    }
    private boolean validate(String uname,String upwd)
    {
        if(uname.equalsIgnoreCase("Admin") && upwd.equalsIgnoreCase("abcd"))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
