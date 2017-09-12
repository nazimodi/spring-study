package com.java.spring.client.hello.facade.impl;

import com.java.spring.client.hello.base.BaseFacade;
import com.java.spring.client.hello.domain.MsgBlackBatch;
import com.java.spring.client.hello.facade.HelloMybatisFacade;
import com.java.spring.client.hello.mapper.MsgBlackBatchMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author renqingwang on 2017/8/26.
 * @version 1.0
 */
@RestController
public class HelloMybatisFacadeImpl extends BaseFacade implements HelloMybatisFacade {
    private static Logger logger = LoggerFactory.getLogger(HelloMybatisFacadeImpl.class);
    @Autowired
    private MsgBlackBatchMapper msgBlackBatchMapper;

    @Override
    public List<MsgBlackBatch> list() {
        Example example = new Example(MsgBlackBatch.class);
        example.createCriteria().andNotEqualTo("id", 1);
        List<MsgBlackBatch> msgBlackBatches = msgBlackBatchMapper.selectByExample(example);
        if (!msgBlackBatches.isEmpty()) {
            logger.info("check MybatisToStringPlugin:msgBlackBatch to string -> " + msgBlackBatches.get(0).toString());
        }
        return msgBlackBatches;
    }
}
