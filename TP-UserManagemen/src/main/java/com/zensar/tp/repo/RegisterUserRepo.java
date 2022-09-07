package com.zensar.tp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.tp.entity.RegisterUserEntity;

@Repository
public interface RegisterUserRepo extends JpaRepository<RegisterUserEntity, Integer> {
}

