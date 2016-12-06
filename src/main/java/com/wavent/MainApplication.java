package com.wavent;

import com.wavent.bean.Event;
import com.wavent.bean.User;
import com.wavent.repository.EventRepository;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		//Create some new events
		repository.save(new Event("Apero chez Nono","Venez partager un moment agreable avec plein de jacko bitchies"));
		repository.save(new Event("Coinche bitchies","Ca joue ou sa discute bordel"));
		repository.save(new Event("Slackline au park","venez taper la slack les potos"));

		Event testParticpant = new Event("Slackline au park","venez taper la slack les potos");

		User user = new User("particp@gmail.com","Nono","Rolnd",25);
		user.setId("5846e536dfbff329fbf57474");

		testParticpant.addParticipant(user);

		testParticpant.setDate(new Date());
		testParticpant.setNbParticipantsMax(4);
		repository.save(testParticpant);

		logger.info("Application wavent started !");

	}
}
