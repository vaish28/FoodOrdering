package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button cust,prov ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cust = (Button) findViewById(R.id.button_cust);
        cust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityCust();
            }
        }

        );

        prov = (Button) findViewById(R.id.button_prov);
        prov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityProv();
            }
        });
    }

    public void openActivityProv()
    {
        Intent intent = new Intent(this,PROVIDER.class);
        startActivity(intent);


    }
public void openActivityCust()
{
    Intent intent = new Intent(this,CUSTOMER.class);
    startActivity(intent);


}


}
