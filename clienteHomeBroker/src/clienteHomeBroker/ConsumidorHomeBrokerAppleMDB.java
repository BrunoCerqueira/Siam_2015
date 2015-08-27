package clienteHomeBroker;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import messageDriven.ProdutorAcao;
import model.Operacao;
import facade.OfertaOperacaoService;

@MessageDriven(name="clienteHomeBroker.ConsumidorHomeBrokerAppleMDB",activationConfig=
{
		 @ActivationConfigProperty(propertyName = "acknowledgeMode",
                 propertyValue = "Auto-acknowledge"),
		  @ActivationConfigProperty(propertyName="messagingType", propertyValue="javax.jms.MessageListener"),
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Topic"),
	    @ActivationConfigProperty(propertyName="destination", propertyValue="queue/test"),
	    @ActivationConfigProperty(propertyName="messageSelector",propertyValue="Apple = TRUE")
	    

}
		)
public class ConsumidorHomeBrokerAppleMDB implements MessageListener{
	Operacao operacao = new Operacao();
	
	@EJB
	private OfertaOperacaoService ofertaOperacaoService;
	
	@PostConstruct
	public void onPostConstruct(){
		
	}
	@Resource
	private MessageDrivenContext context;
	
	
	@Override
	public void onMessage(Message mensagem) {
		
	

	
			
			
			try {
				InitialContext ic;
				ic = new InitialContext ();
				QueueConnectionFactory connectionFactory = ( QueueConnectionFactory ) ic .lookup ("ConnectionFactory") ;
				Queue queue;
				queue = (Queue)ic.lookup("queue/test");
				
				QueueConnection connection = connectionFactory.createQueueConnection();
				QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
				QueueReceiver queueReceiver = session.createReceiver(queue);
				
				ConsumidorHomeBrokerAppleMDB asyncReceiver = new ConsumidorHomeBrokerAppleMDB();
				queueReceiver.setMessageListener(asyncReceiver);
				ObjectMessage objectMessage         =   (ObjectMessage) mensagem;
				operacao = (Operacao) objectMessage.getObject();
				ofertaOperacaoService.salvarOperacao(operacao);
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
				                                                                          
			
//			 textMessage.getStringProperty("Tipo");
//			 textMessage.getStringProperty("Quantidade");
//			 textMessage.getStringProperty("Valor");
//			 textMessage.getStringProperty("Descricao");
//			 operacao.setDescricao(textMessage.getStringProperty("Descricao"));
//			 operacao.setQuantidadeLotes(Long.parseLong(textMessage.getStringProperty("Quantidade")));
//			 operacao.setValorLote(	 BigDecimal.valueOf(Long.parseLong(textMessage.getStringProperty("Valor"))));
			
			
		
	
		
	}
	
	
}
