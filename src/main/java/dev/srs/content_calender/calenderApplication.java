package dev.srs.content_calender;
import dev.srs.content_calender.model.Content;
import dev.srs.content_calender.model.Status;
import dev.srs.content_calender.model.Type;
import dev.srs.content_calender.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class calenderApplication {

	public static void main(String[] args) {
//			ConfigurableApplicationContext context = SpringApplication.run(calenderApplication.class, args);
			SpringApplication.run(calenderApplication.class, args);

			// printing all beans in our application
//			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

//		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
//		System.out.println(restTemplate);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository) {
		return args -> {
			// insert into database
			Content content = new Content(
					null,
					"First post check",
					"First post on blog check",
					Status.IDEA,
					Type.VIDEO,
					LocalDateTime.now(),
					null,
					""
			);
			repository.save(content);
		};
	}

}
