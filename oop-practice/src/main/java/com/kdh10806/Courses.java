package com.kdh10806;

import java.util.List;

//일급 콜렉션
//해당 정보 하나만 가진 클래스 - 코스와 관련된 메서드를 모아놓는 느낌
public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses){
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        //최종
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndcourseGrade)
                .sum();

//        double multipliedCreditAndCourseGrade = 0;
//        for(Course course : courses) {
//            //변경에 유리한 코드로 수정
////            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
//            //객체를 getter 하는게 아니라 메시지를 보내서 동작을 위임
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndcourseGrade();
//        }
//
//        return multipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
