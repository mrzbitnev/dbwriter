package com.zbitnev.dbcreator;

import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class DataLoaderTest {

    Statement statement;

    @Test
    public void testClearDB() {

        try( ConnectionJDBC connectionJDBC = new ConnectionJDBC()) {
            statement = connectionJDBC.getConnection().createStatement();

            statement.execute("delete from torrents");
            statement.execute("select * from torrents");
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void startElement() {
    }

    @Test
    public void endElement() {
    }

    @Test
    public void characters() {
    }

}