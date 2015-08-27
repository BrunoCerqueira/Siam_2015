package messageDriven;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Operacao;
import enumerator.EnumEmpresa;
import enumerator.EnumTipoOperacao;

@Stateless
public class ProdutorAcao  {
	public ProdutorAcao() {
		
			
		}
	List<Operacao> operacoesGeradas = new ArrayList<Operacao>();
	public Operacao gerarOferta(String descricao){
		
		
			Operacao op = new Operacao();
			op.setDescricao(descricao);
			op.setQuantidadeLotes(1L);
			
			op.setTipoOperacao(EnumTipoOperacao.values()[new Random().nextInt(2)]);
			op.setValorLote(new BigDecimal(new Random().nextInt(30)));
			return op;
			
		
		
	}
	public List<Operacao> gerarOfertasAleatorias(){
		Integer quantidade = new Random().nextInt(10);
		List<Operacao> operacoesGeradas = new ArrayList<Operacao>();
		for(int x =0;x< 20;x++){
			Operacao op = new Operacao();
			op.setDescricao(EnumEmpresa.values()[new Random().nextInt(3)].getDescricao());
			op.setQuantidadeLotes((long) new Random().nextInt(5));
			op.setTipoOperacao(EnumTipoOperacao.values()[new Random().nextInt(2)]);
			op.setValorLote(new BigDecimal(new Random().nextInt(130)));
			operacoesGeradas.add(op);
			
		}
		return operacoesGeradas;
	}
//	@Resource(lookup = "jms/homeBroker")
//	private Destination destination;

	
	public List<Operacao> adicionarOferta(Operacao operacaoSolicitada) {
		try {
			
			operacoesGeradas = gerarOfertasAleatorias();
			for(Operacao op : operacoesGeradas){
				InitialContext ic = new InitialContext () ;
				
				QueueConnectionFactory connectionFactory = ( QueueConnectionFactory ) ic . lookup ("ConnectionFactory") ;
				Queue queue = (Queue)ic.lookup("queue/test");
			
				QueueConnection connection = connectionFactory.createQueueConnection();
				QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
				Operacao operacao = new Operacao();
				operacao = gerarOferta(operacaoSolicitada.getDescricao());
 				if(op.getDescricao().equals(operacaoSolicitada.getDescricao())){
					ObjectMessage obj =  session.createObjectMessage(operacao);
					if(operacaoSolicitada.getDescricao().equals("Microsoft")){
						obj.setBooleanProperty("Microsoft", Boolean.TRUE);
					}
					if(operacaoSolicitada.getDescricao().equals("Google")){
						obj.setBooleanProperty("Google", Boolean.TRUE);
					}
					if(operacaoSolicitada.getDescricao().equals("Apple")){
						obj.setBooleanProperty("Apple", Boolean.TRUE);
					}
				
//					TextMessage msg = session.createTextMessage("Hello World");
//					QueueSender sender = session.createSender(queue);
//					sender.send(msg);  
//					connection.close();
					MessageProducer producer = session.createProducer(queue);
					producer.setDeliveryMode(DeliveryMode.PERSISTENT);
					// set an asynchronous message listener
				
				       
//					ObjectMessage mensagem = session.createObjectMessage();
//					mensagem.setStringProperty("Tipo", EnumTipoOperacao.OFERTA_VENDA.getId().toString());
//					mensagem.setStringProperty("Quantidade", "5");
//					mensagem.setStringProperty("Valor", "100");
//					mensagem.setStringProperty("Descricao", "Google");
				
		//			mensagem.setObject(operacao);
					producer.send(obj);
		//			producer.send(mensagem);
					connection.start();
					session.close();
					
					
					connection.close();
					
				}
			}
			
		
		
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operacoesGeradas;
	}

}
