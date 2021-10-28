package com.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.Model.MyNote;

@Repository
public interface NoteRepository extends MongoRepository<MyNote, String>
{

}
