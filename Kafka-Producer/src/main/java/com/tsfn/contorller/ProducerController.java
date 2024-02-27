package com.tsfn.contorller;




import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.service.ProducerServices;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class ProducerController {
	
	@Autowired
	private  ProducerServices producerServices;
   
	@GetMapping(value = "/send")
    public void send(){
    	producerServices.send("Hello Every Body !!");
    }
}	
