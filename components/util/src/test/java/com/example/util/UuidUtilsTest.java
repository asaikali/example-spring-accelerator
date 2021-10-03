/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("UUID utils")
class UuidUtilsTest {

  @Test
  void testUrlSafeRandomUuid() {
    String urlSafeRandomUuid = UuidUtils.urlSafeRandomUuid();
    UUID uuid = UuidUtils.fromBase64Url(urlSafeRandomUuid);
    String base64Url = UuidUtils.toBase64Url(uuid);
    assertThat(urlSafeRandomUuid).isEqualTo(base64Url);
  }

  @Test
  void testUuidBase64EncodingAndDecoding() {
    UUID randomUuid = UUID.randomUUID();
    String base64Url = UuidUtils.toBase64Url(randomUuid);
    UUID fromBase64Url = UuidUtils.fromBase64Url(base64Url);
    assertThat(randomUuid).isEqualTo(fromBase64Url);
  }

  @Test
  void testValidUuids() {
    // version 4 uuid
    String uuid = "7b29b10c-cbb3-4e2c-a2c9-dc2d0a14cf8e";
    assertThat(UuidUtils.isValid(uuid)).isTrue();

    // version 1 uuid
    uuid = "ab430e96-95e2-11e8-9eb6-529269fb1459";
    assertThat(UuidUtils.isValid(uuid)).isTrue();
  }

  @Test
  void testInvalidUuids() {
    String uuid = "7b29b10c-cbb3-4e2-a2c9-dc2d0a14cf8e";
    assertThat(UuidUtils.isValid(uuid)).isFalse();

    uuid = "ab430e96-95e2-";
    assertThat(UuidUtils.isValid(uuid)).isFalse();

    uuid = null;
    assertThat(UuidUtils.isValid(uuid)).isFalse();

    uuid = "";
    assertThat(UuidUtils.isValid(uuid)).isFalse();

    uuid = "abc";
    assertThat(UuidUtils.isValid(uuid)).isFalse();
  }
}
