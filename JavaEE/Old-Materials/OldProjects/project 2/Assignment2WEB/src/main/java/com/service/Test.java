//package com.service;
//
//import javax.ejb.ActivationConfigProperty;
//import javax.ejb.MessageDriven;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.TextMessage;
//
///**
// * Message-Driven Bean implementation class for: Test
// */
//@MessageDriven(
//		activationConfig = { @ActivationConfigProperty(
//				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
//					      propertyName = "destination", 
//					      propertyValue = "tutorialQueue")
//		})
//public class Test implements MessageListener {
//
//   
//    public void onMessage(Message message) {
//        TextMessage textMessage = (TextMessage) message;
//        try {
//            System.out.println("Message received: " + textMessage.getText());
//        } catch (JMSException e) {
//            System.out.println(
//              "Error while trying to consume messages: " + e.getMessage());
//        }
//    }
//        
//    }
//
//
