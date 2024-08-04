package br.com.alurafood.pedidos.amqp;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentosListener {

    private final String NOME_FILA_PAGAMENTO = "pagamento.concluido";

    @RabbitListener(queues = NOME_FILA_PAGAMENTO)
    public void recieveMessage(Message message){

        System.out.println(String.format("Message recieved: %s", message.toString()));
    }
}
