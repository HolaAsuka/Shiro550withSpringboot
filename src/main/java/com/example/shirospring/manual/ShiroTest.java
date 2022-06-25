package com.example.shirospring.manual;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

import java.util.Scanner;

public class ShiroTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input username:");
        String username = sc.next();
        System.out.print("Input password:");
        String password = sc.next();

        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");

        securityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        boolean flag;

        try {
            subject.login(token);
            flag = true;
        }catch (IncorrectCredentialsException e){
            flag = false;
        }

        System.out.println(flag ? "登录成功": "登录失败");

        System.out.println("admin?: "+ subject.hasRole("admin"));

        System.out.println("Can order-del?: " + subject.isPermitted("order-del"));
    }
}
