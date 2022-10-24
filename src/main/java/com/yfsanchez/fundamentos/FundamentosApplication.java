package com.yfsanchez.fundamentos;

import com.yfsanchez.fundamentos.bean.MyBean;
import com.yfsanchez.fundamentos.bean.MyBeanWithDependency;
import com.yfsanchez.fundamentos.bean.MyBeanWithProperties;
import com.yfsanchez.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;

	public FundamentosApplication(@Qualifier("componentImplTwo") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.componentDependency.saludar();
		this.myBean.print();
		this.myBeanWithDependency.print();
		System.out.println(this.myBeanWithProperties.nameComplete());
	}
}
