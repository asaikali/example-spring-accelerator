/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.database.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

interface UniquePersistableRepository extends JpaRepository<UniquePersistable, UUID> {}
