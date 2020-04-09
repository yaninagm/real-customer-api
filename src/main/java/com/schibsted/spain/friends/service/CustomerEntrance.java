package com.schibsted.spain.friends.service;

import com.schibsted.spain.friends.model.Recording;
import com.schibsted.spain.friends.repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerEntrance {

    @Autowired
    private RecordingRepository recordingRepository;

    public  void customerEntrance(Recording recording1){
        System.out.println("[method:customerEntrance][userName: "+ recording1.getEmbedding_image() + "]");
        recordingRepository.save(recording1);
        calculateDistance(recording1.getEmbedding_image());
        
    }

    public void calculateDistance(String Token){

    }

}
