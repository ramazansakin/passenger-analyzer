package com.rsakin.passengeranalyzer.data.faker;

import com.github.javafaker.Faker;
import com.rsakin.passengeranalyzer.dto.PassengerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@Component
// @Profile("test")
public class FakePassengerProducer {

    private static Faker faker = new Faker();
    private static final long FAKE_PASSENGER_PRODUCE_MILLIS = 1000 * 30; // 30 secs

    @Scheduled(fixedRate = FAKE_PASSENGER_PRODUCE_MILLIS)
    public void produceFakePassengers() {
        // Create some dummy test passenger to log into fluentd
        IntStream.rangeClosed(1, new Random().nextInt(10))
                .mapToObj(i -> new PassengerDTO(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        (i % 2 == 0 ? "Male" : "Female"),
                        faker.number().numberBetween(10, 90),
                        faker.phoneNumber().phoneNumber(),
                        faker.internet().emailAddress()
                )).forEach(passengerDTO -> log.info("New passenger added : " + passengerDTO));

    }

}
