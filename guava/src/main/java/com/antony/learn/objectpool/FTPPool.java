/*
 * @(#)FTPPool.java 2018年5月30日上午10:39:29
 * zfsfgk
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.antony.learn.objectpool;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * 
 * FTPPool
 * @author ChenSonglin
 * @version 1.0
 * @date 2018年5月30日
 */
public class FTPPool extends Pool<FTPClient>{

    /**
     * @param poolConfig 对象池配置
     * @param factory FtpClient对象工厂
     */
    public FTPPool(GenericObjectPoolConfig poolConfig, String host, int port, String user, String pass, String passiveMode) {
        super(poolConfig, new FTPPoolableObjectFactory(host, port, user, pass, passiveMode));
    }
    
    public static void main(String[] args) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();  
        //最大池容量  
        config.setMaxTotal(10);
        //从池中取对象达到最大时,继续创建新对象.  
        config.setBlockWhenExhausted(false); 
        //池为空时取对象等待的最大毫秒数.  
        config.setMaxWaitMillis(60*1000);
        //取出对象时验证(此处设置成验证ftp是否处于连接状态).  
        config.setTestOnBorrow(true);  
        //还回对象时验证(此处设置成验证ftp是否处于连接状态).  
        config.setTestOnReturn(true);
        
        FTPPool pool = new FTPPool(config,"172.25.8.168",21,"test","test","true");  
        
        System.out.println("borrowSize1:"+pool.borrowSize());  
        System.out.println("inPoolSize1:"+pool.inPoolSize());  
        long begin=System.currentTimeMillis();  
        for(int i=0;i<8;i++){  
            FTPClient ftpClient = pool.getResource();  
            System.out.println("ftpClient" + (i+1) +" isConnected:"+ ftpClient.isConnected());  
            pool.returnResource(ftpClient);  
        }  
        System.out.println("time:"+(System.currentTimeMillis()-begin));  
        System.out.println("borrowSize2:"+pool.borrowSize());  
        System.out.println("inPoolSize2:"+pool.inPoolSize());  
        pool.destroy();  
    }

}
