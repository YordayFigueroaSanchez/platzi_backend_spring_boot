package com.yfsanchez.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplOne implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Saludo desde Impl One.");
    }
}
