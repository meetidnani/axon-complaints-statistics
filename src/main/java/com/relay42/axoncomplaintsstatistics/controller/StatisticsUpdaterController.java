package com.relay42.axoncomplaintsstatistics.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.axonframework.amqp.eventhandling.DefaultAMQPMessageConverter;
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.serialization.Serializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.Channel;
import com.relay42.axoncomplaints.domain.ComplaintFiledEvent;

/**
 * The Class ComplaintUpdaterController.
 */
/**
 * @author meetidnani
 *
 */
@ProcessingGroup("statistics")
@RestController
public class StatisticsUpdaterController {
	
	
	/** The Constant statistics. */
	public static final ConcurrentMap<String, AtomicLong> statistics = new ConcurrentHashMap<>();
	
	/**
	 * Handle.
	 *
	 * @param event the event
	 */
	@EventHandler
	public void handle(ComplaintFiledEvent event) {
		statistics.computeIfAbsent(event.getCompany(), k -> new AtomicLong()).incrementAndGet();
		statistics.computeIfAbsent(event.getDescription(), k -> new AtomicLong()).incrementAndGet();
	}
	
	/**
	 * Gets the statistics.
	 *
	 * @return the statistics
	 */
	@GetMapping(value = "/api/statistics/v1/getStatistics")
	public ConcurrentMap<String, AtomicLong> getStatistics() {
		return statistics;
	}
	
	@Bean
	public SpringAMQPMessageSource statisticsSource(Serializer serializer) {
		return new SpringAMQPMessageSource(new DefaultAMQPMessageConverter(serializer)) {
			@RabbitListener(queues = "ComplaintEvents")
			@Override
			public void onMessage(Message message, Channel channel) {
				super.onMessage(message, channel);
			}
		};
	}


	
	

}
