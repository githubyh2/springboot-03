package com.example.springboot03.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

/**
 * @author yanhao
 * @data 2023/12/7
 */
@Slf4j
@Controller
//@RestController
//@RequestMapping("/file")
public class FileController {
    //读取application.properties文件中的filePath属性
    @Value("${FILE.BASE_DIR}")
    private String fileSavePath;

    /**
     * 前往上传页面
     *
     * @return 页面名称
     */
    @GetMapping("/goToUpload")
    public String goIndex() {
        log.info("文件路径：" + fileSavePath);
        return "upload";
    }


    //以时间作为文件夹
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    // 找一个计算机的磁盘位置，比如 D:\\, 我这里使用的是临时文件路径
//    public static final String BASE_DIR = "D:\\tempFilePath\\";

    // 定义接口类型和二级路径，完整的接口url是：/file/upload
    @PostMapping("/uploadFile")
    public void upload(@RequestParam MultipartFile file) {
        // 获取文件的名称
        String originalFilename = file.getOriginalFilename();
        log.info("文件名称是：" + originalFilename);

        // 通过原始文件名获取文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        log.info("文件后缀是：" + suffix);

        try {
            // 新建一个文件路径
            File uploadFile = new File(fileSavePath + originalFilename);

            log.info("-------" + uploadFile);
            // 当父级目录不存在时，自动创建
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }
            // 存储文件到电脑磁盘
            file.transferTo(uploadFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/download")
    public void download(@RequestParam String fileName, HttpServletResponse response) {
        //  新建文件流，从磁盘读取文件流[定义输入流，通过输入流读取文件内容]
        try (FileInputStream fis = new FileInputStream(fileSavePath + fileName);
             BufferedInputStream bis = new BufferedInputStream(fis);
             //  OutputStream 是文件写出流，将文件下载到浏览器客户端 [通过response对象，获取到输出流]
             OutputStream os = response.getOutputStream()) {

            // 新建字节数组，长度是文件的大小，比如文件 6kb, bis.available() = 1024 * 6
            byte[] bytes = new byte[bis.available()];
            // 从文件流读取字节到字节数组中
            bis.read(bytes);
            // 重置 response
            response.reset();
            // 设置 response 的下载响应头
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));  // 注意，这里要设置文件名的编码，否则中文的文件名下载后不显示
            // 写出字节数组到输出流
            os.write(bytes);
            // 刷新输出流
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
