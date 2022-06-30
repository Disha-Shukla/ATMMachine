package com.example.myatmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText edtAmount;
    Button btnWithdraw;
    TextView txtlable2, txtlable3, txtlable4, txtamount100, txtamount200, txtamount500, txtamount2000,
            txt2amount100, txt2amount200, txt2amount500, txt2amount2000;
    int hundered = 20, twohundred = 20, fivehundred = 12, twothousand = 4, withdrawlamount = 0, balance = 0;
    int usehundered = 0, usetwohundred = 0, usefivehundred = 0, usetwothousand = 0;
    int amtArray[] = {2000, 500, 200, 100};
    int remainingAmount = 0;
    DatabaseHandler db;
    ListView lv_ATMTransactionList;
    ArrayList<atm> atmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAmount = findViewById(R.id.edtAmount);
        btnWithdraw = findViewById(R.id.btnWithdraw);
        txtlable2 = findViewById(R.id.txtlable2);
        txtlable3 = findViewById(R.id.txtlable3);
        txtlable4 = findViewById(R.id.txtlable4);
        txtamount100 = findViewById(R.id.txtamount100);
        txtamount200 = findViewById(R.id.txtamount200);
        txtamount500 = findViewById(R.id.txtamount500);
        txtamount2000 = findViewById(R.id.txtamount2000);
        txt2amount100 = findViewById(R.id.txt2amount100);
        txt2amount200 = findViewById(R.id.txt2amount200);
        txt2amount500 = findViewById(R.id.txt2amount500);
        txt2amount2000 = findViewById(R.id.txt2amount2000);
        lv_ATMTransactionList = findViewById(R.id.listView);
        atmList = new ArrayList<>();


        balance = (hundered * 100) + (twohundred * 200) + (fivehundred * 500) + (twothousand * 2000);

        db = new DatabaseHandler(this);
        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                withdrawlamount = Integer.parseInt(edtAmount.getText().toString());
                //Log.v("DS", "" + withdrawlamount + "Balance" + balance);

                if (withdrawlamount < ((hundered * 100) + (twohundred * 200) + (fivehundred * 500) + (twothousand + 2000))) {
                    txtlable4.setText(""+withdrawlamount);
                    usetwothousand = withdrawlamount / 2000;
                    usefivehundred = withdrawlamount / 500;
                    usetwohundred = withdrawlamount / 200;
                    usehundered = withdrawlamount / 100;
                   // Log.v("DS", "usetwothousand" + usetwothousand + "  usefivehundred" + usefivehundred + " usetwohundred" + usetwohundred + " usehundered" + usehundered);
                    if (withdrawlamount >= 2000) {
                        if (twothousand >= usetwothousand && twothousand > 0) {
                            balance = balance - usetwothousand * 2000;
                            remainingAmount = withdrawlamount - (usetwothousand * 2000);
                            twothousand = twothousand - usetwothousand;
                            txtamount2000.setText("" + twothousand);
                            txt2amount2000.setText("" + usetwothousand);
                            Log.v("DS", "2000" + balance + " remain " + remainingAmount);
                            if (remainingAmount > 0) {
                                usefivehundred = remainingAmount / 500;
                                //Log.v("DS", "usefive" + usefivehundred);
                                if (fivehundred >= usefivehundred && fivehundred > 0) {
                                    balance = balance - usefivehundred * 500;
                                    remainingAmount = remainingAmount - (usefivehundred * 500);
                                    fivehundred = fivehundred - usefivehundred;
                                    txtamount500.setText("" + fivehundred);
                                    txt2amount500.setText("" + usefivehundred);
                                    Log.v("DS", "500" + balance + " remain " + remainingAmount);
                                    if (remainingAmount > 0) {
                                        usetwohundred = remainingAmount / 200;
                                        if (twohundred >= usetwohundred && twohundred > 0) {
                                            balance = balance - usetwohundred * 200;
                                            remainingAmount = remainingAmount - (usetwohundred * 200);
                                            twohundred = twohundred - usetwohundred;
                                            txtamount200.setText("" + twohundred);
                                            txt2amount200.setText("" + usetwohundred);
                                            //Log.v("DS","200"+balance);
                                            if (remainingAmount > 0) {
                                                usehundered = remainingAmount / 100;
                                                if (hundered >= usehundered && hundered > 0) {
                                                    balance = balance - usehundered * 100;
                                                    remainingAmount = remainingAmount - (usehundered * 100);
                                                    hundered = hundered - usehundered;
                                                    txtamount100.setText("" + hundered);
                                                    txt2amount100.setText("" + usehundered);
                                                }
                                            }
                                            else{
                                                txt2amount100.setText("0");
                                            }
                                        }
                                    }
                                    else{
                                        txt2amount200.setText("0");
                                        txt2amount100.setText("0");
                                    }

                                }

                            }
                            else {
                                txt2amount500.setText("0");
                                txt2amount200.setText("0");
                                txt2amount100.setText("0");
                            }
                        }

                    } else if (withdrawlamount >= 500) {
                        if (fivehundred >= usefivehundred && fivehundred > 0) {
                            balance = balance - usefivehundred * 500;
                            remainingAmount = withdrawlamount - (usefivehundred * 500);
                            fivehundred = fivehundred - usefivehundred;
                            txtamount500.setText("" + fivehundred);
                            txt2amount500.setText("" + usefivehundred);
                            Log.v("DS", "$$$500" + balance);
                            if (remainingAmount > 0) {
                                usetwohundred = remainingAmount / 200;
                                if (twohundred >= usetwohundred && twohundred > 0) {
                                    balance = balance - usetwohundred * 200;
                                    remainingAmount = remainingAmount - (usetwohundred * 200);
                                    twohundred = twohundred - usetwohundred;
                                    txtamount200.setText("" + twohundred);
                                    txt2amount200.setText("" + usetwohundred);
                                    //Log.v("DS","200"+balance);
                                    if (remainingAmount > 0) {
                                        usehundered = remainingAmount / 100;
                                        if (hundered >= usehundered && hundered > 0) {
                                            balance = balance - usehundered * 100;
                                            remainingAmount = remainingAmount - (usehundered * 100);
                                            hundered = hundered - usehundered;
                                            txtamount100.setText("" + hundered);
                                            txt2amount100.setText("" + usehundered);
                                        }
                                    }
                                    else{
                                        txt2amount100.setText("0");
                                    }
                                }
                            }
                            else{
                                txt2amount200.setText("0");
                                txt2amount100.setText("0");
                            }
                        }
                    } else if (withdrawlamount >= 200) {
                        if (twohundred >= usetwohundred && twohundred > 0) {
                            balance = balance - usetwohundred * 200;
                            remainingAmount = withdrawlamount - (usetwohundred * 200);
                            twohundred = twohundred - usetwohundred;
                            txtamount200.setText("" + twohundred);
                            txt2amount200.setText("" + usetwohundred);
                            Log.v("DS", "200" + balance);

                            if (remainingAmount > 0) {
                                usehundered = remainingAmount / 100;
                                if (hundered >= usehundered && hundered > 0) {
                                    balance = balance - usehundered * 100;
                                    remainingAmount = remainingAmount - (usehundered * 100);
                                    hundered = hundered - usehundered;
                                    txtamount100.setText("" + hundered);
                                    txt2amount100.setText("" + usehundered);
                                }
                            }
                            else{
                                txt2amount100.setText("0");
                            }
                        }
                    } else if (withdrawlamount >= 100) {
                        if (hundered >= usehundered && hundered > 0) {
                            balance = balance - usehundered * 100;
                            hundered = hundered - usehundered;
                            txtamount100.setText("" + hundered);
                            txt2amount100.setText("" + usehundered);
                            Log.v("DS", "100" + balance);
                        }
                    }

                    db.addATMEntry(new atm(txt2amount100.getText().toString(),txt2amount200.getText().toString(),
                            txt2amount500.getText().toString(),txt2amount2000.getText().toString(),
                            txtlable4.getText().toString()));

                    List<atm> atmArray = db.getAllContacts();
                    atmList.clear();
                    for (atm cn : atmArray) {
                        /*String log = "Id: " + cn.get_id() + " ,Name: " + cn.get() + " ,Phone: " +
                                cn.get_phone_number()+ " image "+cn.getImage();*/

                        atmList.add(new atm(cn.get_id(), cn.getEntryhundred(), cn.getEntrytwohundred(),
                                cn.getEntryfivehundred(), cn.getEntrytwothousand(), cn.getWithdrawlamount()));
                    }

                    CustomAdapter customAdapter = new CustomAdapter
                            (MainActivity.this, atmList);
                    lv_ATMTransactionList.setAdapter(customAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Amount", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}