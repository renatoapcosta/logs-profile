package br.com.ractecnologia.logsprofile;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
@SpringBootApplication
public class LogsProfileApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostConstruct
    public void init(){
		LocaleContextHolder.setDefaultLocale(new Locale("pt","BR"));
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));   // It will set UTC timezone Europe/Paris
    }

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(LogsProfileApplication.class);
		app.setBanner(new MyBanner());
		// app.setAdditionalProfiles("hml");
		app.run(args);
		//SpringApplication.run(SpringApplication.class, args);
	}

	@Autowired
	private ConfigurableEnvironment env;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private IndependenteProfileService independenteProfileService;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MessageLocaleService messageLocaleService;

	@Value("${custom.var}")
	private String propertyCustom;

	@Override
	public void run(String... args) throws Exception {
		logger.info("-----------------------");
		logger.info(independenteProfileService.getService());

		logger.info(LocaleContextHolder.getLocale().toString());
		logger.info("{}", messageSource.getMessage("first.welcome", null, LocaleContextHolder.getLocale() ));
		logger.info(messageLocaleService.getMessage("first.welcome"));
		
		
		logger.info(new Date().toString() );
		
//		ZoneId fusoHorarioDeSaoPaulo = ZoneId.of("America/Sao_Paulo");
//		logger.info(Instant.now().atZone(fusoHorarioDeSaoPaulo).toString() );

		LocalDateTime agora = LocalDateTime.now();
		logger.info(agora.toString());
		
		for (String prof : env.getActiveProfiles()) {
			logger.info("profile: {}", prof);
		}

		logger.info(profileService.profileAtivo());

		logger.info(propertyCustom);

		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");

		logger.info("-----------------------");

	}


}
