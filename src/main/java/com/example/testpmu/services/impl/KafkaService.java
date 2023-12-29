package com.example.testpmu.services.impl;

import com.example.testpmu.models.CourseEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaService {

    @KafkaListener(topics = "my-topic")
    public void listen(ConsumerRecord<String, CourseEvent> record) {
        // Traitez le message reçu
        String key = record.key();
        CourseEvent value = record.value();
    }
}
