package ThreadLocalTest;

import model.Student;

import java.lang.invoke.MutableCallSite;

/**
 * @author syp
 * @package_name PACKAGE_NAME
 * @date 2019-05-30 11:27
 * @description
 **/
public class ThreadLocalTest {
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>() {
        @Override
        protected Object initialValue() {
            System.out.println("调用get方法是，调用initialValue方法");
            return null;
        }
    };

    public static void main(String[] args) {
        Student student = new Student();

        new Thread(new MyIntegerTest(student)).start();
        new Thread(new MyIntegerTest(student)).start();


    }

    public static class MyIntegerTest  implements  Runnable {
       private Student student;
       MyIntegerTest(Student student) {
           this.student = student;
       }

        @Override
        public void run() {
           ThreadLocal threadLocal = ThreadLocalTest.threadLocal;
           student.setName(Thread.currentThread().toString());
           threadLocal.set(student);
           for(int i = 0; i < 5; i++) {
               Student student1 = (Student)threadLocal.get();
               System.out.println(student1.getName() + ":" + i);
           }




        }

    }
}
