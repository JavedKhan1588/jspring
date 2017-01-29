package com.espire.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.espire.model.ToDo;
import com.espire.service.ToDoService;

@Controller
@SessionAttributes("username")
public class ToDoController {
	
	@Autowired
	ToDoService todoService;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String listToDos(ModelMap model) {
		model.addAttribute("todos", todoService.retrieveToDos("javed"));
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showToDo(ModelMap model) {
		model.addAttribute("todo", new ToDo(0, "javed", "Default", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addToDo(ModelMap model, @Valid ToDo todo, BindingResult result) {
		if(result.hasErrors()){
			return "todo";
		}		
		todoService.addToDo("javed", todo.getDescription(), new Date(), false);
		model.clear();
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteToDo(ModelMap model, @RequestParam int id) {
		todoService.deleteToDo(id);
		model.clear();
		return "redirect:list-todos";
	}
}