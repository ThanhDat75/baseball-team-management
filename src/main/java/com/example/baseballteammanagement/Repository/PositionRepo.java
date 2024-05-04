package com.example.baseballteammanagement.Repository;

import com.example.baseballteammanagement.Entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepo extends JpaRepository<Position, Integer> {
    Optional<Position> findPositionByPositionName(String positionName);
}
