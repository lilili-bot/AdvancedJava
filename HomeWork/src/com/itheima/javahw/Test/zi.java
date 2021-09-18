package com.itheima.javahw.Test;

public class zi extends fu {
    public void show() {
        System.out.println("i am the zi method.");
    }
    public void method(){
        show(); // this.show()
        super.show();
    }


}
