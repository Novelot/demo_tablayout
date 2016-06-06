package com.novelot.demo_tablayout.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public static final Uri URI = Uri.parse("content://com.novelot.demo_tablayout.test");
    private static final java.lang.String[] COLUMNS = new String[]{"_id", "url"};

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {

        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        MatrixCursor cursor = new MatrixCursor(COLUMNS);
//        cursor.addRow(new Object[]{"http://www.novelot.com/test.jpg"});
        MatrixCursor.RowBuilder builder = cursor.newRow();
        builder.add("url", "http://img0.imgtn.bdimg.com/it/u=2257941861,3810763927&fm=21&gp=0.jpg");

        MatrixCursor.RowBuilder builder1 = cursor.newRow();
        builder1.add("url", "http://img5.imgtn.bdimg.com/it/u=729162715,1863048622&fm=21&gp=0.jpg");

        MatrixCursor.RowBuilder builder2 = cursor.newRow();
        builder2.add("url", "http://img2.imgtn.bdimg.com/it/u=2510015461,563551171&fm=21&gp=0.jpg");

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
