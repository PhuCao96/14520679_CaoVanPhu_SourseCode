package com.example.phucao.lab3_2_sql;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView DanhSach;
    private ListContactAdapter adapter;
    private List<Contact> mContactList;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DanhSach = (ListView) findViewById(R.id.List_Contact);
        db = new DatabaseHandler(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.e("Reading: ", "Reading all cont-acts..");

        mContactList = db.getAllContacts();

        for (Contact cn : mContactList) {
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.e("Name: ", log);
        }

        // Set Adapter cho ListView
        adapter = new ListContactAdapter(this, mContactList);


        // Long Click de xoa 1 Contact
        DanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                db.deleteContact(mContactList.get(position));
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Contact Deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        DanhSach.setAdapter(adapter);

    }
}
