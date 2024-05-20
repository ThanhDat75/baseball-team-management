package com.example.baseballteammanagement.Repository;

import com.example.baseballteammanagement.Entity.MemberPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MemberPositionRepo extends JpaRepository<MemberPosition, Integer> {
    void deleteMemberPositionsByMemberID(int memberID);
}
