package com.changgou.file.controller;

import com.changgou.file.FastDFSFile;
import com.changgou.file.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/***
 * @ClassName FileController
 * @Description 上传/下载/删除图片请求处理
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/10 21:20:00
 */
@RestController
public class FileController {
    //获取application.yaml中的pic.url的数据
    @Value("${pic.url}")
    private String picPath;

    /***
     * @title upload
     * @description 图片上传
     * @param file 客户端传输过来的文件本身
     * @return java.lang.String
     * @author ayuan
     * @updateTime 2020/11/10 22:26
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                //1.获取到文件本身的字节数组
                byte[] content = file.getBytes();
                //2.获取文件的名称 --》获取图片的后缀
                String name = file.getOriginalFilename();//1234.jpg
                //3.上传到fastdfs上
                //[0] =group1
                //[1] =M00/00/00/wKjThF-qeNyATiVHAAAl8vdCW2Y824.png
                String[] upload = FastDFSClient.upload(new FastDFSFile(
                        name,//文件名
                        content,//文件的本身的字节数组
                        StringUtils.getFilenameExtension(name) //获取文件的后缀
                ));
                //4.拼接Ulr
                // http://192.168.211.132:8080/group1/M00/00/00/wKjThF-qeNyATiVHAAAl8vdCW2Y824.png
                String realPath = picPath+"/"+upload[0]+"/"+upload[1];
                //5.返回url给页面
                return realPath;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

