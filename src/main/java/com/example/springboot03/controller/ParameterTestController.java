package com.example.springboot03.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.Cookie;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yanhao
 * @data 2023/10/29
 */
@Slf4j
@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String, String> params
    ) {

        log.info(" YH----The getCar method is called 。。。。");
        HashMap<String, Object> map = new HashMap<>();
/*        map.put("id", id);
        map.put("username", name);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("headers", header);*/

        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        return map;
    }
}
