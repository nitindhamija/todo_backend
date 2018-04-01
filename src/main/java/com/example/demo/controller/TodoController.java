package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.Todo;
import com.example.demo.service.ITodoService;
@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TodoController {
	
	@Autowired
	private ITodoService todoService;
 /*@RequestMapping("/todos")
 public String greet() {
  return "Hello from the other side!!!";
 }*/
	@GetMapping("/todos")
 public ResponseEntity<List<Todo>> getTodoList() {
 	List<Todo> list = todoService.getTodoList();
 	return new ResponseEntity<List<Todo>>(list, HttpStatus.OK);
 }
	
	@PostMapping("/todos")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		 todo = todoService.createTodo(todo);
		if (todo == null) {
		     return new ResponseEntity<Todo>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(builder.path("/todo?id={id}").buildAndExpand(todo.getId()).toUri());
		return new ResponseEntity<Todo>(todo,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/todos")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
		todoService.updateTodo(todo.getId(),todo.isCompleted());
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	
	@PutMapping("/todosall")
	public ResponseEntity<Void> updateTodoAll(@RequestParam("checkAll") Boolean checkAll) {
		todoService.updateTodoAll(checkAll);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/todos")
	public ResponseEntity<Void> deleteTodo(@RequestParam("id") int id) {
		todoService.deleteTodo(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
 
}