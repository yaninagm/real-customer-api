package com.schibsted.spain.friends.service;

import com.schibsted.spain.friends.dto.RecordingDto;
import com.schibsted.spain.friends.dto.UserDto;
import com.schibsted.spain.friends.model.Recording;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.RecordingRepository;
import com.schibsted.spain.friends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerEntrance {

    @Autowired
    private RecordingRepository recordingRepository;
    @Autowired
    private CosineSimilarity cosineSimilarity;
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private CountingEntrance countingEntrance;

    public UserDto createCustomerEntrance(RecordingDto recordingDto){
        Recording recording = new Recording();
        recording.setImage(recordingDto.getImage());
        String listString = (String) recordingDto.getEmbedding_image().stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        recording.setEmbedding_image(listString);
        recording.setPosition(recordingDto.getPosition());

        List<Recording> oldrecordings = getCustomerEntrance();
        Recording sameEmbedding = null;
        boolean isSameEmbedding=false;

        if (!oldrecordings.isEmpty()) {
            sameEmbedding = sameEmbeding(oldrecordings, recordingDto);
        }else{

        }

        if(Objects.isNull(sameEmbedding)){
            User newUser = new User("", recordingDto.getImage());
            newUser = userRepository.save(newUser);
            recording.setUserId(newUser.getId());
            recordingRepository.save(recording);
            UserDto userDto = new UserDto(newUser.getId(), recordingDto.getImage());
            return userDto;
        }
        User user = userRepository.getOne(sameEmbedding.getUserId());
        if (Objects.isNull(user)){
            user = new User("", recordingDto.getImage());
        }
        UserDto userDto = new UserDto(user.getId(), user.getUserName(), user.getUserName(), user.getUserName(), user.getImage());
        userDto.setEntranceByDay(countingEntrance.dailyEntranceCount(user));
        userDto.setEntranceByMonth(countingEntrance.monthlyEntranceCount(user));
        userDto.setHistoryEntrance(countingEntrance.historyEntranceCount(user));
        return userDto;
        
    }

    public  Recording sameEmbeding(List<Recording> recordings, RecordingDto recordingDto){
            for (Recording originalRecording: recordings){
                String[] lala =originalRecording.getEmbedding_image().split(",");
                double[] doubleArray = Arrays.stream(lala).mapToDouble(Double::parseDouble).toArray();
                double result = calculateDistance(recordingDto.getEmbedding_image(),doubleArray);
                if(result > 0.9999999999999988){
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>< IGUAL <<<<<<<<<<<<<<<< : " + originalRecording.getId());
                    return originalRecording;
                }
            }
            return null;
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
