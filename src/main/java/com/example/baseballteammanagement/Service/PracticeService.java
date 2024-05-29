package com.example.baseballteammanagement.Service;

import com.example.baseballteammanagement.Entity.Member;
import com.example.baseballteammanagement.Entity.Practice;
import com.example.baseballteammanagement.Entity.PracticeAttendance;
import com.example.baseballteammanagement.Repository.MemberRepo;
import com.example.baseballteammanagement.Repository.PracticeAttendanceRepo;
import com.example.baseballteammanagement.Repository.PracticeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PracticeService implements IPracticeService{
    @Autowired
    private PracticeRepo practiceRepo;
    @Autowired
    private PracticeAttendanceRepo practiceAttendanceRepo;
    @Autowired
    private MemberRepo memberRepo;

    @Override
    public String newPracticeSession(Practice practice) {
        if (practice.getPracticeDate() == null) {
            practice.setPracticeDate(LocalDateTime.now());
        }
        if (practice.getEndTime() == null) {
            practice.setEndTime(practice.getPracticeDate().plusHours(3));
        }
        practiceRepo.save(practice);

        Set<Member> activeMember = memberRepo.findAllByMemberStatus("ACTIVITY");
        List<PracticeAttendance> practiceAttendanceList = new ArrayList<>();
        for (Member member :
                activeMember) {
            practiceAttendanceList.add(new PracticeAttendance(member.getMemberID(), practice.getPracticeID(), false));
            practice.setTotalActive(practice.getTotalActive()+1);
        }
        practiceAttendanceRepo.saveAll(practiceAttendanceList);
        practiceRepo.save(practice);
        return "Done!\n" + "Start time: " + practice.getPracticeDate()
                + "\nEnd time: " + practice.getEndTime();
    }

    @Override
    public String updatePractice(int practiceSessionID, Practice practice) {
        Optional<Practice> practiceOptional = practiceRepo.findById(practiceSessionID);
        if (practiceOptional.isEmpty()) {
            return "Practice ID doesn't exist!";
        }
        practiceOptional.get().setPracticeDate(practice.getPracticeDate());
        practiceOptional.get().setEndTime(practice.getEndTime());
        practiceOptional.get().setContent(practice.getContent());
        practiceRepo.save(practiceOptional.get());

        return "Done!\n" + "Start time: " + practiceOptional.get().getPracticeDate()
                + "\nEnd time: " + practiceOptional.get().getEndTime();
    }

    @Override
    public String deletePracticeSession(int practiceSessionID) {
        Optional<Practice> practiceOptional = practiceRepo.findById(practiceSessionID);
        if (practiceOptional.isEmpty()) {
            return null;
        }
        practiceAttendanceRepo.deleteAll(practiceOptional.get().getPracticeAttendanceSet());
        practiceRepo.delete(practiceOptional.get());
        return "Done!";
    }

    @Override
    public Set<Practice> getPracticeSessionBetweenTwoDate(LocalDate date1, LocalDate date2) {
        if (date1.isAfter(date2)) {
            return practiceRepo.getPracticeByPracticeDateBetween(date2.atStartOfDay(), date1.plusDays(1).atStartOfDay());
        }
        return practiceRepo.getPracticeByPracticeDateBetween(date1.atStartOfDay(), date2.plusDays(1).atStartOfDay());
    }
}
