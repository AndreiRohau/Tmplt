package com.epam.tmpl.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.tmpl.Main;

@Controller

public class IndexControler {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		System.out.println("index page. tmpl");
		String str = new Main().get("tmpl");
		System.out.println(str);
		model.addAttribute("from_my_properties", str);
		model.put("from_my_properties", str);
		return "index";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		System.out.println("request arrived..");
		System.out.println("test page. tmpl");
		return "test";
	}

}
