package test;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: qinzhengzhong
 * @Date: 2020/10/11 11:38
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class JasyptApplicationTests {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void contextLoads() {
        //加密方法
        System.out.println(stringEncryptor.encrypt("qinzz@allan!"));
        System.out.println(stringEncryptor.encrypt("qinzz@allan!"));
        //解密方法
        System.out.println(stringEncryptor.decrypt("uaNBj4ZmzCD83uedRYUXqQ=="));
        System.out.println(stringEncryptor.decrypt("oKBQENfbbQiMyPvECAgPGA=="));
    }
}
