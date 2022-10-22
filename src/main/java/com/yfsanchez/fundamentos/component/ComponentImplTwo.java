package com.yfsanchez.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplTwo implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Saludo desde Impl Two.");
    }
}
