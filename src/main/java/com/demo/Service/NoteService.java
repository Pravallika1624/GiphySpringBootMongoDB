package com.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Model.MyNote;
import com.demo.Repository.NoteRepository;
import com.demo.exception.NoteAlreadyExistsException;

@Service
public class NoteService implements INoteDao
{

	@Autowired
	private NoteRepository noteRepo;

	@Override
	public List<MyNote> getAllNotes() {
		
		List allNotes = this.noteRepo.findAll();
		return allNotes;
	}

	@Override
	public MyNote saveNote(MyNote myNote) throws NoteAlreadyExistsException 
	{
		Optional<MyNote> optional = this.noteRepo.findById(myNote.getId());
		if(optional.isPresent())
		{
			throw new NoteAlreadyExistsException();
		}
		MyNote addNote = this.noteRepo.save(myNote);
		
		return addNote;
	}

	@Override
	public boolean deleteItem(String id) throws NoteAlreadyExistsException {
		final MyNote gifItem= noteRepo.findById(id).orElse(null);
		if(gifItem == null) {
		throw new NoteAlreadyExistsException();
		}
		noteRepo.delete(gifItem);
		return true;
		
	}
	

}

















