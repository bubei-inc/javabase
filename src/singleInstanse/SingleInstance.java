package singleInstanse;

public class SingleInstance {
    static SingleInstance singleInstance;
    static SingleInstance getInstance() {
        if(singleInstance == null) {
            synchronized(SingleInstance.class) {
                if (singleInstance == null)
                    singleInstance = new SingleInstance();
            }

        }
        return singleInstance;
    }

}
