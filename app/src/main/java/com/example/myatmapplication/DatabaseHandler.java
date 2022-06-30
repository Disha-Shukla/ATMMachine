package com.example.myatmapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "atmManager";
    private static final String TABLE_CONTACTS = "atm";
    private static final String KEY_ID = "id";
    private static final String entryhundred = "entryhundred";
    private static final String entrytwohundred = "entrytwohundred";
    private static final String entryfivehundred = "entryfivehundred";
    private static final String entrytwothousand = "entrytwothousand";
    private static final String withdrawlamount = "withdrawl";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + entryhundred + " TEXT,"
                + entrytwohundred + " TEXT,"+ entryfivehundred + " TEXT,"+ entrytwothousand + " TEXT," +
                withdrawlamount + " TEXT" + ");";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        // Create tables again
        onCreate(db);
    }


    void addATMEntry(atm atm) {
       // Log.v("DS","dh "+contact.getImage());
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(entryhundred, atm.getEntryhundred()); // Contact Name
        values.put(entrytwohundred, atm.getEntrytwohundred()); // Contact Phone
        values.put(entryfivehundred, atm.getEntryfivehundred()); // Contact Phone
        values.put(entrytwothousand, atm.getEntrytwothousand()); // Contact Phone
        values.put(withdrawlamount, atm.getWithdrawlamount());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get all contacts in a list view
    public List<atm> getAllContacts() {
        List<atm> contactList = new ArrayList<atm>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                atm contact = new atm();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.setEntryhundred(cursor.getString(1));
                contact.setEntrytwohundred(cursor.getString(2));
                contact.setEntryfivehundred(cursor.getString(3));
                contact.setEntrytwothousand(cursor.getString(4));
                contact.setWithdrawlamount(cursor.getString(5));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        // return contact list
        return contactList;
    }
}
