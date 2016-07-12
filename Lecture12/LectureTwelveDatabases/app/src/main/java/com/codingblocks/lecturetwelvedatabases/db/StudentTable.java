package com.codingblocks.lecturetwelvedatabases.db;


/**
 * Created by championswimmer on 12/07/16.
 */
public class StudentTable extends DbTable {

    public static final String TABLE_NAME = "students";

    public interface Columns {
        String ID = "id";
        String NAME = "name";
        String AGE = "age";
        String CLASS = "class";
    }

    public static final String TABLE_CREATE_CMD =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + LBR
            + Columns.ID + TYPE_INT_PK + COMMA
            + Columns.NAME + TYPE_TEXT + COMMA
            + Columns.AGE + TYPE_INT + COMMA
            + Columns.CLASS + TYPE_INT
            + RBR + ";";
}
