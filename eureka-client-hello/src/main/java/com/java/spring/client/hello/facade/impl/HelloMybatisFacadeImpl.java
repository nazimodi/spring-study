package com.java.spring.client.hello.facade.impl;

import com.java.spring.client.hello.base.BaseFacade;
import com.java.spring.client.hello.domain.MsgBlackBatch;
import com.java.spring.client.hello.facade.HelloMybatisFacade;
import com.java.spring.client.hello.mapper.MsgBlackBatchMapper;
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
    @Autowired
    private MsgBlackBatchMapper msgBlackBatchMapper;

    @Override
    public  List<MsgBlackBatch> list() {
        Example example = new Example(MsgBlackBatch.class);
        example.createCriteria().andEqualTo("id", 1);
        List<MsgBlackBatch> msgBlackBatches = msgBlackBatchMapper.selectByExample(example);

        return msgBlackBatches;
    }
}
