package com.e.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        Bundle bundle= getIntent().getExtras();

        if (bundle!= null){
            String message= bundle.getString("capital");
            tv1.setText(message);
        }

        else
        {
            Toast.makeText(this, "nomessage", Toast.LENGTH_SHORT).show();
        }


    }
}
