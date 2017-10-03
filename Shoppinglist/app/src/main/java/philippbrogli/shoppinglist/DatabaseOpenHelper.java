package philippbrogli.shoppinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Philipp Brogli on 03.10.2017.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "PTM_database";
    private final String DATABASE_TABLE = "newproduct";
    private final String PRODUCT = "product";
    private final String COUNT = "count";
    private final String PRIZE = "prize";

    public DatabaseOpenHelper(Context context) {
        // Context, database name, optional cursor factory, database version
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create a new table
        db.execSQL("CREATE TABLE "+DATABASE_TABLE+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+PRODUCT+" TEXT, "+COUNT+" REAL, "+PRIZE+" REAL);");
        // create sample data
        ContentValues values = new ContentValues();
        values.put(PRODUCT, "tomato");
        values.put(COUNT, 10.0);
        values.put(PRIZE, 5.0);
        // insert data to database, name of table, "Nullcolumnhack", values
        db.insert(DATABASE_TABLE, null, values);
        // a more data...
        values.put(PRODUCT, "Milk");
        values.put(COUNT, 2.0);
        values.put(PRIZE, 3.0);
        db.insert(DATABASE_TABLE, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
        onCreate(db);
    }
}
