package com.ssafy.alcohol.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.alcohol.model.dao")
public class DBConfig {

}
