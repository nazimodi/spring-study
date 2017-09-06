package com.java.spring.client.hello.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author renqingwang on 2017/9/5.
 * @version 1.0
 */
@Document(collection = "report")
public class Report implements Serializable{
    @Id
    private String id;
    private String date;
    private String content;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Report[id=%s, date=%s, content=%s, title=%s]", id, date, content, title);
    }
}
