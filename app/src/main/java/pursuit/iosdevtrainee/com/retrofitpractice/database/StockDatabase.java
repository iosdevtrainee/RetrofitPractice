package pursuit.iosdevtrainee.com.retrofitpractice.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import pursuit.iosdevtrainee.com.retrofitpractice.models.Asset;

public class StockDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Stock.db";
    private static final String TABLE_NAME = "Stocks";
    private static final int SCHEMA_VERSION = 1;
    private static StockDatabase stockDatabase;


    private StockDatabase(Context context) {
        super(context, TABLE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "stock_ticker TEXT, " + "company_name TEXT);" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // retrieve single entity
    public Asset getAsset(String ticker){
        Asset asset = null;
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT" + " company_name" + " FROM " + TABLE_NAME + " WHERE" + " stock_ticker = '" + ticker + "'",null
        );

        if (cursor != null) {
            if (cursor.moveToFirst()){
                asset = new Asset(cursor.getString(cursor.getColumnIndex("stock_ticker")),
                        cursor.getString(cursor.getColumnIndex("company_name")));
            }
        }
        return asset;
    }

    // insert single entity
    public void insertStock(String ticker, String name){
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE stock_ticker = '" + ticker +
                        "' AND company_name = '" + name.replace("'"," ") + "';", null);
        if (cursor.getCount() == 0){
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(stock_ticker, company_name) VALUES('" +
                    ticker + "', '" +
                    name.replace("'"," ") + "');");
        }
        cursor.close();
    }

    // retrieve all entities
    public ArrayList<Asset> getStockList() {
        ArrayList<Asset> assets = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if(cursor != null) {
            if(cursor.moveToFirst()) {
                do {
                    Asset asset = new Asset(
                            cursor.getString(cursor.getColumnIndex("breed_name")),
                            cursor.getString(cursor.getColumnIndex("breed_url")));
                    assets.add(asset);
                } while (cursor.moveToNext());
            }
        }
        return assets;
    }

    public static StockDatabase getInstance(Context context){
        if (stockDatabase == null){
            stockDatabase = new StockDatabase(context);
            return stockDatabase;
        }
        return stockDatabase;
    }
}
