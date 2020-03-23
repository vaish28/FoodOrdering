package com.example.button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button accept;
    private Button updatem;
    private Button updatesp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        accept=(Button)findViewById(R.id.etaccept);
        updatem=(Button)findViewById(R.id.etupdate);
        updatesp=(Button)findViewById(R.id.etupdatesp);
        accept.setOnClickListener(this);
        updatem.setOnClickListener(this);
        updatesp.setOnClickListener(this);
    }

    private void acceptmenu()
    {
        Intent intent2=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent2);
    }

    private void updatemenu()
    {
        Intent intent3=new Intent(MainActivity.this,ThirdActivity.class);
        startActivity(intent3);
    }

    private void updatesp()
    {
        Intent intent4=new Intent(MainActivity.this,FourthActivity.class);
        startActivity(intent4);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.etaccept:
                acceptmenu();
                break;

            case R.id.etupdate:
                updatemenu();
                break;

            case R.id.etupdatesp:
                updatesp();
                break;
        }
    }
}
