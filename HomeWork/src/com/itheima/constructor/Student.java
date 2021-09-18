package com.itheima.constructor;

public class Student extends Person {
    private int Score;



    // 子类的空参构造方法
    public Student() {
        super();
    }

    // 子类的有参构造方法。注意，这里除了子类自己的参数，还要加上从夫类继承的构造参数。!!!
    public Student(int Score, String name, String age, String birthday, String id
                   // !!!!!切记，参数的名字一定要和父类的一模一样！！！！
    ) {
        // 父类的参数直接用super继承
        super(id, name, age, birthday);
        // 子类自己独有的构造参数，使用this关键字
        this.Score = Score;
    }

}
