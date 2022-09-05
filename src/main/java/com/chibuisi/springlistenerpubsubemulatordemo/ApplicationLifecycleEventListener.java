package com.chibuisi.springlistenerpubsubemulatordemo;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ApplicationLifecycleEventListener {
    private final Logger LOGGER = Logger.getLogger(ApplicationLifecycleEventListener.class.getSimpleName());

    @ServiceActivator(inputChannel = "inputMessageChannel")
    public void messageReceiver(String payload) {
        LOGGER.info("Message arrived! Payload: " + payload);
    }


    // Create an outbound channel adapter to send messages from the input message channel to the topic `topic-two`.
//    @Bean
//    @ServiceActivator(inputChannel = "outputMessageChannel")
//    public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
//        LOGGER.info("Message was received to be published!");
//        PubSubMessageHandler adapter = new PubSubMessageHandler(pubsubTemplate, "email");
//
//        adapter.setSuccessCallback(
//                ((ackId, message) ->
//                        LOGGER.info("Message was sent via the outbound channel adapter to email!")));
//
//        adapter.setFailureCallback(
//                (cause, message) -> LOGGER.info("Error sending " + message + " due to " + cause));
//
//        return adapter;
//    }
//
//    @MessagingGateway(defaultRequestChannel = "outputMessageChannel")
//    public interface PubSubOutboundGateway{
//        void sendToPubSub(String text);
//    }
}
