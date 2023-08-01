package com.yt.backend.service;

import com.yt.backend.model.Reponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReponseService {

        public Reponse addReponse (Reponse reponse);
        public Reponse getReponseById(long idrep);
        public List<Reponse> getReponses();
        public void deleteReponse(long idrep);
        public Reponse updateReponse (Reponse reponse);
    }


