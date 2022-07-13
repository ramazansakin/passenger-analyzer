package com.rsakin.passengeranalyzer.consumer;

import com.rsakin.passengeranalyzer.dto.PassengerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PassengerConsumer {

    private static final String TEST_TOPIC = "test-topic";
    private static final String TEST_TOPIC_PASSENGER = "passenger-topic";

    private static final String TEST_GROUP = "test-first-group";
    private static final String TEST_GROUP_NEW = "test-second-group";

    private static final String SIMPLE_CONTAINER_FACTORY = "testKafkaListenerContainerFactory";
    private static final String CUSTOM_CONTAINER_FACTORY = "passengerKafkaListenerContainerFactory";


    @KafkaListener(topics = TEST_TOPIC, groupId = TEST_GROUP, containerFactory = SIMPLE_CONTAINER_FACTORY)
    public void messageListener1(String message) {
        log.info("Message: '" + message + "' from listener1");
    }

    @KafkaListener(topics = TEST_TOPIC, groupId = TEST_GROUP, containerFactory = SIMPLE_CONTAINER_FACTORY)
    public void messageListener2(String message) {
        log.info("Message: '" + message + "' from listener2");
    }

    @KafkaListener(topics = TEST_TOPIC, groupId = TEST_GROUP_NEW, containerFactory = SIMPLE_CONTAINER_FACTORY)
    public void messageListener3(String message) {
        log.info("Message: '" + message + "' from listener3");
    }

    @KafkaListener(topics = TEST_TOPIC_PASSENGER, groupId = TEST_GROUP, containerFactory = CUSTOM_CONTAINER_FACTORY)
    public void passengerListener(PassengerDTO passenger, Acknowledgment acknowledgment) {
        log.info("Message: '" + passenger + "' from customListener");
        acknowledgment.acknowledge();
    }

}