package com.cg.provisionService.message;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.cg.provisionService.domain.Cert;
import com.cg.provisionService.domain.Provision;
import com.cg.provisionService.service.ProvisionService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.opentracing.Span;
import io.opentracing.Tracer;



@Component
@EnableBinding(Sink.class)
public class MessageListener {
	
	@Autowired
	  private MessageSender messageSender;
	
	@Autowired
	private ProvisionService svc;
	
	@Autowired
       private Tracer tracer;
	
	@StreamListener(target = Sink.INPUT, 
			condition="headers['message']=='outofdate'")
		  @Transactional
		  public void retrievePaymentCommand(String messageJson) throws JsonParseException, JsonMappingException, IOException {
		
		 Message<Cert> message = new ObjectMapper().readValue(messageJson, new TypeReference<Message<Cert>>(){});
		 Provision pro=svc.findCodigo(message.getPayload());
		 if(pro!=null)
		 {
			 message.getPayload().setStatus("Tramitada");
			 Cert cert = message.getPayload();
			 Message<Cert> message1 = new Message<Cert>("CertTramitadaEvent", cert);
			 message1.setLabel("checkContract-Ok-6");
			 Span span = tracer.buildSpan("Sending Tramitada Event from microservice 2 to microservice 3").start();
			  span.finish();
				messageSender.sendTramitada(message1);
		 }
		 else
		 {
			 message.getPayload().setStatus("Denegada");
			 Cert cert = message.getPayload();
			 Message<Cert> message1 = new Message<Cert>("ProvisionesDenegadaEvent", cert);
			 message1.setLabel("checkContract-Denegada-6");
			  Span span = tracer.buildSpan("Sending ProvisionesDenegada Event from microservice 2 to microservice 1").start();
			  span.finish();
				messageSender.sendProvisionDenegada(message1);
		 }
	
	}

}
