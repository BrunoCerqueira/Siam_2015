/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.topic;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

import example.util.Util;

/**
 * @author <a href="http://www.christianposta.com/blog">Christian Posta</a>
 */
public class Subscriber implements MessageListener {

    private static final String BROKER_HOST = "tcp://localhost:%d";
    private static final int BROKER_PORT = Util.getBrokerPort();
    private static final String BROKER_URL = String.format(BROKER_HOST, BROKER_PORT);
    private static final Boolean NON_TRANSACTED = false;
    SwingBasic swingBasic = new SwingBasic();
    static Session session;
    private final CountDownLatch countDownLatch;
    private static Boolean isAssinatura = Boolean.TRUE;
    public Subscriber(CountDownLatch latch) {
        countDownLatch = latch;
    }
    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/
        System.out.println("-------------------------");
        System.out.println("Assinar:");
        System.out.println("-------------------------\n");
        System.out.println("1 - Microsoft");
        System.out.println("2 - google");
        System.out.println("3 - Apple");
        
        System.out.println("\n-------------------------");
        System.out.println("Encerrar assinatura:");
        System.out.println("-------------------------\n");
        
        System.out.println("-1 - Microsoft");
        System.out.println("-2 - google");
        System.out.println("-3 - Apple");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        return selection;    
    }
    static String topicoEscolhido;

    public static void main(String[] args) {
       Integer escolha = menu();
       switch (escolha) {
	case 1:
		topicoEscolhido = "Microsoft";
		break;
	case 2:
		topicoEscolhido = "Google";
		break;
	case 3:
		topicoEscolhido = "Apple";
		break;
	case -1:
		isAssinatura = Boolean.FALSE;
		topicoEscolhido = "Microsoft";
       
		
		break;
	case -2:
		isAssinatura = Boolean.FALSE;
		topicoEscolhido = "Google";
		
		break;
	case -3:
		isAssinatura = Boolean.FALSE;
		topicoEscolhido = "Apple";
		
		break;

	default:
		
		break;
	}
     
       
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "password", BROKER_URL);
        
      
        Connection connection = null;
        final CountDownLatch latch = new CountDownLatch(1);

        try {
        	
        	//cria uma conexão do tipo Topic
            connection = connectionFactory.createTopicConnection();
         
            //informa o id do cliente duravel
            connection.setClientID("duravel");
            
            connection.start();

             session = connection.createSession(NON_TRANSACTED, Session.AUTO_ACKNOWLEDGE);
             Topic destination;
             TopicSubscriber top = null;
             if(isAssinatura){
           
	    		 destination = session.createTopic(topicoEscolhido);
	    		
	    		//cria o assinante para o topico
				 top = session.createDurableSubscriber((Topic) destination, topicoEscolhido);      
				
				//adiciona no assinante o listiner para as mensagens produzidas
	           top.setMessageListener(new Subscriber(latch));
             }else{
            	 finalizarAssinatura(topicoEscolhido);
             }
//           top.receive();
            latch.await();
            session.commit();
            top.close();
            session.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                   e.printStackTrace();
                }
            }
        }
    }
    public static void finalizarAssinatura(String topico){
    	try {
			session.unsubscribe(topicoEscolhido);
			 System.out.println("Finalizada a assinatura das ações do(a) "+topicoEscolhido);
		} catch (JMSException e) {
		
			e.printStackTrace();
		}
    }

    /**
     * listiner , responsável por recuperar mensagens geradas
     */
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String text = ((TextMessage) message).getText();
                if ("END".equalsIgnoreCase(text)) {
                    System.out.println("Received END message!");
                    countDownLatch.countDown();
                }
                else {
                    System.out.println("Received message:" + text);
                }
            }
            else{
            Operacao operacao = 	(Operacao) ((ObjectMessage)message).getObject();
            swingBasic.start(operacao);
            }
        } catch (JMSException e) {
            System.out.println("Got a JMS Exception!");
        }
    }
}
