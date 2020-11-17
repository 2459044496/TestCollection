package com.cui.net;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/9/26 15:44
 */
public class ServerSocketTest {
    public static void main(String[] args) throws Exception{
        try (ServerSocket serverSocket = new ServerSocket(2000)){
            Socket socker = null;
            socker = serverSocket.accept();
        }
    }
}
