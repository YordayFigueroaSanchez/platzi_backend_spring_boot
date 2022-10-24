package com.yfsanchez.fundamentos.bean;

public class MyBeanWithPropertiesImpl implements MyBeanWithProperties {

    private String name;
    private String lastname;

    public MyBeanWithPropertiesImpl(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String nameComplete() {
        return name + "-" + lastname;
    }
}
