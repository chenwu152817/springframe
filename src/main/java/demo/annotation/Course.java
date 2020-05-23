package demo.annotation;

/**
 * @author jjj
 * @date 2020/5/23 13:59
 */
@CourseInfoAnnotation(courseName = "数学",courseTag = "微积分",courseProfile = "ss")
public class Course {

    @PersonInfoAnnotation(name = "jjj",language = {"AAA"})
    private String author;


}
