package com.yt.backend.repository;

import com.yt.backend.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository  extends CrudRepository<Question,Long> {
}
