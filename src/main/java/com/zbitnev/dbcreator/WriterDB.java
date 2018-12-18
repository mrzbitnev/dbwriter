package com.zbitnev.dbcreator;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WriterDB {
    Document document;

    public Document write(Document document, ConnectionJDBC connectionJDBC) {
        //Connection connection;
        this.document = document;

        int id = document.getId();
        String date = document.getDate();
        long size = document.getSize();
        String title = document.getTitle();
        String hash = document.getHash();
        int tracker_id = document.getTrackerId();
        int forum_id = document.getForumId();
//        String forum_name = document.getForumName() != null ? document.getForumName() : "";
//        String content = document.getContent();

        try {
            //connection = connectionJDBC.getConnection();
            PreparedStatement ps = connectionJDBC.getConnection().prepareStatement(
                    "INSERT INTO torrents (ID,date,size,title,hash,tracker_id,forum_id)" +
                            " VALUES (?,?,?,?,?,?,?)"
            );

            ps.setInt(1, id);
            ps.setString(2, date);
            ps.setLong(3, size);
            ps.setString(4, title);
            ps.setString(5, hash);
            ps.setInt(6, tracker_id);
            ps.setInt(7, forum_id);
//            ps.setString(8, forum_name);
//            ps.setString(9, content);

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return document;
    }

//    public static String getString(List<String> list) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (String s : list) {
//            stringBuilder.append(s);
//        }
//        return new String(stringBuilder);
//    }
}