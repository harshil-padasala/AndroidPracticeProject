package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class helper  extends SQLiteOpenHelper {
    String TableName ="student";
    String col1="id";
    String col2="name";
    String col3="surname";
    String col4="marks";
    //taking id and marks string instead of int as data taken from edittext is always string and then we convert to int and store it

    public helper(@Nullable Context context) {
        super(context,"student.db",null,1);
        //super(context,name of table,factory=null,version except 0 can be given);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE student (id integer primary key autoincrement,name text,surname text,marks integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists student");
        onCreate(sqLiteDatabase);

    }
    public boolean insert(String name,String surname,String marks){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,surname);
        contentValues.put(col4,marks);
        long res = sqLiteDatabase.insert(TableName,null,contentValues);
        if(res==-1){
            return false;
        }
        else{
            return true;
        }
    }
    //cursor= returning whole table
    public Cursor show(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("Select * from student",null);
        return c;
    }
    public boolean update(String id,String name,String surname,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,surname);
        contentValues.put(col4,marks);
        int r=db.update(TableName,contentValues,"id=?",new String[]{id});
        if(r>0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deletedata(String id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        int r=sqLiteDatabase.delete(TableName,"id=?",new String[]{id});
        if(r>0){
            return true;
        }
        else{
            return false;
        }
    }
}
