package com.wez.session.id;

import com.sankuai.inf.leaf.plugin.annotation.EnableLeafServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableLeafServer
@SpringBootApplication
public class IdApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(IdApplicationMain.class, args);
    }

}
