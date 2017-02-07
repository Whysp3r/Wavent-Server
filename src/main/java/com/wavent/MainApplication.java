package com.wavent;

import com.wavent.bean.Event;
import com.wavent.bean.Message;
import com.wavent.bean.User;
import com.wavent.repository.EventRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	private static Logger logger = Logger.getLogger(MainApplication.class);

	@Autowired
	private EventRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		repository.deleteAll();

		logger.info("Database clear");


		Event testParticpant = new Event("Slackline au park","venez taper la slack les potos");
		testParticpant.setAddress("36 cours berriat, 38000, Grenoble");

		User user = new User("particp@gmail.com","Remi","Prodan",25);
		user.setId("5846e536dfbff329fbf57474");
		testParticpant.setPictureEvent("http://54.244.143.188:8080/test.jpg");

		testParticpant.addParticipant(user);

		testParticpant.setDate(new Date());
		testParticpant.setNbParticipantsMax(4);

		Message message1 = new Message();
		Message message2 = new Message();

		message1.setIdEvent(testParticpant.getId());
		message1.setIdUser(user.getId());
		message1.setDate(new Date());
		message1.setMessage("Hello, tu veux que je ramène ma slack ?");

		message2.setIdEvent(testParticpant.getId());
		message2.setIdUser(user.getId());
		message2.setDate(new Date());
		message2.setMessage("Ouai carrément !");

		testParticpant.addMessage(message1);
		testParticpant.addMessage(message2);

		repository.save(testParticpant);

		logger.info("Application wavent started !");

	}
}
