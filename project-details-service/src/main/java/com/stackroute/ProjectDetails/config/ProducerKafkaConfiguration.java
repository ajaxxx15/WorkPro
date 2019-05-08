package com.stackroute.ProjectDetails.config;

//import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.stackroute.ProjectDetails.domain.BidKafka;
import com.stackroute.ProjectDetails.domain.ProjectsOfProjectOwner;
import org.apache.kafka.common.serialization.StringSerializer;
        import com.stackroute.ProjectDetails.listener.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerKafkaConfiguration {
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

//    @Bean
//    public Map<String, Object> producerConfigs(){
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//
//        return props;
//    }

    @Bean
//    public ProducerFactory<String, String> producerFactory() {

    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


//        return new DefaultKafkaProducerFactory<>(producerConfigs());
        return new DefaultKafkaProducerFactory<>(props);
    }


    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<String, Object>(producerFactory());

    }

    @Bean
    public Producer sender() {
        return new Producer();
    }
}




