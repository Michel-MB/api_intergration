package com.exampleIntregration.demoInt;

import com.exampleIntregration.demoInt.model.Apis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<Apis,Integer> {
}
