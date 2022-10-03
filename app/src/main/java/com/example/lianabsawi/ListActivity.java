package com.example.lianabsawi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView= (ListView) findViewById(R.id.list_view);
        ArrayList<String> arrayList= new ArrayList<>();
        //add items
        arrayList.add("banana");
        arrayList.add("apple");
        //initialize the adapter
        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        //connect adapter to array
        listView.setAdapter(arrayAdapter);

        //item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListActivity.this, "clicked item"+ arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}