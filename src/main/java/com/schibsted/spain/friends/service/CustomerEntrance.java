package com.schibsted.spain.friends.service;

import com.schibsted.spain.friends.model.Recording;
import com.schibsted.spain.friends.repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerEntrance {

    @Autowired
    private RecordingRepository recordingRepository;

    public  void createCustomerEntrance(Recording recording1){
        System.out.println("[method:customerEntrance][userName: "+ recording1.getEmbedding_image() + "]");
        recordingRepository.save(recording1);
        calculateDistance(recording1.getEmbedding_image());
        
    }

    public void calculateDistance(String Token){

    }

    public  List<Recording>  getCustomerEntrance(){
        System.out.println("[method:getCustomerEntrance][userName:");
        List<Recording> recordingList = recordingRepository.findAll();
        System.out.println(">>>>>>> "+ recordingList);
        return recordingList;
    }

}
