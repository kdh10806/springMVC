package com.kdh10806;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
 * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
 * • 일급 컬렉션 사용
 */
public class GradeCalculatorTest {
    //1. 도메인 판별 : 이수과목, 학점 계산기
    //2. 과목 객체 클래스
    //3. 관계 설정 : 학점계산기 - (학점수*교과목 평점)의 합계

    @DisplayName("평균학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+"));

        //학점계산기
        //이수과목을 전달하여 평균 학점 계산 요청
//        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        GradeCalculator gradeCalculator = new GradeCalculator(new Courses(courses));
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }
}
