package com.yfsanchez.fundamentos;

import com.yfsanchez.fundamentos.bean.MyBean;
import com.yfsanchez.fundamentos.bean.MyBeanWithDependency;
import com.yfsanchez.fundamentos.bean.MyBeanWithProperties;
import com.yfsanchez.fundamentos.component.ComponentDependency;
import com.yfsanchez.fundamentos.entity.User;
import com.yfsanchez.fundamentos.pojo.UserPojo;
import com.yfsanchez.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentImplTwo") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		ejemplos01();
		saveUserToDataBase();
		findWithMethodFindRepository();
	}

	private void ejemplos01(){
		this.componentDependency.saludar();
		this.myBean.print();
		this.myBeanWithDependency.print();
		System.out.println(this.myBeanWithProperties.nameComplete());
		System.out.println(this.userPojo.toString());
		LOGGER.error("Error de test...");
	}

	private void saveUserToDataBase(){
		User user01 = new User("user01","user01@g.com", LocalDate.of(2022,10,24));
		User user02 = new User("user02","user02@g.com", LocalDate.of(2022,2,25));
		User user03 = new User("user03","user03@g.com", LocalDate.of(2022,11,26));
		User user04 = new User("user04","user04@g.com", LocalDate.of(2022,12,27));
		User user05 = new User("user05","user05@g.com", LocalDate.of(2022,6,28));
		User user06 = new User("user06","user06@g.com", LocalDate.of(2022,8,29));

		List<User> listUser = Arrays.asList(user01,user02,user03,user04,user05,user06);
		listUser.stream().forEach(userRepository::save);

	}
	private void findWithMethodFindRepository(){
		LOGGER.info("Usuario find : " + userRepository.findByUserEmail("user03@g.com").
				orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
	}
}
