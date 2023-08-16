package com.bdcourse.deliveryProject.kafka.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class BaseProducer
    (
    private var template: KafkaTemplate<String, String>
) : ProducerService {
    override fun sendMessage(message: String, topic: String) {
        template.send(topic, message)
    }
}