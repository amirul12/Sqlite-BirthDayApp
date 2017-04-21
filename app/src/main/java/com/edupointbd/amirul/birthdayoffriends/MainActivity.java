package com.edupointbd.amirul.birthdayoffriends;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eName,eDay;
    Button btnSava,btnShow,btnFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = (EditText)findViewById(R.id.etName);
        eDay = (EditText)findViewById(R.id.etDay);
        btnSava = (Button)findViewById(R.id.btnSava);
        btnShow = (Button)findViewById(R.id.btnShow);
        btnFb = (Button)findViewById(R.id.btnShare);

        btnSava.setOnClickListener(new View.OnClickListener() {


            DbFunction dbFunction = new DbFunction(getApplicationContext());

            @Override
            public void onClick(View v) {
                String _name = eName.getText().toString();
                String _bday = eDay.getText().toString();

                DataTem dataTem = new DataTem(_name,_bday);
                dbFunction.addToDatabase(dataTem);

                eName.setText("");
                eDay.setText("");

                Toast.makeText(getApplicationContext(),"data insert successfuly",Toast.LENGTH_LONG).show();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,BirthDayFriends.class));
            }
        });
        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/amirulislamcse"));
                startActivity(i);
            }
        });
    }



}
