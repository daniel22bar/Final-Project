package stock.report_provider;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportProviderApplication {

	public static void main(String[] args) {
		Logger.getLogger("org").setLevel(Level.OFF);
		Logger.getLogger("akka").setLevel(Level.OFF);
		System.setProperty("hadoop.home.dir", "D:\\Program File D\\winutils");
		SpringApplication.run(ReportProviderApplication.class, args);
	}


}
