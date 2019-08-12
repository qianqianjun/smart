package buct.qianqianjun.create;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Scanner;

import javax.crypto.Cipher;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
public class RsaTest{
    public static String byte2HexStr(byte buf[]){
        StringBuilder sb=new StringBuilder();
        for(Integer i=0;i<buf.length;i++){
            String hex=Integer.toHexString(buf[i] & 0xff);
            if(hex.length()==1)
                hex='0'+hex;
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception{
        Scanner scanner=new Scanner(System.in);
        String clearText=scanner.next();
        scanner.close();

//        SecureRandom secureRandom = new SecureRandom();
//        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
//        keyPairGenerator.initialize(1024,secureRandom);
//
//        KeyPair keyPair=keyPairGenerator.generateKeyPair();
//        RSAPublicKey publicKey=(RSAPublicKey) keyPair.getPublic();
//        RSAPrivateKey privateKey=(RSAPrivateKey) keyPair.getPrivate();
//
//        String pubStr=new BASE64Encoder().encode(publicKey.getEncoded());
//        String priStr=new BASE64Encoder().encode(privateKey.getEncoded());
//
//        System.out.println("公钥为：");
//        System.out.println(pubStr);
//        System.out.println("私钥为：");
//        System.out.println(priStr);



        String pubstr="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8tf423CJo5VOleLMNrx5q79Q4k0H0PbEs75yv\n" +
                "C+KCaIOTgZt2ws4WlSoO9JLg/9urhlkmWnRQYD7BzBuREMUCAnYl0BluTLBpfZ06/K5fjLS64hGz\n" +
                "/iMvIMy7PqX83ZshHPgpAnY3h0/tbOQXWonocQiLCETN6MLyJibkewkpGwIDAQAB";
        String pristr="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALy1/jbcImjlU6V4sw2vHmrv1DiT\n" +
                "QfQ9sSzvnK8L4oJog5OBm3bCzhaVKg70kuD/26uGWSZadFBgPsHMG5EQxQICdiXQGW5MsGl9nTr8\n" +
                "rl+MtLriEbP+Iy8gzLs+pfzdmyEc+CkCdjeHT+1s5BdaiehxCIsIRM3owvImJuR7CSkbAgMBAAEC\n" +
                "gYEAgUjh3+3SuTCbrNrTOMXHvhWOvC/O2KjHUHTcUGSBCzzVH+KEgsmVbY1F4jcWxYUklw+U1hzU\n" +
                "YRh/BkByhmEJxlUwWMcoRjHLp8eax2zAbfBxZZ+a9iDOE83KJseJGWhWerAFj7UOg8v9dp+huVtL\n" +
                "SJ0B5S51LzzRa9LrqA4UrXECQQD/AWFYd8kaioZs/qfTsSiyvUD6bZKJYF3hUGZhh57QSfCpV1A4\n" +
                "L87dYPJGlb2+Tj3BHUWc+bWpr0IvdMOlKqbjAkEAvXJrJcQtq8njEbMW3yod5s4TbDgXSR5/PFau\n" +
                "FeQYsy4JySKULxXU0PLcQ1e/GaY/t1htym35QfmtpZYq1nJSaQJAOyK4zmlI66zAK7qKdN8ajwiw\n" +
                "buLGHrGIU93vQCLRQ4BCHSMwaTc9A72dsZy8GcvPKl99az/FTwpjkNnFHSJc/QJAe8JMZt6Sq1/2\n" +
                "27Av59e+svG61H6MD7NBkWxay2g4Do2rzN6vCVdssJeG9uNSrvHhO+gjyRMwuz3dh4fjMjZ6yQJB\n" +
                "AJ2lS0XXelYDhK/WqJaNvh9KLZ1n6Kn1ffsIohX62bRqWKZ0rvowhZx7MQHV/EqKq3SzIzML4RCa\n" +
                "U6o+nJojRnI=";

        Cipher cipher=Cipher.getInstance("RSA");
        byte[] result;


        PKCS8EncodedKeySpec privateKeySpec=new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(pristr));
        X509EncodedKeySpec publicKeySpec=new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer(pubstr));
        KeyFactory factory=KeyFactory.getInstance("RSA");

        PublicKey publickey=factory.generatePublic(publicKeySpec);
        PrivateKey privatekey=factory.generatePrivate(privateKeySpec);


//        // 私钥签名，公钥验证
        cipher.init(Cipher.ENCRYPT_MODE,privatekey);
        result=cipher.doFinal(clearText.getBytes());
        System.out.println("使用私钥进行签名之后的结果是：");
        System.out.println(byte2HexStr(result));

        cipher.init(Cipher.DECRYPT_MODE,publickey);
        result=cipher.doFinal(result);
        System.out.println("使用公钥进行验证之后的结果是：");
        System.out.println(new String(result));
    }
}