package com.zbitnev.dbcreator;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Launch {
    ConnectionJDBC connectionJDBC = new ConnectionJDBC();

    public void getLaunch() {

        try {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        DataLoader saxp = new DataLoader(new Document(), connectionJDBC);

            parser.parse(new File("data"), saxp);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}

//    String createTableSql = "CREATE TABLE IF NOT EXISTS torrents " +
//            "(id INT PRIMARY KEY     NOT NULL, " +
//            " date           TEXT    NOT NULL, " +
//            " size           INT     NOT NULL, " +
//            " title          TEXT    NOT NULL, " +
//            " hash           TEXT    NOT NULL, " +
//            " tracker_id     INT     NOT NULL, " +
//            " forum_id       INT     NOT NULL, " +
//            " forum_name     TEXT    NOT NULL, " +
//            " content        TEXT    NOT NULL ) ";

//    String insertIntoTorrent = "INSERT INTO torrents (ID,date,size,title,hash,tracker_id,forum_id,forum_name,content) "
//            + "VALUES (1232, 'Paul', 32, 'California', '200' ,0,0,'g','g');";
