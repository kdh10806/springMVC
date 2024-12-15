//package com.kdh10806;
//
//import com.kdh10806.calculator.domain.Calculator;
//import com.kdh10806.calculator.domain.PositiveNumber;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet("/calculate")
//public class CalculatorGenericServlet extends GenericServlet {
//    private static final Logger log = LoggerFactory.getLogger(CalculatorGenericServlet.class);
//
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        log.info("service");
//        int operand1 = Integer.parseInt(req.getParameter("operand1"));
//        String operator = req.getParameter("operator");
//        int operand2 = Integer.parseInt(req.getParameter("operand2"));
//
//        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
//
//        PrintWriter writer = res.getWriter();
//        writer.println(result);
//    }
//
//
//}
