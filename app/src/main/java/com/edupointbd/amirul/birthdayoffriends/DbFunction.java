package com.edupointbd.amirul.birthdayoffriends;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by amirul on 19-Apr-17.
 */

public class DbFunction extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydb";
    private static final String TABLE_NAME = "mytb";

    private static  final String TAB_ID ="id";
    private static final String TAB_NAME = "name";
    private static final String TAB_DAY = "day";



     DbFunction(Context c){

       super(c,DATABASE_NAME,null,1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String s = "CREATE TABLE "+TABLE_NAME+"("+TAB_ID+" INTEGER PRIMARY KEY, "+TAB_NAME+" TEXT, "+TAB_DAY+" TEXT)";


        db.execSQL(s);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // adding databsae ----------

    void  addToDatabase(DataTem dt){

        SQLiteDatabase aqd = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(TAB_NAME,dt.getName());
        cv.put(TAB_DAY,dt.getDay());



        aqd.insert(TABLE_NAME,null,cv);
        aqd.close();

    }


    // data show mrthod here-----------

    String[] dataShow(){

        SQLiteDatabase sql = this.getReadableDatabase();

        String r = "SELECT * FROM "+TABLE_NAME;
        Cursor c = sql.rawQuery(r,null);

        String[] receive_data = new String[c.getCount()];



        c.moveToFirst();
        if(c.moveToFirst()){

            int counter = 0;
            do{
                receive_data[counter] = "Name: "+c.getString(c.getColumnIndex(TAB_NAME+"")) +"\nBirthDay :"+
                c.getString(c.getColumnIndex(TAB_DAY+""));
                counter = counter+1;
            }while (c.moveToNext());


        }


        return receive_data;
    }

    //update data

   String face_day(int id){
       SQLiteDatabase upsql = this.getReadableDatabase();

       String ss = "SELECT "+TAB_DAY+" FROM "+TABLE_NAME+" WHERE "+TAB_ID+" = "+id;
       Cursor cc = upsql.rawQuery(ss,null);

       String s ="";
       cc.moveToFirst();
       if(cc.moveToFirst()){
           s = cc.getString(cc.getColumnIndex(TAB_DAY+""));
           Log.d("faace Data",s);
       }
       return s;

    }

    int update_data(int id, String day_data){

        SQLiteDatabase ud = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TAB_DAY,day_data);

        return ud.update(TABLE_NAME, cv, TAB_ID+" = ?", new String[]{id+""});

    }

    int delete_data(int id){

        SQLiteDatabase bd = this.getWritableDatabase();

        return  bd.delete(TABLE_NAME, TAB_ID+ " = ? ", new String[]{id+""});


    }
}
