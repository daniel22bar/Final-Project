package stock.action_executor.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaProducer {
//    @Value("${topic_name}")
//    private String topic;
//
//    @Value("${bootstrap_server}")
//    private String bootstrapServer;

    private Properties props;
    private String topic;
    KafkaProducer( @Value("${topic_name}")
                    String topic,
                   @Value("${bootstrap_server}")
                    String bootstrapServer){
        this.topic = topic;
        props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    }

    public void pushActionToKafka(JsonNode str){

        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, str.toString());

        System.out.println(record.value());
        producer.send(record);
        producer.flush();
        producer.close();

    }
}
