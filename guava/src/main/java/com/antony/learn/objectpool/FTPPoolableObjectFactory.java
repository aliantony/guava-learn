/*
 * @(#)FTPPoolableObjectFactory.java 2018年5月30日上午10:43:34 zfsfgk Copyright 2018
 * Thuisoft, Inc. All rights reserved. THUNISOFT PROPRIETARY/CONFIDENTIAL. Use
 * is subject to license terms.
 */
package com.antony.learn.objectpool;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * FTPPoolableObjectFactory
 * @author ChenSonglin
 * @version 1.0
 * @date 2018年5月30日
 */
public class FTPPoolableObjectFactory extends BasePooledObjectFactory<FTPClient> {

    private String host;

    private int port;

    private String user;

    private String password;

    private String passiveModeConf;

    public FTPPoolableObjectFactory(String host, int port, String user, String password, String passiveModeConf) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.passiveModeConf = passiveModeConf;
    }

    @Override
    public FTPClient create() throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(host, port);
        ftpClient.setControlKeepAliveTimeout(300);//set timeout to 5 minutes  
        ftpClient.login(user, password);
        boolean passiveMode = false;
        if (passiveModeConf == null || Boolean.parseBoolean(passiveModeConf) == true) {
            passiveMode = true;
        }
        if (passiveMode) {
            ftpClient.enterLocalPassiveMode();
        }
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        return ftpClient;
    }

    @Override
    public PooledObject<FTPClient> wrap(FTPClient ftpClient) {
        return new DefaultPooledObject<FTPClient>(ftpClient);
    }

}
