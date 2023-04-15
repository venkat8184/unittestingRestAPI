package mockingApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mockingApi.service.WelcomeService;

@RestController
public class WelcomeRestController {
	@Autowired
	private WelcomeService welcomeService;
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMsg(){
		String msg = welcomeService.getWelcomeMsg();
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	

}
