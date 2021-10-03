/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

interface PersistableRepository extends JpaRepository<Persistable, Long> {}
