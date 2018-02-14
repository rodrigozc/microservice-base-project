package project.base.microservice.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/v1" )
public class MicroserviceController {
	
	@RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE, value = "/info",method = RequestMethod.GET)
    @ResponseBody
	public String info() {
		return "Microservice Base Project";
	}

}
