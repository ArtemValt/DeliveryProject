package com.bdcourse.deliveryProject.kafka.config;

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
open class KafkaConfig {

    @Bean
    open fun producerFactory(props: KafkaProperties): ProducerFactory<String, String> {
        return DefaultKafkaProducerFactory(props.buildProducerProperties())
    }

    @Bean
    open fun kafkaTemplate(factory: ProducerFactory<String, String>): KafkaTemplate<String, String> {
        return KafkaTemplate(factory)
    }
    @Bean
    open fun topic(): NewTopic = TopicBuilder.name("topic1")
        .partitions(10)
        .replicas(1)
        .build();

}
