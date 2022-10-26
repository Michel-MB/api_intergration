package com.exampleIntregration.demoInt;

import com.exampleIntregration.demoInt.model.Entries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface entriesRepo extends JpaRepository<Entries, String> {
}
