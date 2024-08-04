package br.com.alurafood.pagamentos.amqp;



import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import java.sql.Connection;

@Configuration
public class PagamentoAmqpConfiguration {

    private final String NOME_FILA_PAGAMENTO = "pagamento.concluido";

    @Bean
    public Queue getQueue(){

        return  QueueBuilder.nonDurable(NOME_FILA_PAGAMENTO).build();
    }

    @Bean
    public RabbitAdmin getRabbitAdmin(ConnectionFactory conn){

        return new RabbitAdmin(conn);

    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initAdmin(RabbitAdmin rabbitAdmin){

        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory con, Jackson2JsonMessageConverter converter){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(con);

        rabbitTemplate.setMessageConverter(converter);

        return rabbitTemplate;
    }
}
