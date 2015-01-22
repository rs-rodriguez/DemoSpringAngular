package com.angular.spring.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.angular.spring.model.Registros;
import com.angular.spring.service.RegistroService;

/**
 * @Autor Samuel.Guardado
 * @FechaCreacion 20/01/2015
 */
@Controller
@RequestMapping("/")
public class MasterController {

	private final Logger logger = LoggerFactory
			.getLogger(MasterController.class);

	@Autowired
	private RegistroService registroService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/regitData", method = RequestMethod.GET , produces={"application/json"})
	public @ResponseBody List<Registros> getRegistrosList() {
		logger.info("Inside getlistRegistro()");
		
		return registroService.listRegistro();
	}

	@RequestMapping(value = "/regit/save", method = RequestMethod.POST)
	public View createRegistros(@ModelAttribute Registros registros,
			ModelMap model) {
		if (StringUtils.hasText(registros.getId())) {
			registroService.updateRegistro(registros);
		} else {
			registroService.addRegistro(registros);
		}
		return new RedirectView("/registros", true);
	}

	@RequestMapping(value = "/regit/delete", method = RequestMethod.GET)
	public View deleteRegistros(@ModelAttribute Registros registros,
			ModelMap model) {
		registroService.deleteRegistro(registros);
		return new RedirectView("/registros", true);
	}
}
