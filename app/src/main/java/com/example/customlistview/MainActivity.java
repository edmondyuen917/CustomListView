package com.example.customlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        ArrayList userList = getListData();
        final ListView lv = (ListView) findViewById(R.id.user_list);
        lv.setAdapter(new CustomListAdapter(this, userList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListItem user = (ListItem) lv.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected :" + " " + user.getName()+", "+ user.getLocation(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private ArrayList getListData() {
        ArrayList<ListItem> results = new ArrayList<>();
        ListItem user1 = new ListItem();
        user1.setName("Suresh Dasari");
        user1.setDesignation("Team Leader");
        user1.setLocation("Hyderabad");
        results.add(user1);
        ListItem user2 = new ListItem();
        user2.setName("Rohini Alavala");
        user2.setDesignation("Agricultural Officer");
        user2.setLocation("Guntur");
        results.add(user2);
        ListItem user3 = new ListItem();
        user3.setName("Trishika Dasari");
        user3.setDesignation("Charted Accountant");
        user3.setLocation("Guntur");
        results.add(user3);
        return results;
    }

    @Override
    public void onClick(View view) {

    }
}