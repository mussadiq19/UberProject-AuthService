package com.example.uberprojectauthservice.services;

import com.example.uberprojectauthservice.dto.PassengerDto;
import com.example.uberprojectauthservice.dto.PassengerSignupRequestDto;
import com.example.uberprojectauthservice.repositories.PassengerRepository;
import com.example.uberprojectentityservice.models.Passenger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final PassengerRepository passengerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(PassengerRepository passengerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public PassengerDto signupPassenger(PassengerSignupRequestDto passengerSignupRequestDto){
        Passenger passenger =Passenger.builder()
                .email(passengerSignupRequestDto.getEmail())
                .phoneNumber(passengerSignupRequestDto.getPhoneNumber())
                .password(bCryptPasswordEncoder.encode( passengerSignupRequestDto.getPassword()))
                .phoneNumber(passengerSignupRequestDto.getPhoneNumber())
                .name(passengerSignupRequestDto.getName())
                .build();

               Passenger newPassenger= passengerRepository.save(passenger);
               return(PassengerDto.from(newPassenger));
     }
}
