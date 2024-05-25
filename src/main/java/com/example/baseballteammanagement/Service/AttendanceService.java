package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.DTO.AttendDTO;
import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Entity.Practice;
import com.example.baseballteammanagement.Entity.PracticeAttendance;
import com.example.baseballteammanagement.Repository.MemberRepo;
import com.example.baseballteammanagement.Repository.PracticeAttendanceRepo;
import com.example.baseballteammanagement.Repository.PracticeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class AttendanceService implements IAttendanceService {
    @Autowired
    private PracticeAttendanceRepo practiceAttendanceRepo;
    @Override
    public String practiceAttend(Set<AttendDTO> attendDTOSet) {
        for (AttendDTO attendDTO :
                attendDTOSet) {
            Optional<PracticeAttendance> practiceAttendanceOptional =
                    practiceAttendanceRepo.findByMemberIDAndPracticeID(attendDTO.getMemberID(),
                            attendDTO.getPracticeID());
            if (practiceAttendanceOptional.isEmpty()) {
                return "id buổi tập hoặc id thành viên không tồn tại";
            }
            practiceAttendanceOptional.get().setAttend(attendDTO.getIsAttend() == 1);
            practiceAttendanceRepo.save(practiceAttendanceOptional.get());
        }
        return "thành công";
    }
}

