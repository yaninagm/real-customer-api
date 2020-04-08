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
        System.out.println("[method:customerEntrance][userName: "+ recording1 + "]");
        Recording recording = new Recording();
        recording.setToken(recording1.getToken());
        recordingRepository.save(recording);
        
    }

}
