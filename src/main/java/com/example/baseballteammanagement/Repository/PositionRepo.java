package com.example.baseballteammanagement.Repository;

import com.example.baseballteammanagement.Entity.MemberPosition;
import com.example.baseballteammanagement.Entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PositionRepo extends JpaRepository<Position, Integer> {

}
