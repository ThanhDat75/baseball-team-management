package com.example.baseballteammanagement.Repository;

import com.example.baseballteammanagement.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {
    @Query(value = "SELECT M.* FROM Member AS M " +
            "JOIN MemberPosition AS MP ON M.memberID = MP.memberID " +
            "JOIN Position AS P ON MP.positionID = P.positionID WHERE P.positionID = :positionID", nativeQuery = true)
    Set<Member> findAllByPositionID(@Param("positionID") Integer positionID);
    Set<Member> findAllByMemberNameContaining(String namePath);
    Set<Member> findAllByNickNameContaining(String nickName);
    Set<Member> findAllByMemberStatus(String status);
}
