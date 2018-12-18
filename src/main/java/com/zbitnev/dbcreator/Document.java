package com.zbitnev.dbcreator;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private int id;
    private String date;
    private long size;
    private String title;
    private String hash;
    private int trackerId;
    private int forumId;
    private String forum;
    private String forumName;
    private List<String> content;
    private boolean readyToWrite = false;

    public static Document clearDoc(Document document) {
        document.setId(0);
        document.setTitle("");
        document.setSize(0);
        document.setForumId(0);
        document.setForum("");
        document.setTrackerId(0);
        document.setHash("");
        document.setDate("");
        document.setContent("");
        document.content.clear();
        document.setReadyToWrite(false);
        return document;
    }

    public Document() {
        this.content = new ArrayList();
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", size=" + size +
                ", title='" + title + '\'' +
                ", hash='" + hash + '\'' +
                ", trackerId=" + trackerId +
                ", forumId=" + forumId +
                ", forum=" + forum +
                ", forumName='" + forumName + '\'' +
                ", content size='" + content + '\'' +
                '}';
    }

    public boolean isReadyToWrite() {
        return readyToWrite;
    }

    public void setReadyToWrite(boolean readyToWrite) {
        this.readyToWrite = readyToWrite;
    }

    public int getId() {
        return id;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String getContent() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : content) {
            stringBuilder.append(s);
        }
        return new String(stringBuilder);
    }

    public void setContent(String content) {
        this.content.add(content);
    }
}
