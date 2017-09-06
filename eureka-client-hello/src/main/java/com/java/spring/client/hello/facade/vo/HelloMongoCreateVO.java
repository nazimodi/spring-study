package com.java.spring.client.hello.facade.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

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
    @ApiModelProperty(value = "日期", example = "2017-10-10 10:10:10", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String date;
    @ApiModelProperty(value = "标题", example = "我是title", required = true)
    private String title;
    @ApiModelProperty(value = "内容", example = "我是content", required = true)
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
