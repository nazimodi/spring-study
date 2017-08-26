package com.java.spring.client.hello.mapper;

import com.java.spring.client.hello.domain.MsgBlackBatch;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


/**
 * @author renqingwang on 2017/8/26.
 * @version 1.0
 */
@Repository
public interface MsgBlackBatchMapper extends Mapper<MsgBlackBatch> {
}