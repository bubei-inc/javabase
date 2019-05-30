package JavaExtend;

import JavaExtend.service.ExamService;
import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

public class MainTest {
    public static void main(String[] args) {
        Son son = new Son();

        son.setClazz("12");
        son.setScore(99);
        son.setAge("12");
        son.setAddress("SH");
        son.setName("lolita");
        ExamService examService = new ExamService();
        System.out.println(examService.outScore(son));
    }
}
