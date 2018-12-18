package com.zbitnev.dbcreator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class DataLoader extends DefaultHandler {
    String thisElement = "";
    Document doc;
    WriterDB writerDB = new WriterDB();
    Connection connection;
    ConnectionJDBC connectionJDBC = new ConnectionJDBC();

    public DataLoader(Document doc, ConnectionJDBC connectionJDBC) {
        this.doc = doc;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        if (qName.equals("torrent")) {

            doc.setReadyToWrite(true);

            if (atts.getValue("id") != null & atts.getValue("id") != "") {
                doc.setId(new Integer(atts.getValue("id")));
            }
            if (atts.getValue("registred_at") != null) {
                doc.setDate(atts.getValue("registred_at"));
            }
            if (atts.getValue("size") != null) {
                doc.setSize(new Long(atts.getValue("size")));
            }
            if (atts.getValue("hash") != null) {
                doc.setHash(atts.getValue("hash"));
                doc.setReadyToWrite(false);
            }
//            if (atts.getValue("tracker_id") != null) {
//                doc.setTrackerId(new Integer(atts.getValue("tracker_id")));
//            }
//        }        thisElement = qName;
//        if (thisElement.equals("torrent")) {
//
//            doc.setReadyToWrite(true);
//
//            if (atts.getValue("id") != null & atts.getValue("id") != "") {
//                doc.setId(new Integer(atts.getValue("id")));
//            }
//            if (atts.getValue("registred_at") != null) {
//                doc.setDate(atts.getValue("registred_at"));
//            }
//            if (atts.getValue("size") != null) {
//                doc.setSize(new Long(atts.getValue("size")));
//            }
//            if (atts.getValue("hash") != null) {
//                doc.setHash(atts.getValue("hash"));
//                doc.setReadyToWrite(false);
//            }
//            if (atts.getValue("tracker_id") != null) {
//                doc.setTrackerId(new Integer(atts.getValue("tracker_id")));
//            }
//        }
//        if (thisElement.equals("forum")) {
//            if (atts.getValue("id") != null) {
//                doc.setForumId(new Integer(atts.getValue("tracker_id")));
//            }
       }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement != "") {
            if (thisElement.equals("title")) {
                doc.setTitle(new String(ch, start, length));
            }
            if (thisElement.equals("forum")) {
                doc.setForum(new String(ch, start, length));
            }
            if (thisElement.equals("forum_name")) {
                doc.setForumName(new String(ch, start, length));
            }
//            if (thisElement.equals("content")) {
//                doc.setContent(new String(ch, start, length));
//            }
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("torrent") ) {
            writerDB.write(doc, connectionJDBC);
            Document.clearDoc(doc);
        }
        thisElement = "";
    }

    @Override
    public void endDocument() {
        try {
            connectionJDBC.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}