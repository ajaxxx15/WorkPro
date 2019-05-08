package com.stackroute.freelancerprofile.config;

import com.stackroute.freelancerprofile.domain.Bid;
import com.stackroute.freelancerprofile.domain.Freelancer;
import com.stackroute.freelancerprofile.listener.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
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


//    configuration properties
    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> config = new HashMap<>();
        config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return config;
    }


//    bid details to be sent
    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }


    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<String, Object>(producerFactory());
    }


//    freelancer details to be sent
//
//    @Bean
//    public ProducerFactory<String, Freelancer> freelancerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//
//    @Bean
//    public KafkaTemplate<String, Freelancer> freelancerTemplate() {
//        return new KafkaTemplate<String, Freelancer>(freelancerFactory());
//    }






    @Bean
    public Producer sender() {
        return new Producer();
    }
}
