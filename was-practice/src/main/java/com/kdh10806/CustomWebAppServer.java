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
//public class CustomWebAppServer {
//    private final int port;
//
//    private static final Logger logger = LoggerFactory.getLogger(CustomWebAppServer.class);
//
//    public CustomWebAppServer(int port) {
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
//                 * 1. 사용자 요청을 메인 Thread가 처리하도록
//                 */
//                try(InputStream in = clientSocket.getInputStream();
//                    OutputStream out = clientSocket.getOutputStream()) {
//                    //line-by-line으로 읽으려고 bufferedreader 사용
//                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
//                    DataOutputStream dos = new DataOutputStream(out);
//
////                    String line;
////                    while ((line = br.readLine()) != "") {
////                        System.out.println(line);
////                    }
//
//                    HttpRequest httpRequest = new HttpRequest(br);
//
//                    //path 처리
//                    if(httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
//                        QueryStrings queryStrings = httpRequest.getQueryString();
//
//                        //Query Parameter 처리
//                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
//                        String operator = queryStrings.getValue("operator");
//                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));
//
//                        //작업 수행
//                        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
//                        byte[] body = String.valueOf(result).getBytes();
//
//                        //반환
//                        HttpResponse response = new HttpResponse(dos);
//                        response.response200Header("application/json", body.length);
//                        response.responseBody(body);
//                    }
//                }
//            }
//        }
//
//    }
//}
