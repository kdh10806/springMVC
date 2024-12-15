//package com.kdh10806;
//
//import com.kdh10806.calculator.domain.Calculator;
//import com.kdh10806.calculator.domain.PositiveNumber;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.nio.charset.StandardCharsets;
//
//public class CustomWebAppServer2 {
//    private final int port;
//
//    private static final Logger logger = LoggerFactory.getLogger(CustomWebAppServer2.class);
//
//    public CustomWebAppServer2(int port) {
//        this.port = port;
//    }
//
//    public void start() throws Exception {
//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//            logger.info("[CustomWebAppServer] started on {} port.", port);
//
//            Socket clientSocket;
//            logger.info("[CustomWebAppServer] Waiting for client connection...");
//
//            while ((clientSocket = serverSocket.accept()) != null) {
//                logger.info("[CustomWebAppServer] client connected!");
//
//                /**
//                 * 2. 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
//                 * 요청마다 쓰레드를 생성하게 되면 쓰레드가 많아지게된다.(비용이 많이 발생, 사용자가 많아지는 경우에도 동일)
//                 * 쓰레드가 많아지게 되면 Context-switching 비용도 증가하게 된다.
//                 * CPU, Memory 사용량도 증가하게 됨.
//                 * -> Thread Pool 도입
//                 */
//                new Thread(new ClientRequestHandler(clientSocket)).start();
//            }
//        }
//    }
//}
