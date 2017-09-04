package com.java.spring.client.hello.facade.vo;

import io.swagger.annotations.ApiModel;

/**
 * @author renqingwang on 2017/9/5.
 * @version 1.0
 */
@ApiModel(description = "mongo创建参数")
public class HelloMongoCreateVO {

    /**
     * date : 20170101 10:10:10
     * title : test
     * content : content
     */
    private String date;
    private String title;
    private String content;

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
