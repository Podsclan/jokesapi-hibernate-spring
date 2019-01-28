package br.com.brendowpodsclan.jokapihib.model;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.internals.Topic;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KProducer {

    public Properties setProperties() {
        String bootstrapServer = "127.0.0.1:9092";

        //create producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return properties;
    }

    public KafkaProducer createProducer(){
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(this.setProperties());
        return producer;
    }

    public void produceMessage(KafkaProducer producer, String message){
        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("jokeapitest", message);
        producer.send(record);
        producer.flush();
        producer.close();
    }

}
