package com.ke.mall.controller;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.net.URI;

/**
 * @author ningwang
 * @version v1
 * @apidoc
 * @summary
 * @since 2020/5/23
 **/
//@RestController
@RequestMapping("/hadoop")
public class HadoopTestController {
    @Value("${hadoop.name-node}")
    private String nameNode;
    @Value("${hadoop.namespace}")
    private String filePath;

    @GetMapping("/test1")
    public String test1() throws Exception{
        System.setProperty("hadoop.home.dir", "D:\\hadoop-2.7.0");
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(nameNode), configuration);
        Path path = new Path("0525hadoop");
        fs.mkdirs(path);
        fs.close();
        System.out.println("hello hadoop");
        return "ok";
    }

    /**
     * 获取文件系统
     * @return
     * @throws Exception
     */
    @GetMapping("/test2")
    public String test2() throws Exception{
        //System.setProperty("hadoop.home.dir", "D:\\hadoop-2.7.0");
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(nameNode), configuration);
        System.out.println(fs.toString());
        return fs.toString();
    }

    /**
     * 上传文件到HDFS
     * @return
     * @throws Exception
     */
    @GetMapping("/test3")
    public String uploadFileToHdfs() throws Exception{
        File file = new File("hello.txt");
        FileWriter fw = new FileWriter(file, true);
        fw.write("hello hadoop");
        fw.write("be happy");
        fw.close();
        //System.setProperty("hadoop.home.dir", "D:\\hadoop-2.7.0");
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(nameNode), configuration, "root");
        Path localPath = new Path("hello.txt");
        Path remotePath = new Path(nameNode + "/ningwang/hello.txt");
        fs.copyFromLocalFile(localPath, remotePath);
        fs.close();
        return "ok";

    }

    /**
     * 从HDFS下载文件
     * @throws Exception
     */
    @GetMapping("/test4")
    public void getFileFromHDFS() throws Exception{
        //1 创建配置信息对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI(nameNode), conf, "root");
        //2 下载文件
        fs.copyToLocalFile(false, new Path(nameNode + "/ningwang/hello.txt"), new Path("copy.txt"), true);
        fs.close();
    }

    /**
     * HDFS目录创建
     * @throws Exception
     */
    @GetMapping("/test5")
    public void mkdirAtHDFS() throws Exception{
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI(nameNode), conf, "root");

        //fs.mkdirs(new Path(nameNode + "/0531"));
        fs.mkdirs(new Path(nameNode + "/0530"));
        fs.close();
    }

    /**
     * IO流从HDFS读取文件
     * @throws Exception
     */
    @GetMapping("/test6")
    public void getFileFromHDFSViaIO() throws Exception{
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI(nameNode), conf, "root");
        String fileName = nameNode + "/ningwang/hello.txt";
        System.out.println("test6");
        FSDataInputStream inputStream = fs.open(new Path(fileName));
        int len;
        byte[] buffer = new byte[128];
        while ((len = inputStream.read(buffer)) != -1 ){
            for (byte b : buffer) {
                System.out.println(b);
            }
        }
        inputStream.close();
    }

    /**
     * HDFS文件一致性模型
     * @return
     * @throws Exception
     */
    @GetMapping("/test7")
    public String writeHDFSFile() throws Exception{
        //获取配置信息对象
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI(nameNode), conf, "root");

        //创建文件输出流
        FSDataOutputStream fos = fs.create(new Path(nameNode + "/0531/helloworld.txt"));
        //FSDataOutputStream fos = fs.append(new Path(nameNode + "/ningwang/hello.txt"));
        fos.write("\n".getBytes());
        fos.write("hello world".getBytes());
        fos.hflush();
        fos.close();
        return "test7";
    }

}
