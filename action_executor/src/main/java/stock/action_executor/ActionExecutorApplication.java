package stock.action_executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import stock.action_executor.kafka.KafkaProducer;

@SpringBootApplication
public class ActionExecutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActionExecutorApplication.class, args);

    }

}
