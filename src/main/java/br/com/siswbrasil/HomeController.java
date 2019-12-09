package br.com.siswbrasil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HomeController {
	
	public String index() {
		return "Olá mundo";
	}

}
