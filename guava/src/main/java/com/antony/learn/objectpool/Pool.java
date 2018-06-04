/*
 * @(#)Pool.java 2018年5月30日上午10:31:13
 * zfsfgk
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.antony.learn.objectpool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Pool
 * @author ChenSonglin
 * @version 1.0
 * @date 2018年5月30日
 */
public abstract class Pool <T> {
    
    private static final Logger logger = LoggerFactory.getLogger(Pool.class);
    
    private final GenericObjectPool<T> internalPool; 
    
    public Pool(GenericObjectPoolConfig poolConfig, PooledObjectFactory<T> factory)    
    {  
        this.internalPool = new GenericObjectPool<T>(factory, poolConfig);    
    } 
    
    public T getResource(){  
        try{  
            return this.internalPool.borrowObject();  
        }catch(Exception e){  
            logger.error("获取资源对象失败", e);
            return null;  
        }  
    }  
      
    public void returnResource(T resource){  
        try {  
            this.internalPool.returnObject(resource);  
        }catch (Exception e) {  
            logger.error("归还资源对象失败", e);
        }  
    }  
      
    public void destroy(){  
        try{  
            this.internalPool.close();    
        }catch (Exception e) {  
            logger.warn("对象池销毁异常", e);
        }  
    }  
      
    public int inPoolSize(){  
        return this.internalPool.getNumIdle();  
    }  
      
    public int borrowSize(){  
        return this.internalPool.getNumActive();  
    }  

}
