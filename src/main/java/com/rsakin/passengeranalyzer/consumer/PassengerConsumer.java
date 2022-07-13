package com.rsakin.passengeranalyzer.consumer;

import com.rsakin.passengeranalyzer.dto.PassengerDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class PassengerConsumer {

    private static final String TEST_TOPIC = "test-topic";
    private static final String TEST_TOPIC_CUSTOM = "passenger-topic";

    private static final String TEST_GROUP = "passenger-first-group";
    private static final String TEST_GROUP_NEW = "passenger-second-group";

    private static final String SIMPLE_CONTAINER_FACTORY = "simpleKafkaListenerContainerFactory";
    private static final String CUSTOM_CONTAINER_FACTORY = "customKafkaListenerContainerFactory";


    @KafkaListener(topics = TEST_TOPIC, groupId = TEST_GROUP, containerFactory = SIMPLE_CONTAINER_FACTORY)
    public void listener1(String message) {
        System.out.println("Message: '" + message + "' from listener1");
    }

    @KafkaListener(topics = TEST_TOPIC, groupId = TEST_GROUP, containerFactory = SIMPLE_CONTAINER_FACTORY)
    public void listener2(String message) {
        System.out.println("Message: '" + message + "' from listener2");
    }

    @KafkaListener(topics = TEST_TOPIC, groupId = TEST_GROUP_NEW, containerFactory = SIMPLE_CONTAINER_FACTORY)
    public void listener3(String message) {
        System.out.println("Message: '" + message + "' from listener3");
    }

    @KafkaListener(topics = TEST_TOPIC_CUSTOM, groupId = TEST_GROUP, containerFactory = CUSTOM_CONTAINER_FACTORY)
    public void customPassengerListener(PassengerDTO passenger, Acknowledgment acknowledgment) {
        System.out.println("Message: '" + passenger + "' from customListener");
        acknowledgment.acknowledge();
    }

}
