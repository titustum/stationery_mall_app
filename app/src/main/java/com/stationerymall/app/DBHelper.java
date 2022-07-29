package com.stationerymall.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    static String DATABASE_NAME  = "stationery_database.db";
    static  int DATABASE_VERSION = 1;
    static String PURCHASES_TABLE = "purchases_table";

    static String KEY_ID = "id";
    static String KEY_PRODUCT_NAME = "product_name";
    static String KEY_PRODUCT_PRICE = "product_price";
    static String KEY_CUSTOMER_NAME = "customer_name";
    static String KEY_CUSTOMER_PHONE = "customer_phone";
    static String KEY_MPESA_CODE = "mpesa_code";

    public DBHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_table = "CREATE TABLE "+PURCHASES_TABLE+" ("
                +KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +KEY_PRODUCT_NAME+" TEXT, "
                +KEY_PRODUCT_PRICE+" TEXT, "
                +KEY_CUSTOMER_NAME+" TEXT, "
                +KEY_CUSTOMER_PHONE+" TEXT, "
                +KEY_MPESA_CODE+" TEXT);";
        db.execSQL(query_table);
//        db.execSQL("CREATE TABLE purchases_table(id INTEGER PRIMARY KEY AUTOINCREMENT, product_name TEXT, product_price TEXT, customer_name TEXT, customer_phone TEXT, mpesa_code TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+PURCHASES_TABLE);
        onCreate(db);
    }

    public long insertPurchase(String product_name, String product_price, String customer_name, String customer_phone, String mpesa_code){
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_PRODUCT_NAME, product_name);
        contentValues.put(KEY_PRODUCT_PRICE, product_price);
        contentValues.put(KEY_CUSTOMER_NAME, customer_name);
        contentValues.put(KEY_CUSTOMER_PHONE, customer_phone);
        contentValues.put(KEY_MPESA_CODE, mpesa_code);
        return db.insert(PURCHASES_TABLE, null, contentValues);
    }

    public String getData(){
        db = this.getReadableDatabase();
        String [] columns  = new String[] { KEY_ID, KEY_PRODUCT_NAME, KEY_PRODUCT_PRICE, KEY_CUSTOMER_NAME, KEY_CUSTOMER_PHONE, KEY_MPESA_CODE};
        Cursor cursor = db.query(PURCHASES_TABLE, columns, null, null, null, null, null);
        int iId = cursor.getColumnIndex(KEY_ID);
        int iProductName = cursor.getColumnIndex(KEY_PRODUCT_NAME);
        int iProductPrice = cursor.getColumnIndex(KEY_PRODUCT_PRICE);
        int iCustomerName = cursor.getColumnIndex(KEY_CUSTOMER_NAME);
        int iCustomerPhone = cursor.getColumnIndex(KEY_CUSTOMER_PHONE);
        int iMpesaCode= cursor.getColumnIndex(KEY_MPESA_CODE);

        String result = "";

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){

            result += "Id: "+cursor.getString(iId)+"\n"+
                    "Product Name: "+cursor.getString(iProductName)+"\n"+
                    "Product Price: "+cursor.getString(iProductPrice)+"\n"+
                    "Customer Name: "+cursor.getString(iCustomerName)+"\n"+
                    "Customer Phone: "+cursor.getString(iCustomerPhone)+"\n"+
                    "Mpesa Code: "+cursor.getString(iMpesaCode)+"\n\n";
        }
        db.close();
        return  result;

    }

}
