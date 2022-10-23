package com.yfsanchez.fundamentos.bean;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void print() {
        int numero = 1;
        System.out.println("print desde bean MyBeanImpl.");
        System.out.println(this.myOperation.sum(numero));
    }
}
