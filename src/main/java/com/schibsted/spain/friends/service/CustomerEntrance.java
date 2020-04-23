package com.schibsted.spain.friends.service;

import com.schibsted.spain.friends.dto.RecordingDto;
import com.schibsted.spain.friends.model.Recording;
import com.schibsted.spain.friends.repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerEntrance {

    @Autowired
    private RecordingRepository recordingRepository;
    @Autowired
    private CosineSimilarity cosineSimilarity;

    public  void createCustomerEntrance(RecordingDto recordingDto){
        Recording recording = new Recording();
        recording.setImage(recordingDto.getImage());
        String listString = (String) recordingDto.getEmbedding_image().stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        recording.setEmbedding_image(listString);
        recording.setPosition(recordingDto.getPosition());

        List<Recording> recordings = getCustomerEntrance();
        boolean isSameEmbedding=false;
        if (!recordings.isEmpty()) {
            isSameEmbedding = isSameEmbeding(recordings, recordingDto);
        }

        if(!isSameEmbedding){
            recordingRepository.save(recording);
        }

        
    }

    public  boolean isSameEmbeding(List<Recording> recordings, RecordingDto recordingDto){
            for (Recording oldRecording: recordings){
                String[] lala =oldRecording.getEmbedding_image().split(",");
                double[] doubleArray = Arrays.stream(lala).mapToDouble(Double::parseDouble).toArray();
                double result = calculateDistance(recordingDto.getEmbedding_image(),doubleArray);
                if(result > 0.9999999999999988){
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>< IGUAL <<<<<<<<<<<<<<<< : " + oldRecording.getId());
                    return true;
                }
            }
            return false;
    }

    public double calculateDistance(List embedding, double[] oldEmbedding){
        double[][] arr = {embedding.stream().mapToDouble(d -> (double) d).toArray()};
        double result5 = cosineSimilarity.cosineSimilarity(arr[0], oldEmbedding);
        System.out.println("RESULT A-B: "+result5);
        return result5;
    }

    public  List<Recording>  getCustomerEntrance(){
        List<Recording> recordingList = recordingRepository.findAll();
        return recordingList;
    }

}
