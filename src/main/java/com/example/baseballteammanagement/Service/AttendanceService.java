package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.AttendDTO;
import com.example.baseballteammanagement.DTO.MemberAttendDTO;
import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Entity.PracticeAttendance;
import com.example.baseballteammanagement.Repository.MemberRepo;
import com.example.baseballteammanagement.Repository.PracticeAttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AttendanceService implements IAttendanceService {
    @Autowired
    private PracticeAttendanceRepo practiceAttendanceRepo;
    @Autowired
    private MemberRepo memberRepo;
    @Override
    public String practiceAttend(Set<AttendDTO> attendDTOSet) {
        for (AttendDTO attendDTO :
                attendDTOSet) {
            Optional<PracticeAttendance> practiceAttendanceOptional =
                    practiceAttendanceRepo.findByMemberIDAndPracticeID(attendDTO.getMemberID(),
                            attendDTO.getPracticeID());
            if (practiceAttendanceOptional.isEmpty()) {
                return "Practice ID or member ID doesn't exist!";
            }
            practiceAttendanceOptional.get().setAttend(attendDTO.getIsAttend() == 1);
            practiceAttendanceRepo.save(practiceAttendanceOptional.get());
        }
        return "Done!";
    }

    @Override
    public Set<MemberAttendDTO> allMemberMissedMoreThanNumberOfSessions(int numberOfSessions) {
        Set<MemberAttendDTO> memberAttendSet = new HashSet<>();
        for (Member member: memberRepo.findAllByMemberStatus("ACTIVITY")) {
            Integer numberOfSessionsNotAttend = practiceAttendanceRepo.countByAttendIsFalseAndMemberIDIs(member.getMemberID());
            if (numberOfSessionsNotAttend == null) {
                continue;
            }
            if (numberOfSessionsNotAttend >= numberOfSessions) {
                memberAttendSet.add(new MemberAttendDTO(member.getMemberID(), member.getMemberName(), numberOfSessionsNotAttend));
            }
        }
        return memberAttendSet;
    }
}

