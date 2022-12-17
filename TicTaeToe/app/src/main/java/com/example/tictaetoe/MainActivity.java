package com.example.tictaetoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String btn1Text, btn2Text, btn3Text, btn4Text, btn5Text, btn6Text, btn7Text, btn8Text, btn9Text;
    TextView txtResult;
    int count = 0;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set the reference of buttons
        init();


    }

    //    method for getting reference of buttons
    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        txtResult = findViewById(R.id.txtResult);
    }


    @SuppressLint("SetTextI18n")
    public void check(View v) {

        // take the reference of button which is clicked by user
        Button currentBtn = (Button) v;

        if (currentBtn.getText().toString().equals("")) {
            count++;
//            System.out.println(count);

            // set the X or 0 using flag
            if (flag == 0) {
                currentBtn.setText("X");
                flag = 1;
            } else {
                currentBtn.setText("0");
                flag = 0;
            }

            if (count >= 4) {

                btn1Text = btn1.getText().toString();
                btn2Text = btn2.getText().toString();
                btn3Text = btn3.getText().toString();
                btn4Text = btn4.getText().toString();
                btn5Text = btn5.getText().toString();
                btn6Text = btn6.getText().toString();
                btn7Text = btn7.getText().toString();
                btn8Text = btn8.getText().toString();
                btn9Text = btn9.getText().toString();


                if (btn1Text.equals(btn2Text) && btn2Text.equals(btn3Text) && !btn1Text.equals("")) {
                    txtResult.setText(btn1Text + " is Win.");
                    Toast.makeText(this, btn1Text + " is Win.", Toast.LENGTH_LONG).show();
                    restart(v);
                } else if (btn4Text.equals(btn5Text) && btn5Text.equals(btn6Text) && !btn4Text.equals("")) {
                    txtResult.setText(btn4Text + " is Win.");
                    Toast.makeText(this, btn4Text + " is Win.", Toast.LENGTH_LONG).show();
                    restart(v);
                } else if (btn7Text.equals(btn8Text) && btn8Text.equals(btn9Text) && !btn7Text.equals("")) {
                    txtResult.setText(btn7Text + " is Win.");
                    Toast.makeText(this, btn7Text + " is Win.", Toast.LENGTH_LONG).show();
                    restart(v);
                } else if (btn1Text.equals(btn4Text) && btn4Text.equals(btn7Text) && !btn1Text.equals("")) {
                    txtResult.setText(btn1Text + " is Win.");
                    Toast.makeText(this, btn1Text + " is Win.", Toast.LENGTH_LONG).show();
                    restart(v);
                } else if (btn5Text.equals(btn2Text) && btn2Text.equals(btn8Text) && !btn2Text.equals("")) {
                    txtResult.setText(btn2Text + " is Win.");
                    Toast.makeText(this, btn2Text + " is Win.", Toast.LENGTH_LONG).show();
                    restart(v);
                } else if (btn9Text.equals(btn6Text) && btn6Text.equals(btn3Text) && !btn9Text.equals("")) {
                    txtResult.setText(btn3Text + " is Win.");
                    Toast.makeText(this, btn3Text + " is Win.", Toast.LENGTH_LONG).show();
                    restart(v);
                } else if (btn1Text.equals(btn5Text) && btn5Text.equals(btn9Text) && !btn1Text.equals("")) {
                    txtResult.setText(btn1Text + " is Win.");
                    Toast.makeText(this, btn1Text + " is Win.", Toast.LENGTH_LONG).show();
                    restart(v);
                } else if (btn7Text.equals(btn5Text) && btn5Text.equals(btn3Text) && !btn3Text.equals("")) {
                    txtResult.setText(btn3Text + " is Win.");
                    Toast.makeText(this, btn3Text + " is Win.", Toast.LENGTH_LONG).show();
                    restart(v);
                } else if (count == 9) {
                    txtResult.setText("Game is Draw.");
                    Toast.makeText(this, "Game is Draw", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void restart(View view) {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 1;
        txtResult.setText("");
    }
}