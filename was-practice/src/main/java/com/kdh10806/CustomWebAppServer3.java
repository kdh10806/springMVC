package com.kdh10806;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebAppServer3 {
    private final int port;

    //Thread Pool 생성
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static final Logger logger = LoggerFactory.getLogger(CustomWebAppServer3.class);

    public CustomWebAppServer3(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebAppServer] started on {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebAppServer] Waiting for client connection...");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebAppServer] client connected!");

                /**
                 * 3. Thread Pool 사용
                 * 요청 1 : pool-1-thread-1
                 * 요청 2 : pool-1-thread-2
                 */
                executorService.execute(new ClientRequestHandler(clientSocket));
            }
        }
    }
}
