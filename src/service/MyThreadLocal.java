//package service;
//
//import model.Student;
//
//import java.util.Random;
//
//public class MyThreadLocal implements  Runnable{
//    public static final ThreadLocal threadLocal = new ThreadLocal();
//
//
//    @Override
//    public void run() {
//        String currentThreadName = Thread.currentThread().getName();
//        System.out.println(currentThreadName + " is running!");
//
//        Random random = new Random();
//        int age = random.nextInt(100);
//        Student student = getStudent();
//        student.setAge(age);
//        student.setName("james");
//        System.out.println("thread " + currentThreadName + " first read age is:" + student.getAge());
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//
//        }
//        System.out.println("thread " + currentThreadName + " second read age is:" + student.getAge());
//    }
//    public Student getStudent() {
//        Student student = (Student)threadLocal.get();
//        if (student == null) {
//            //创建一个Student对象，并保存到本地线程变量studentLocal中
//            student = new Student();
//            threadLocal.set(student);
//        }
//
//        return student;
//    }
//}
