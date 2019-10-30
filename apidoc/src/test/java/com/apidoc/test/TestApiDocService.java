package com.apidoc.test;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.apidoc.service.ApiDocService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019-2019, 北京力盟亚有限公司
 *
 * @Description: 测试添加返回主键
 * @Author: qianxi
 * @Date: 2019/10/23 16:45
 * @version:1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApiDocService {
    @Autowired
    ApiDocService apiDocService;


    @Test
    public void execAddMapDoc(){
        apiDocService.execAddMapDoc("select * from COLLECTION_EQUIPMENT_TYPE where id =1 " , 187 );
    }
    @Test
    public void execDelMapDoc(){
        apiDocService.execDelMapDoc(187);
    }
}