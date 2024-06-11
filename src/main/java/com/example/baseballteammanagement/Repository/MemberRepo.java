package com.example.baseballteammanagement.Repository;

import com.example.baseballteammanagement.Entity.Member;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {
    @Query(value = "SELECT M.* FROM Member AS M " +
            "JOIN MemberPosition AS MP ON M.memberID = MP.memberID " +
            "JOIN Position AS P ON MP.positionID = P.positionID WHERE P.positionID = :positionID ORDER BY M.memberID", nativeQuery = true)
    Set<Member> findAllByPositionID(@Param("positionID") Integer positionID);
    Set<Member> findAllByMemberNameContaining(String namePath, Sort sort);
    Set<Member> findAllByNickNameContaining(String nickName, Sort sort);
    Set<Member> findAllByMemberStatus(String status, Sort sort);
}
