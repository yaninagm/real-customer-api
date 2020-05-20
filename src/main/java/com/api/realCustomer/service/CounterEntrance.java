package com.api.realCustomer.service;

import com.api.realCustomer.model.User;
import com.api.realCustomer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CounterEntrance {
    @Autowired
    private UserRepository userRepository ;


    public Long dailyEntranceCount(User user){
        Long entranceByDay = user.getEntranceByDay() + 1;
        user.setEntranceByDay(entranceByDay);
        //userRepository.save(user);
        return entranceByDay;
    }

    public Long monthlyEntranceCount(User user){
        Long entranceByMonth = user.getEntranceByMonth() + 1;
        user.setEntranceByMonth(entranceByMonth);
        //userRepository.save(user);
        return entranceByMonth;
    }

    public Long historyEntranceCount(User user){
        Long historyEntrance = user.getHistoryEntrance() + 1;
        user.setHistoryEntrance(historyEntrance);
        //userRepository.save(user);
        return historyEntrance;
    }
}
