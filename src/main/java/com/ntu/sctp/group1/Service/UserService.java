//package com.ntu.sctp.group1.Service;
//
//import com.ntu.sctp.group1.DataTransferObject.UidDto;
//import com.ntu.sctp.group1.DataTransferObject.UserSignInDto;
//import com.ntu.sctp.group1.Exceptions.InvalidUidException;
//import com.ntu.sctp.group1.Exceptions.NoVolunteerFoundExceptions;
//import com.ntu.sctp.group1.Exceptions.UnauthorisedSignInException;
//import com.ntu.sctp.group1.entity.Role;
//import com.ntu.sctp.group1.entity.UserCredentials;
//import com.ntu.sctp.group1.entity.Volunteer;
//import com.ntu.sctp.group1.repository.UserRepository;
//import com.ntu.sctp.group1.repository.VolunteerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    UserRepository userRepo;
//
//    @Autowired
//    VolunteerRepository volunteerRepo;
//
//    public UserSignInDto signIn(UidDto obj) throws InvalidUidException, NoVolunteerFoundExceptions, UnauthorisedSignInException {
//        Optional<UserCredentials> findUser = userRepo.findByUid(obj.getUid());
//        if(findUser.isEmpty()) {
//            throw new InvalidUidException("UID in credential is not valid");
//        }
//
//        if(!findUser.get().getRole().equals(Role.USER)) {
//            throw new UnauthorisedSignInException("You are not authorised to access!");
//        }
//
//        UserCredentials user = findUser.get();
//        user.setTokenIsActive(true);
//        userRepo.save(user);
//
//        Optional<Volunteer> volunteerInfo = volunteerRepo.findById(user.getVolunteerId());
//        if(volunteerInfo.isEmpty()) {
//            throw new NoVolunteerFoundExceptions("No volunteer info found");
//        }
//
//        return new UserSignInDto(user, volunteerInfo.get());
//    }
//
//
//    public void signout(UidDto obj) throws InvalidUidException {
//        Optional<UserCredentials> findUser = userRepo.findByUid(obj.getUid());
//        if(findUser.isEmpty()) {
//            throw new InvalidUidException("UID in credential is not valid");
//        }
//
//        UserCredentials user = findUser.get();
//        user.setTokenIsActive(false);
//        userRepo.save(user);
//    }
//
//    public UserCredentials administratorSignIn(UidDto uidDto) throws InvalidUidException, UnauthorisedSignInException {
//        Optional<UserCredentials> findUser = userRepo.findByUid(uidDto.getUid());
//        if(findUser.isEmpty()) {
//            throw new InvalidUidException("UID in credential is not valid");
//        }
//
//        if(!findUser.get().getRole().equals(Role.ADMIN)) {
//            throw new UnauthorisedSignInException("You are not authorised to access!");
//        }
//
//        UserCredentials user = findUser.get();
//        user.setTokenIsActive(true);
//        return userRepo.save(user);
//    }
//
//}
