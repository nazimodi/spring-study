package com.java.spring.client.hello.facade.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author renqingwang on 2017/9/6.
 * @version 1.0
 */
@ApiModel(description = "文档列表查询")
public class HelloMongoListVO {

    /**
     * title : test
     * content : content
     */
    @ApiModelProperty(value = "文档标题")
    private String title;

    @ApiModelProperty(value = "文档内容")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
