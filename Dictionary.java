package com.e.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dictionary extends AppCompatActivity {

    public static final String countries[] = {
            "Nepal", "kATHMANDU", "India", "Delhi"
    };

    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        ListView lst1 = findViewById(R.id.lst1);

        dictionary = new HashMap<>();
        for (int i = 0; i < countries.length; i += 2) {
            dictionary.put(countries[i], countries[i + 1]);
        }
        ArrayAdapter countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                new ArrayList<>(dictionary.keySet())
        );
        lst1.setAdapter(countryAdapter);
        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = parent.getItemAtPosition(position).toString();
                String capital = dictionary.get(key);
                Intent intent = new Intent(Dictionary.this, SecondActivity.class);
                intent.putExtra("capital", capital);
                startActivity(intent);

            }
        });
    }
}
