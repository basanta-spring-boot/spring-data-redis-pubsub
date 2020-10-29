package com.javatechie.redis;

import com.javatechie.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringDataRedisExampleApplication {

    @Autowired
    private RedisTemplate template;

    @Autowired
    private ChannelTopic topic;


    @PostMapping("/send")
    public String send(@RequestBody Product product) {
        template.convertAndSend(topic.getTopic(), product.toString());
        return "message send successfully...!!!";
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisExampleApplication.class, args);
    }

}
