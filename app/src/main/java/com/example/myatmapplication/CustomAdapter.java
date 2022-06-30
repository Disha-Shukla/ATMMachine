package com.example.myatmapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<atm> {

    Context c;
    DatabaseHandler db;
    ArrayList<atm> contactModelArrayList;

    public CustomAdapter(@NonNull Context context, ArrayList<atm> contactModelArrayList) {
        super(context, 0, contactModelArrayList);
        this.c = context;
        this.contactModelArrayList = contactModelArrayList;
        db = new DatabaseHandler(context);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);
        }
        atm contactModel = getItem(position);
        TextView txtamount100 = listitemView.findViewById(R.id.txt3label100);
        TextView txtamount200 = listitemView.findViewById(R.id.txt3label200);
        TextView txtamount500 = listitemView.findViewById(R.id.txt3label500);
        TextView txtamount2000 = listitemView.findViewById(R.id.txt3label2000);
        TextView txtwithdrawl = listitemView.findViewById(R.id.txtlable5);

        txtamount100.setText(contactModel.getEntryhundred());
        txtamount200.setText(contactModel.getEntrytwohundred());
        txtamount500.setText(contactModel.getEntryfivehundred());
        txtamount2000.setText(contactModel.getEntrytwothousand());
        txtwithdrawl.setText(contactModel.getWithdrawlamount());

        return listitemView;
    }
}
