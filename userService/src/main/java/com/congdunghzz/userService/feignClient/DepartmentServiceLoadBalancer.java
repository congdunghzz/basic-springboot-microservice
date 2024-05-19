package com.congdunghzz.userService.feignClient;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(name = "DEPARTMENT-SERVICE")
public class DepartmentServiceLoadBalancer {
    @Bean
    @LoadBalanced
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }

}
