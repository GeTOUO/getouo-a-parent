package com.nh.account;

import com.alibaba.nacos.common.notify.DefaultPublisher;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.aot.hint.ReflectionHints;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
@ImportRuntimeHints(AccountApplication.NacosRuntimeHintsRegistrar.class)
public class AccountApplication {

    @Autowired
    CityRepository repository;

    @GetMapping("/hello")
    public Page<City> testSelect() {
        System.out.println(("----- selectAll method test ------"));

//        List<UserRecord> records = dsl.selectFrom(User.USER).fetch(r -> r.into(User.USER));

        // Assert.assertEquals(5, userList.size());
//        records.forEach(System.out::println);
//        return records.stream().map(r -> new UU().setName(r.getName())).toList();
        Page<City> all = repository.findAll(Pageable.ofSize(1));
        return all;
    }

    @Data
    @Accessors(chain = true)
    public static class UU {

        private String name;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    static class NacosRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.reflection().registerType(DefaultPublisher.class);
        }
    }
}
