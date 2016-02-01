package com.service.util

import com.rabbitmq.client.AMQP
import com.rabbitmq.client.Channel
import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.Consumer
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope

class RabbitMQImplementaion {

	/**
	 * publishMessageToQueue()
	 * @return
	 */
	def publishMessageToQueue(){
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localHost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		try {
     		String message = "This is a test message!";
			channel.basicPublish("", "TestQueue", null, message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + message + "'");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			channel.close();
			connection.close();
		}
	}

	/**
	 * Read Message From Queue
	 * @author sannab
	 *
	 */
	def readMessageFromQueue(){

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		try{
			Consumer consumer = new DefaultConsumer(channel) {
						@Override
						public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
						throws IOException {
							String message = new String(body, "UTF-8");
							System.out.println(" [x] Received '" + message + "'");
						}
					};
		  channel.basicConsume("TestQueue", true, consumer);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			channel.close();
			connection.close();
		}
	}
}
