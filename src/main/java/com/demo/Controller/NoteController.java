package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.MyNote;
import com.demo.Service.INoteDao;
import com.demo.exception.NoteAlreadyExistsException;

@RestController
@RequestMapping("api/v1")
public class NoteController 
{
	@Autowired
	private INoteDao noteDao;
	
	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/addNote")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> saveNotes(@RequestBody MyNote myNote) throws NoteAlreadyExistsException
	{
		
		try
		{
			MyNote noteCreated = noteDao.saveNote(myNote);
			responseEntity = new ResponseEntity<>(noteCreated, HttpStatus.CREATED);
		}
		catch(NoteAlreadyExistsException e)
		{
			throw new NoteAlreadyExistsException();
			//e.printStackTrace();// will also print the exception
			//responseEntity = new ResponseEntity<>("Some Internal Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@GetMapping("/getNotes")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> getAllNotes()
	{
		try
		{
			responseEntity = new ResponseEntity<>(noteDao.getAllNotes(), HttpStatus.OK);
			
		}catch(Exception e)
		{
			responseEntity = new ResponseEntity<>("Cannot fetch notes due to internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@DeleteMapping(path = "/deleteGif/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> deleteItem(@PathVariable("id") final String id){
		try {
			noteDao.deleteItem(id);
			return new ResponseEntity<String>("Item Deleted Sucessfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("{\"message\":\"" + e.getMessage() + "\"}", HttpStatus.CONFLICT);
		}
	}
	
}











