package com.FastTravel.FastTravelService.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.FastTravel.FastTravelService.model.Identifier;
import com.FastTravel.FastTravelService.model.Passage;
import com.FastTravel.FastTravelService.model.Scut;
import com.FastTravel.FastTravelService.model.Client;
import com.FastTravel.FastTravelService.model.CreditCard;
import com.FastTravel.FastTravelService.controller.*;
import com.FastTravel.FastTravelService.modelMessages.Message;

import org.json.simple.JSONObject;  
import org.json.simple.JSONValue;  
import java.sql.Date;
import java.sql.Time;

public class MQConsumer {
    @Autowired
    private PassageController passageController;

    @Autowired
    private IdentifierController identifierController;

    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    private ScutController scutController;

    @Autowired
    private ClientController clientController;

    @Autowired
    private CreditCardController creditCardController;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listen(String input) {
        Object obj=JSONValue.parse(input);  
        JSONObject jo = (JSONObject) obj; 
        
        String method = (String) jo.get("method");  

        if (method.equals("NEW_PASSAGE")) {
            System.out.println("OLAAAA ENTREI NO CONSUMER");
            Date date = Date.valueOf((String) jo.get("date")); 
            Time time = Time.valueOf((String) jo.get("time"));
            Long id_long = Long.parseLong(String.valueOf(jo.get("identifier")));
            Identifier identifier = identifierController.findIdentifierById(id_long);
            Long scut_long = Long.parseLong(String.valueOf(jo.get("scut")));
            Scut scut = scutController.findScutById(scut_long);
            Passage passage = new Passage(date, time, identifier, scut);
            passageController.addPassage(passage);

            Message message = new Message(method, String.valueOf(jo.get("identifier")), String.valueOf(jo.get("scut")), ((String) jo.get("date")), ((String) jo.get("time")));
            System.out.println("mensagem a enviar " + message);
            template.convertAndSend("/chat", message);

        }
    }

}