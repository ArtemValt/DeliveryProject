package com.bdcourse.deliveryProject.kafka.producer

interface ProducerService {
    fun sendMessage(message: String, topic: String)

}
