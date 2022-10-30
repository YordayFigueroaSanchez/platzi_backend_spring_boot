package com.yfsanchez.fundamentos;

import com.yfsanchez.fundamentos.bean.MyBean;
import com.yfsanchez.fundamentos.bean.MyBeanWithDependency;
import com.yfsanchez.fundamentos.bean.MyBeanWithProperties;
import com.yfsanchez.fundamentos.component.ComponentDependency;
import com.yfsanchez.fundamentos.entity.User;
import com.yfsanchez.fundamentos.pojo.UserPojo;
import com.yfsanchez.fundamentos.repository.UserRepository;
import com.yfsanchez.fundamentos.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

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
	private UserService userService;

	public FundamentosApplication(@Qualifier("componentImplTwo") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserRepository userRepository,
								  UserService userService){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		ejemplos01();
		saveUserToDataBase();
		findWithMethodFindRepository();
		saveWithTransactional();
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
		User user01 = new User("ja01","user01@g.com", LocalDate.of(2022,1,24));
		User user02 = new User("user02","user02@g.com", LocalDate.of(2022,2,25));
		User user03 = new User("user03","user03@g.com", LocalDate.of(2022,3,26));
		User user04 = new User("tat04","user04@g.com", LocalDate.of(2022,4,27));
		User user05 = new User("user02","user05@g.com", LocalDate.of(2022,6,28));
		User user06 = new User("user06","user06@g.com", LocalDate.of(2022,8,29));

		List<User> listUser = Arrays.asList(user01,user02,user03,user04,user05,user06);
		listUser.stream().forEach(userRepository::save);

	}
	private void findWithMethodFindRepository(){
//		LOGGER.info("Usuario find : " + userRepository.findByUserEmail("user05@g.com").
//				orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
//
//		userRepository.findAndSort("user", Sort.by("id").descending())
//				.stream()
//				.forEach(user -> LOGGER.info("mensaje : " + user));
//
//		userRepository.findByName("user02")
//				.stream()
//				.forEach(user -> LOGGER.info("usuario : " + user));
//
//		LOGGER.info("findByNameAndEmail" + userRepository.findByNameAndEmail("tat04","user04@g.com")
//				.orElseThrow(()-> new RuntimeException("test...test")));

//		userRepository.findByNameLike("%user%")
//				.stream()
//				.forEach(user -> LOGGER.info("findByNameLike : " + user));

//		userRepository.findByNameOrEmail(null, "user02@g.com")
//				.stream()
//				.forEach(user -> LOGGER.info("findByNameOrEmail : " + user));

//		userRepository.findByBirthDateBetween(LocalDate.of(2022,3,20), LocalDate.of(2022,6,20))
//				.stream()
//				.forEach(user -> LOGGER.info("findByBirthDateBetween : " + user));

//		userRepository.findByNameLikeOrderByIdDesc("%user%")
//				.stream()
//				.forEach(user -> LOGGER.info("findByNameLikeOrderByIdDesc : " + user));

//		userRepository.findByNameContainingOrderByIdDesc("user")
//				.stream()
//				.forEach(user -> LOGGER.info("findByNameContainOrderByIdDesc : " + user));

		LOGGER.info("Usuario find by getAllByBirthDateAndEmail: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2022,1,24),"user01@g.com").
				orElseThrow(() -> new RuntimeException("No se encontro el usuario")));

	}

	private void saveWithTransactional(){

		User user01 = new User("usu01","auser01@g.com", LocalDate.of(2022,1,24));
		User user02 = new User("usu02","auser02@g.com", LocalDate.of(2022,2,25));
		User user03 = new User("usu03","auser03@g.com", LocalDate.of(2022,3,26));
		User user04 = new User("usu04","auser04@g.com", LocalDate.of(2022,4,27));
		User user05 = new User("usu05","auser05@g.com", LocalDate.of(2022,6,28));
		User user06 = new User("usu06","auser06@g.com", LocalDate.of(2022,8,29));

		List<User> users = Arrays.asList(user01,user02,user03,user04,user05,user06);

		userService.saveTransactional(users);

		userService.getAll().stream()
				.forEach(user -> {LOGGER.info("Usuario listar :" + user);});
	}
}
