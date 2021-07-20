package stock.action_executor.services

import com.fasterxml.jackson.databind.ObjectMapper
import org.json4s.jackson.Json
import org.springframework.stereotype.Component
import stock.action_executor.kafka.KafkaProducer

import scala.util.parsing.json._


@Component
class StockActionService(kafkaProducer: KafkaProducer,objectMapper: ObjectMapper) {
    def buy(json:String) = kafkaProducer.pushActionToKafka(objectMapper.readTree(json))
    def sell(json:String) = kafkaProducer.pushActionToKafka(objectMapper.readTree(json))
    def buyBulk(json:String) = kafkaProducer.pushActionToKafka(objectMapper.readTree(json))
    def sellBulk(json:String) = kafkaProducer.pushActionToKafka(objectMapper.readTree(json))
}
