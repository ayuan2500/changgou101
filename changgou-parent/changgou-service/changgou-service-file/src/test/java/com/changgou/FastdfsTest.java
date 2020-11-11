package com.changgou;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

/***
 * @ClassName FastdfsTest
 * @Description Fastdfs上传/下载/删除图片测试类
 * @version 1.0.0
 * @author ayuan
 * @createTime 2020/11/10 20:26:00
 */
public class FastdfsTest {

    //上传图片
    @Test
    public void upload() throws Exception {
        //1.创建一个配置文件 用于配置连接到tracker server的ip地址和端口
        //2.加载配置文件使其生效
        ClientGlobal.init("E:\\IdeaProjects\\changgou101\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");
        //3.创建一个trackerClient
        TrackerClient trackerClient = new TrackerClient();
        //4.获取trackerserver
        TrackerServer trackerServer = trackerClient.getConnection();
        //5.创建storageServer 赋值为空
        //6.创建storageClient （提供了很多图片操作的API)
        //参数1 指定trackserver
        //参数2 指定storageserver
        StorageClient storageClient = new StorageClient(trackerServer,null);
        //7.执行上传图片
        //参数1 指定图片的所在的路径
        //参数2 指定图片的后缀 去掉 "点"
        //参数3 指定图片的元数据 ：高度 宽度  像素  作者  拍摄日期 文件大小.........
        String[] pngs = storageClient.upload_file("C:\\Users\\haodada\\Desktop\\btn01_73eb741.jpg", "png", null);
        for (String png : pngs) {
            System.out.println(png);
        }
    }

    //下载图片 单例模式
    @Test
    public void download() throws Exception{
        //1.创建一个配置文件 用于配置连接到tracker server的ip地址和端口
        //2.加载配置文件使其生效
        ClientGlobal.init("E:\\IdeaProjects\\changgou101\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");
        //3.创建一个trackerClient
        TrackerClient trackerClient = new TrackerClient();
        //4.获取trackerserver
        TrackerServer trackerServer = trackerClient.getConnection();
        //5.创建storageServer 赋值为空
        //6.创建storageClient （提供了很多图片操作的API)
        //参数1 指定trackserver
        //参数2 指定storageserver
        StorageClient storageClient = new StorageClient(trackerServer,null);
        //7.执行上传图片
        //参数1 组名  参数2  文件名
        byte[] bytes = storageClient.download_file("group1", "M00/00/00/wKjThF-q-BmAKCFeAAEb7LCk354195.png");
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\riji\\xiangmu2test\\1234.jpg"));
        fileOutputStream.write(bytes);
        fileOutputStream.close();//放finally中
    }

    //删除图片
    @Test
    public void deleteFile() throws Exception{
        //1.创建一个配置文件 用于配置连接到tracker server的ip地址和端口
        //2.加载配置文件使其生效
        ClientGlobal.init("E:\\IdeaProjects\\changgou101\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");
        //3.创建一个trackerClient
        TrackerClient trackerClient = new TrackerClient();
        //4.获取trackerserver
        TrackerServer trackerServer = trackerClient.getConnection();
        //5.创建storageServer 赋值为空
        //6.创建storageClient （提供了很多图片操作的API)
        //参数1 指定trackserver
        //参数2 指定storageserver
        StorageClient storageClient = new StorageClient(trackerServer,null);
        int group1 = storageClient.delete_file("group1", "M00/00/00/wKjThF-q-BmAKCFeAAEb7LCk354195.png");
        //是否删除成功
        if(group1==0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }
}
