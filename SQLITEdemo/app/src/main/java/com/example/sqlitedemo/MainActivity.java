package com.example.sqlitedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    helper mydb;
    EditText et1,et2,et3,et4;
    Button bt1,bt2,bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new helper(MainActivity.this);
        et1=findViewById(R.id.editTextTextPersonName);
        et2=findViewById(R.id.editTextTextPersonName2);
        et3=findViewById(R.id.editTextTextPersonName3);
        et4=findViewById(R.id.editTextTextPersonName4);
        bt1=findViewById(R.id.button);
        bt2=findViewById(R.id.button2);
        bt3=findViewById(R.id.button3);
        bt4=findViewById(R.id.button4);

        
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res=mydb.insert(et2.getText().toString(),et3.getText().toString(),et4.getText().toString());
                if(res){
                    Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "Data insertion failed", Toast.LENGTH_SHORT).show();
                }
            }

        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c=mydb.show();
                if(c.getCount()==0){
                    alertcall("Error","No data Found");
                    return;
                }
                else{
                    StringBuffer stringBuffer=new StringBuffer();
                    while (c.moveToNext()){
                        stringBuffer.append("ID: "+c.getString(0)+"\n");
                        stringBuffer.append("Name: "+c.getString(1)+"\n");
                        stringBuffer.append("SurName: "+c.getString(2)+"\n");
                        stringBuffer.append("Marks: "+c.getString(3)+"\n\n");
                    }
                    alertcall("Data",stringBuffer.toString());
                }
            }


            private void alertcall(String error, String no_data_found) {
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle(error);
                alert.setMessage(no_data_found);
                alert.show();

            }
        });
        //update
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=et1.getText().toString();
                String name=et2.getText().toString();
                String surname=et3.getText().toString();
                String marks=et4.getText().toString();
                boolean res=mydb.update(id,name,surname,marks);
                if(res){
                    Toast.makeText(MainActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Sorry! Data not updated....", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //delete
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=et1.getText().toString();
                boolean res=mydb.deletedata(id);
                if(res){
                    Toast.makeText(MainActivity.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Sorry! Data not deleted....", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}