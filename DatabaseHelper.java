package com.example.login;

    import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

    public class DatabaseHelper extends SQLiteOpenHelper {
        public static final String DATABASE = "users.db";
        public static final String user = "users";
        public static final String COL_1 = "ID";
        public static final String COL_2 = "USERNAME";
        public static final String COL_3 = "EMAIL";
        public static final String COL_4 = "PASSWORD";

        public DatabaseHelper(Context context) {
            super(context, DATABASE, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + user + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, EMAIL TEXT, PASSWORD TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + user);
            onCreate(db);
        }

        public boolean insertUser(String username, String email, String password) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2, username);
            contentValues.put(COL_3, email);
            contentValues.put(COL_4, password);
            long result = db.insert(user, null, contentValues);
            return result != -1;
        }

        public Cursor getUser(String email, String password) {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("SELECT * FROM " + user + " WHERE EMAIL=? AND PASSWORD=?", new String[]{email, password});
            return res;
        }
    }


