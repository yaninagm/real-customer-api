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
    private CounterEntrance counterEntrance;


    public UserDto saveNewCustomerEntrance(RecordingDto recordingDto){
        User user = getRelatedUser(recordingDto);
        if (Objects.isNull(user)){
            String embeddingImageLikeString = (String) recordingDto.getEmbedding_image().stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
            User newUser = new User("", recordingDto.getImage(), embeddingImageLikeString);
            newUser = userRepository.save(newUser);
            createRecording(newUser, recordingDto);
            UserDto userDto = new UserDto(newUser.getId(), recordingDto.getImage());
            return userDto;
        }
        createRecording(user,recordingDto);
        UserDto userDto = new UserDto(user.getId(), user.getUserName(), user.getUserName(), user.getUserName(), user.getImage());
        return userDto;
        
    }

    public User getRelatedUser(RecordingDto recordingDto){
        List<User> users = userRepository.findAll();
        User sameUser = null;
        if (!users.isEmpty()) {
            return sameEmbeding(users, recordingDto);
        }
        return sameUser;
    }

    public  User sameEmbeding(List<User> users, RecordingDto recordingDto){
            for (User user: users){
                String[] originalRecordingList =user.getEmbeddingImage().split(",");
                double[] doubleArray = Arrays.stream(originalRecordingList).mapToDouble(Double::parseDouble).toArray();
                double result = calculateSimilitud(recordingDto.getEmbedding_image(),doubleArray);
                if(result > 0.90){
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>< IGUAL <<<<<<<<<<<<<<<< : " + user.getId() + "cosineSimilarity: "+result);
                    return user;
                }
            }
            return null;
    }

    public double calculateSimilitud(List embedding, double[] oldEmbedding){
        double[][] arr = {embedding.stream().mapToDouble(d -> (double) d).toArray()};
        double result5 = cosineSimilarity.cosineSimilarity(arr[0], oldEmbedding);
        System.out.println("RESULT A-B: "+result5);
        return result5;
    }

    public  List<Recording>  getCustomerEntrance(){
        List<Recording> recordingList = recordingRepository.findAll();
        return recordingList;
    }

    public Recording createRecording(User newUser, RecordingDto recordingDto){
        Recording recording = new Recording();
        recording.setImage(recordingDto.getImage());
        recording.setEmbeddingImage(newUser.getEmbeddingImage());
        recording.setPosition(recordingDto.getPosition());
        recording.setUserId(newUser.getId());
        recordingRepository.save(recording);
        return recording;
    }

}
