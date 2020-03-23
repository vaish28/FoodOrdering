package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.constraintlayout.widget.*;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button login;
    private int cnt=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name= findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView) findViewById(R.id.tvInfo);
        login=findViewById(R.id.btnLogin);
        Info.setText("No of attempts remaining:5");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }
    private void validate(String uname,String upwd)
    {
        if(uname=="Admin" && upwd=="abcd")
        {
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else
        {
            cnt--;
            Info.setText("No of attempts  rmaining: "+String.valueOf(cnt));
            if(cnt==0)
            {
                login.setEnabled(false);
            }
        }
    }
}
