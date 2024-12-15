package com.kdh10806;

import com.kdh10806.calculate.*;

import java.util.List;

//1. ENUM 방식
//public class Calculator {
//    public static int calculate(int operand1, String operator, int operand2) {
//        return ArithmeticOperator.calculate(operand1, operator, operand2);
//    }
//}

//2. 클래스로 구현
public class Calculator {
    //구현체 배열 생성
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(),
            new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
