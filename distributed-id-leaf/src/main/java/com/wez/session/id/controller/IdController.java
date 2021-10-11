package com.wez.session.id.controller;

import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wez
 * @Date 2021/10/11
 */
@RestController
@RequestMapping("/id")
public class IdController {

    @Autowired
    private SegmentService segmentService;
    @Autowired
    private SnowflakeService snowflakeService;

    @GetMapping("/segment")
    public Result segment() {
        // key为业务ID，与数据库表的biz_tag值对应
        return segmentService.getId("leaf-segment-test");
    }

    @GetMapping("/snowflake")
    public Result snowflake() {
        return snowflakeService.getId(null);
    }

}
