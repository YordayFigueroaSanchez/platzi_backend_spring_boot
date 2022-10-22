package com.yfsanchez.fundamentos;

import com.yfsanchez.fundamentos.bean.MyBean;
import com.yfsanchez.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;

	public FundamentosApplication(@Qualifier("componentImplTwo") ComponentDependency componentDependency, MyBean myBean){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.componentDependency.saludar();
		this.myBean.print();
	}
}
