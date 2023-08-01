package com.yt.backend.repository;

import com.yt.backend.model.Question;
import com.yt.backend.model.Reponse;
import com.yt.backend.model.Role;
import com.yt.backend.model.User;
import jakarta.persistence.OneToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResponseRepository extends JpaRepository<Reponse,Long> {


}
