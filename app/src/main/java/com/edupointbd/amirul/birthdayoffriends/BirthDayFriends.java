package com.edupointbd.amirul.birthdayoffriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BirthDayFriends extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_day_friends);

      lv = (ListView)findViewById(R.id.lvname);

        DbFunction db = new DbFunction(getApplicationContext());

        String[] data = db.dataShow();




        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.listviewlayout,R.id.tvName,data);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(BirthDayFriends.this,SingleBDay.class);
                i.putExtra("myF",position);
                startActivity(i);
            }
        });


    }
}
