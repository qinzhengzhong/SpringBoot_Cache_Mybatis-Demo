package test;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class TestBootTest {
    @Autowired
    StringEncryptor stringEncryptor;//密码解码器自动注入

    @org.junit.Test
    public void encryptPwd() {
        ininPass();
    }

    public static void main(String[] args) {

        String password = "qinzz@allan!";
        String data = "root";

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName(null);
        config.setProviderClassName(null);
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//        config.setIvGeneratorClassName("org.jasypt.salt.NoOpIVGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        System.out.println(encryptor.encrypt(data));
        System.out.println(encryptor.encrypt(password));


    }

    public void ininPass(){
        String possword="qinzz@allan!";
        String result = stringEncryptor.encrypt(possword);
        System.out.println(result);
    }

}
