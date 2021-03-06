package com.api.realCustomer.service;

import com.api.realCustomer.dto.RecordingDto;
import com.api.realCustomer.dto.UserDto;
import com.api.realCustomer.model.Recording;
import com.api.realCustomer.model.User;
import com.api.realCustomer.repository.RecordingRepository;
import com.api.realCustomer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
            String embeddingImageLikeString = Arrays.toString(recordingDto.getEmbeddingImage()).replace("[", "").replace("]", "");
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
        if (users.isEmpty()) {
            return null;
        }
        return userWithSameEmbedding(users, recordingDto);
    }

    public  User userWithSameEmbedding(List<User> users, RecordingDto recordingDto){
            for (User user: users){
                if(Objects.isNull(user.getEmbeddingImage())){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User haven't embedding");
                }
                String[] originalRecordingList =user.getEmbeddingImage().split(",");
                double[] oldEmbedding = Arrays.stream(originalRecordingList).mapToDouble(Double::parseDouble).toArray();
                if(calculateSimilitud(oldEmbedding,recordingDto.getEmbeddingImage()) > 0.90){
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>< IGUAL <<<<<<<<<<<<<<<< : " + user.getId());
                    return user;
                }
            }
            return null;
    }

    public double calculateSimilitud(double[] oldEmbedding, double[] embedding){

        double result5 = cosineSimilarity.cosineSimilarity(embedding, oldEmbedding);
        System.out.println("RESULT A-B: "+result5);
        return result5;
    }

    public  List<Recording>  getCustomerEntrance(){
        List<Recording> recordingList = recordingRepository.findAll();
        return recordingList;

    }

    public Recording createRecording(User user, RecordingDto recordingDto){
        Recording recording = new Recording();
        recording.setImage(recordingDto.getImage());
        recording.setEmbeddingImage(user.getEmbeddingImage());
        recording.setPosition(recordingDto.getPosition());
        recording.setUserId(user.getId());
        recordingRepository.save(recording);
        return recording;
    }

}
