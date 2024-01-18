package com.example.springboot03;

import com.example.springboot03.util.AESUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("git test----4-");
        // master分支增加
        System.out.println("master ----");

        System.out.println("test---分支增加");
        System.out.println("2023//11/27-master");
        System.out.println("2023//11/27");
        System.out.println("2023/11/28---dev分支增加");
    }

    /**
     * 测试AES加解密算法的使用
     *
     * @throws Exception
     */
    @org.junit.Test
    public void TestAES() throws Exception {
        String hello = AESUtils.encrypt("hello");
        log.info("AES加密后的数据是：" + hello);  // O4bJQiAVEW4zzR8l/z2uSA==

//        String decrypt = AESUtils.decrypt("O4bJQiAVEW4zzR8l/z2uSA==");
//        log.info("AES解密后的数据是：" + decrypt);
    }

    @Value("${AES.SECRET_KEY}")
    private String value;

    @org.junit.Test
    public void getValue() {
        System.out.println("---" + value);
    }


}
