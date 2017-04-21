package com.edupointbd.amirul.birthdayoffriends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingleBDay extends AppCompatActivity {

    EditText et1;
    Button btnUpdate,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_bday);

        et1 = (EditText)findViewById(R.id.etSingleName);

        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);

        final int rece = getIntent().getIntExtra("myF",76);

       final  DbFunction dd = new DbFunction(getApplicationContext());

        et1.setText(dd.face_day(rece+1));
        et1.setSelection(et1.getText().length());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dd.update_data((rece+1),et1.getText().toString());
                Toast.makeText(getApplicationContext(),"update click",Toast.LENGTH_LONG).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dd.delete_data((rece+1));
                et1.setText("");
                Toast.makeText(getApplicationContext(),"delete button click",Toast.LENGTH_LONG).show();
            }
        });
    }
}
