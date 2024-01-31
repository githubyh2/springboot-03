package com.example.springboot03.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yanhao
 * @data 2024/1/19
 * <p>
 * SpringBoot里面没有我们之前常规web开发的WebContent（WebApp），它只有src目录，
 * 在src/main/resources下面有两个文件夹，[static]和[templates]，
 * springboot默认static中放静态页面，而templates中放动态页面
 */
@Slf4j
@Controller
public class HelloWorldMvcController {
    @RequestMapping("/get")
    public String helloWorld() {
        log.info("访问静态页面");
        /**
         * 如果在使用动态页面时还想跳转到/static/index.html，可以使用重定向return "redirect:/hello.html"
         */
        return "redirect:hello.html";
    }

    @RequestMapping("/hi")
    public ModelAndView sayHello() {
        log.info("访问动态页面");
        ModelAndView modelAndView = new ModelAndView();
        // setViewName中设置的名字要与 templates中的html动态页面名字一样，否则会出现异常
        modelAndView.setViewName("ttt");
        modelAndView.addObject("key", 12345);
        return modelAndView;
    }


    @RequestMapping("/helloworld")
    public String helloWorld(Model model) {
        log.info("访问动态页面");
        model.addAttribute("mav", "hello,Springboot!");
        return "helloworld";
    }
}
