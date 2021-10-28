package com.demo.Service;

import java.util.List;

import com.demo.Model.MyNote;
import com.demo.exception.NoteAlreadyExistsException;

public interface INoteDao 
{
	public MyNote saveNote(MyNote myNote) throws NoteAlreadyExistsException;
	
	public List<MyNote> getAllNotes();
	
	boolean deleteItem(String id) throws NoteAlreadyExistsException;

}
