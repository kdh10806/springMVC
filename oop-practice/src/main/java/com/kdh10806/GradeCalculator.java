package com.kdh10806;


import java.util.List;

public class GradeCalculator {
    //일급콜렉션
    private final Courses courses;
//    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public GradeCalculator(Courses courses) {
        this.courses = courses;
    }

    //• 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
    public double calculateGrade() {
        //(학점수×교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
/*        double multipliedCreditAndCourseGrade = 0;
        for(Course course : courses) {
            //객체를 getter 하는게 아니라 메시지를 보내서 동작을 위임
            multipliedCreditAndCourseGrade += course.multiplyCreditAndcourseGrade();
        }*/

        //총학점수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();
//        int totalCompleteCredit = courses.stream()
//                .mapToInt(Course::getCredit)
//                .sum();


        return totalMultipliedCreditAndCourseGrade/totalCompletedCredit;
    }
}
