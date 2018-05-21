package com.lvhong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	@RequestMapping("/{param}")
	public String redirtToCatalog(@PathVariable String param) {
		return "/views/pages/"+ param;
	}
}
