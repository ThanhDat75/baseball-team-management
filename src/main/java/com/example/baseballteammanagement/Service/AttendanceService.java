package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.AttendDTO;
import com.example.baseballteammanagement.DTO.MemberAttendDTO;
import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Entity.Practice;
import com.example.baseballteammanagement.Entity.PracticeAttendance;
import com.example.baseballteammanagement.Repository.MemberRepo;
import com.example.baseballteammanagement.Repository.PracticeAttendanceRepo;
import com.example.baseballteammanagement.Repository.PracticeRepo;
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
    @Autowired
    private PracticeRepo practiceRepo;
    @Override
    public String practiceAttend(Set<AttendDTO> attendDTOSet, int practiceID) {
        int attendCount = 0;
        for (AttendDTO attendDTO :
                attendDTOSet) {
            Optional<PracticeAttendance> practiceAttendanceOptional =
                    practiceAttendanceRepo.findByMemberIDAndPracticeID(attendDTO.getMemberID(),
                            practiceID);
            if (practiceAttendanceOptional.isEmpty()) {
                return "Practice ID or member ID doesn't exist!";
            }
            if (attendDTO.getIsAttend() == 1) {
                practiceAttendanceOptional.get().setAttend(true);
                attendCount++;
            } else {
                practiceAttendanceOptional.get().setAttend(false);
            }
            practiceAttendanceRepo.save(practiceAttendanceOptional.get());
        }
        Practice practice = practiceRepo.getReferenceById(practiceID);
        practice.setTotalAttend(attendCount);
        practiceRepo.save(practice);
        return "Done!";
    }

    @Override
    public Set<MemberAttendDTO> allMemberMissedMoreThanNumberOfSessions(int numberOfSessions) {
        Set<MemberAttendDTO> memberAttendSet = new HashSet<>();
        for (Member member: memberRepo.findAllByMemberStatus("ACTIVITY", null)) {
            Integer numberOfSessionsNotAttend = practiceAttendanceRepo.countByAttendIsFalseAndMemberIDIs(member.getMemberID());
            if (numberOfSessionsNotAttend == null) {
                continue;
            }
            if (numberOfSessionsNotAttend >= numberOfSessions) {
                memberAttendSet.add(new MemberAttendDTO(member, numberOfSessionsNotAttend));
            }
        }
        return memberAttendSet;
    }
}

