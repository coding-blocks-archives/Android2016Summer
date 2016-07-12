package com.codingblocks.lecturetwelvedatabases;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codingblocks.lecturetwelvedatabases.db.StudentTable;
import com.codingblocks.lecturetwelvedatabases.models.Student;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyDbOpener dbOpener = new MyDbOpener(this);
//
//        SQLiteDatabase myDb = dbOpener.getWritableDatabase();

        SQLiteDatabase myDb = MyDbOpener.openWritableDatabase(this);
        Student stu = new Student(
                1,
                "John Doe",
                5,
                11
        );
        ContentValues value = new ContentValues();
//        value.put(StudentTable.Columns.ID, stu.getId());
        value.put(StudentTable.Columns.NAME, stu.getName());
        value.put(StudentTable.Columns.AGE, stu.getAge());
        value.put(StudentTable.Columns.CLASS, stu.getStudentClass());

        myDb.insert(StudentTable.TABLE_NAME, null, value);

        String[] projection = {
                StudentTable.Columns.ID,
                StudentTable.Columns.NAME
        };

        Cursor c = myDb.query(
                StudentTable.TABLE_NAME,
                projection,
                null, null, null, null, null
        );
        Log.d(TAG, "onCreate: cursor count" + c.getCount());
        while (c.moveToNext()) {
            int stuId = c.getInt(c.getColumnIndex(StudentTable.Columns.ID));
            String stuName = c.getString(c.getColumnIndex(StudentTable.Columns.NAME));

            Log.d(TAG, "onCreate: student = " + stuId + " " + stuName);
        }

    }
}
