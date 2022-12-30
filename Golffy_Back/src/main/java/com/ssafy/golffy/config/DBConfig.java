package com.ssafy.golffy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.golffy.model.dao")
public class DBConfig {

}
