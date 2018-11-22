package com.yt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.yt")//spring bean加载 扫描的根路径
@ImportResource({"classpath:quartz/quartz.xml"})
public class YtApplication {

	public static void main(String[] args) {
		SpringApplication.run(YtApplication.class, args);
	}
}
