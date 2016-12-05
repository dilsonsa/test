package org.fiveware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by valdisnei on 12/5/16.
 */
@Controller
public class Home {

	@RequestMapping(value = "/")
	public String home(){
		return "index.html";
	}
}
