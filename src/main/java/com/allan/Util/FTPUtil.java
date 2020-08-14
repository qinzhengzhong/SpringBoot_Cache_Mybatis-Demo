package com.allan.Util;

import java.io.*;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * 功能描述: FTP客户端工具类
 *
 * @param:
 * @return: 
 * @auther: qinzhengzhong
 * @date: 2018/6/22 11:09 下午
 */
public class FTPUtil {

    private static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);

    private static FTPClient ftpClient;
    //从本地文件获取各种属性
    private  static String ftpIP="1270.0.01";
    private  static Integer ftpPort=22;
    private static String ftpUserName="root";
    private static String ftpPassword="123456";
    private static String ftpEncode ="UTF-8";

    public FTPUtil() {

    }

    /**
     *
     * 功能描述: l连接ftp服务
     *
     * @param:
     * @return:
     * @auther: qinzhengzhong
     * @date: 2018/6/22 11:26 下午
     */
    public static synchronized boolean connectServer() {
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding(ftpEncode);//解决上传文件时文件名乱码
        int reply = 0 ;
        try {
            // 连接至服务器
            ftpClient.connect(ftpIP,ftpPort);
            // 登录服务器
            ftpClient.login(ftpUserName, ftpPassword);
            //登陆成功，返回码是230
            reply = ftpClient.getReplyCode();
            // 判断返回码是否合法
            if(!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return false;
            }
        } catch (SocketException e) {
           logger.error("连接ftp服务器异常");
        } catch (IOException e) {
            logger.error("连接ftp服务器异常",e);
        }

        return true;
    }

    /**
     *
     * 功能描述: 判断ftp服务器文件是否存在
     *
     * @param:
     * @return:
     * @auther: qinzhengzhong
     * @date: 2018/6/22 11:13 下午
     */
    public static boolean existFile(String path)  {
        boolean flag = false;
        FTPFile[] ftpFileArr;
        try {
            ftpFileArr = ftpClient.listFiles(path);
            if (ftpFileArr.length > 0) {
                flag = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     *
     * 功能描述: 删除ftp文件
     *
     * @param:
     * @return:
     * @auther: qinzhengzhong
     * @date: 2018/6/22 11:14 下午
     */
    public static synchronized boolean deleteFile(String pathname, String filename){
        boolean flag = false;
        try {
            logger.info("开始删除FTP文件");
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.dele(filename);
            ftpClient.logout();
            flag = true;
            logger.info("删除文件成功");
        } catch (Exception e) {
            logger.warn("删除文件失败");
            logger.error("删除文件失败",e);
        } finally {
            if(ftpClient.isConnected()){
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                   logger.error("删除ftp文件,关闭FTP连接异常",e);
                }
            }
        }
        return flag;
    }


   /**
    *
    * 功能描述: 从FTP server下载到本地文件夹
    *
    * @param:directory   下载目录
    * @param :downloadFile 下载的文件
    * @param saveFile 存在本地的路径
    * @return:
    * @auther: qinzhengzhong
    * @date: 2018/6/22 11:12 下午
    */
    public static synchronized boolean download(String directory, String downloadFile, String saveFile){
        boolean flag = false;
        FTPFile[] fs=null;
        try {
            fs = ftpClient.listFiles(downloadFile);
            if(fs.length<0) {
                return flag;
            }
            //1、遍历FTP路径下所有文件
            for(FTPFile file:fs){
                File localFile = new File(saveFile);
                //2、保存到本地
                OutputStream os = new FileOutputStream(localFile);
                //retrieveFile(FTP服务端的源路径),这个路径要和listFiles的路径一致
                ftpClient.retrieveFile(directory, os);
                //3、删除FTP中的上面保存的文件
                //循环外关闭，读一个关闭一次挺慢的
                os.flush();
                os.close();
            }
            flag = true;
        } catch (IOException e) {
            logger.error("下载文件异常",e);
        }
        return flag;
    }


    /**
     *
     * 功能描述: 上传文件
     *
     * @param:
     * @return: 
     * @auther: qinzhengzhong
     * @date: 2018/6/22 11:11 下午
     */
    public static synchronized boolean upload(InputStream inputStream , String fileName , String path) {
        boolean flag = false;
        try {
            //切换工作路径，设置上传的路径
            ftpClient.changeWorkingDirectory(path);
            //设置1M缓冲
            ftpClient.setBufferSize(1024);
            // 设置被动模式
            ftpClient.enterLocalPassiveMode();
            // 设置以二进制方式传输
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            /*
             * 第一个参数：服务器端文档名
             * 第二个参数：上传文档的inputStream
             * 在前面设置好路径，缓冲，编码，文件类型后，开始上传
             */
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            flag = true;
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return false;
        } catch (Exception e) {
            logger.error("上传文件异常",e);
            return false;
        } finally {
            closeClient();
        }
        return flag;
    }

    /**
     *
     * 功能描述:验证
     *
     * @param:
     * @return:
     * @auther: qinzhengzhong
     * @date: 2018/6/22 11:14 下午
     */
    public static boolean checkSubfolder(String path, String subfolderName) {
        try {
            //切换到FTP根目录
            ftpClient.changeWorkingDirectory(path);
            //查看根目录下是否存在该文件夹
            InputStream is = ftpClient.retrieveFileStream(new String(subfolderName.getBytes("UTF-8")));
            if (is == null || ftpClient.getReplyCode() == FTPReply.FILE_UNAVAILABLE) {
                //若不存在该文件夹，则创建文件夹
                return createSubfolder(path,subfolderName);
            }
            if (is != null) {
                is.close();
                return true;
            }
        } catch (IOException e) {
            logger.error("断开与FTP远程服务器的连接异常",e);
        } catch(Exception e) {
            logger.error("断开与FTP远程服务器的连接异常",e);
        }
        return false;
    }

    /**
     *
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: qinzhengzhong
     * @date: 2018/6/22 11:14 下午
     */
    public static synchronized boolean createSubfolder(String path,String subfolderName){
        try {
            ftpClient.changeWorkingDirectory(path);
            ftpClient.makeDirectory(subfolderName);
        } catch (IOException e) {
            logger.error("断开与FTP远程服务器的连接异常",e);
        } catch (Exception e) {
            logger.error("断开与FTP远程服务器的连接异常",e);
        }
        return true;
    }


    /**
     *
     * 功能描述: 断开与远程服务器的连接
     *
     * @param:
     * @return:
     * @auther: qinzhengzhong
     * @date: 2018/6/22 11:14 下午
     */
    public static void closeClient(){
        if (ftpClient != null && ftpClient.isConnected()) {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                logger.error("断开与FTP远程服务器的连接异常",e);
            }
        }

    }



    public static void main(String[] args) {

        try {
            FTPUtil.connectServer();
            File file = new File("D:\\test.doc");
            InputStream stream = new FileInputStream(file);
            String ftpPath = "D:\\FTP";
            String fileName = "文件夹";
            boolean b = FTPUtil.checkSubfolder(ftpPath, fileName);
            if(stream != null && b) {
                FTPUtil.upload(stream, "aaa.doc", fileName);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            FTPUtil.closeClient();
        }


    }

}