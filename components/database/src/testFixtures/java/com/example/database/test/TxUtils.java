/*
 * Copyright 2021 Adib Saikali
 *
 */

package com.example.database.test;

import java.util.function.Supplier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * A set of ulitity methods to use to create new transaction boundaries, very useful during testing
 * to get the database into a specific desired state and test what happens to the database.
 */
public class TxUtils {

  public static boolean isTxActive() {
    return TransactionSynchronizationManager.isActualTransactionActive();
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public <T> T requireNew(Supplier<T> callback) {
    return callback.get();
  }

  @Transactional(propagation = Propagation.MANDATORY)
  public <T> T mandatory(Supplier<T> callback) {
    return callback.get();
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public <T> T required(Supplier<T> callback) {
    return callback.get();
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public <T> T supports(Supplier<T> callback) {
    return callback.get();
  }

  @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
  public <T> T readOnly(Supplier<T> callback) {
    return callback.get();
  }
}
