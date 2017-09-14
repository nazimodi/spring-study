package com.java.spring.client.hello.facade.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author renqingwang on 2017/8/14.
 * @version 1.0
 */
@ApiModel(description = "hive查询对象")
public class HelloHiveVO {
    @ApiModelProperty(value = "hive sql语句", example = "select * from xxx")
    @NotEmpty(message = "hive sql语句不能为空")
    private String hiveSql;

    public String getHiveSql() {
        return hiveSql;
    }

    public void setHiveSql(String hiveSql) {
        this.hiveSql = hiveSql;
    }
}
