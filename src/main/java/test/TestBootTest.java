package test;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

public class TestBootTest {
    @Autowired
    StringEncryptor stringEncryptor;//密码解码器自动注入

    @org.junit.Test
    public void encryptPwd() {
        String possword="qinzz@allan!";
        String result = stringEncryptor.encrypt(possword);
        System.out.println(result);
    }
}
