package com.example.springboot03.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author yanhao
 * @data 2023/11/16
 * <p>
 * jasypt-spring-boot-starter 使用 2.X版本的， 因为3.x版本的需要使用jdk 1.9以上，否则项目启动会报错
 * 该 Configuration 主要是对 数据库的密码进行 加盐加密
 */
@Slf4j
@Configuration
@EnableEncryptableProperties
public class JasyptConfiguration {

    @Autowired
    private Environment environment;

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {

        String encKey = environment.getProperty("jasypt.encryptor.password");
        log.info("使用的密钥是：" + encKey);

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        // 加密所需要的盐
        config.setPassword(encKey);
        // 加密算法
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;

    }

    public static void main(String[] args) {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        // 加密所需的盐
//        basicTextEncryptor.setPassword("dbportal_jgkjb");
        basicTextEncryptor.setPassword("springboot3");

        // 需要加密的数据
        String encrypt = basicTextEncryptor.encrypt("root123");
        log.info("----加密后密码是----:" + encrypt);

//        String decrypt = basicTextEncryptor.decrypt("H73duDZxLsCFb73zRSO7HecEj+MkNa3s"); ep6/tOZlZU/4FNIpsG7DmA==
//        String decrypt = basicTextEncryptor.decrypt("T4PaIKpEoA7PTlR0veJQxA==");

        String decrypt = basicTextEncryptor.decrypt("81X1pN6a1bTHbloiTS8fVQ==");
        log.info("---解密的密码是---:" + decrypt);
    }
}
