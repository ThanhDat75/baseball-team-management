package com.example.baseballteammanagement.Repository;

import com.example.baseballteammanagement.Entity.MemberPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPositionRepo extends JpaRepository<MemberPosition, Integer> {
    String deleteAllByMemberID(int memberID);
    void deleteMemberPositionsByMemberID(int memberID);

}
