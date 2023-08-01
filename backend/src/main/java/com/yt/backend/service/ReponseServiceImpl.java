package com.yt.backend.service;

import com.yt.backend.model.Reponse;
import com.yt.backend.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReponseServiceImpl implements ReponseService {



    @Autowired
        private ResponseRepository reponseRepository;

        @Override
        public Reponse addReponse(Reponse reponse) {
            return reponseRepository.save(reponse);
        }

        @Override
        public Reponse getReponseById(long idrep) {
            return reponseRepository.findById(idrep).get() ;
        }

        @Override
        public List<Reponse> getReponses()  {
            return (List<Reponse>) reponseRepository.findAll();
        }

        @Override
        public void deleteReponse(long idrep){reponseRepository.deleteById(idrep);
        }

        @Override
        public Reponse updateReponse(Reponse reponse) {
            return reponseRepository.save(reponse);
        }




    }

