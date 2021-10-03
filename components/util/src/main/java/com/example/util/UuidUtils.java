/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Base64;
import java.util.UUID;

/** Utility methods for working with UUIDs. */
public class UuidUtils {

  private static final Base64.Encoder ENCODER = Base64.getUrlEncoder().withoutPadding();
  private static final Base64.Decoder DECODER = Base64.getUrlDecoder();

  private UuidUtils() {}

  /**
   * Generate a secure random uuid and return it as base64 encoded url safe string.
   *
   * @return base64 encoded url safe string
   */
  public static String urlSafeRandomUuid() {
    return toBase64Url(UUID.randomUUID());
  }

  /**
   * Decode a base64 encoded UUID to java UUID. It is assumed that the byte array is stored in big
   * endian fashion that is most significant bits first. Strings in in traditional base64 and url
   * safe base64. see http://www.ietf.org/rfc/rfc3548.txt for details of the url safe base64
   * encoding
   *
   * @param base64String a base64 encoded string
   * @return A java UUID
   */
  public static UUID fromBase64Url(String base64String) {
    return fromBytes(DECODER.decode(base64String));
  }

  /**
   * Encode a UUID as a base64 url safe string.
   *
   * @param uuid the uuid to encode.
   * @return base64 encoded string that is safe to use in a url
   */
  public static String toBase64Url(UUID uuid) {
    return ENCODER.encodeToString(toBytes(uuid));
  }

  /**
   * Checks if given value is a valid uuid.
   *
   * @param uuid String representation of a uuid
   * @return true if the uuid is valid, false otherwise
   */
  public static boolean isValid(String uuid) {
    if (uuid == null) {
      return false;
    }
    try {
      // we have to convert to object and back to string because the built in fromString
      // does not have good validation logic.
      UUID fromStringUuid = UUID.fromString(uuid);
      String toStringUuid = fromStringUuid.toString();
      return toStringUuid.equals(uuid);
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  /**
   * Convert a UUID to a byte array.
   *
   * @param uuid the UUID to convert to a byte array
   * @return byte array from the uuid
   */
  private static byte[] toBytes(UUID uuid) {
    byte[] bytes = new byte[16];
    ByteBuffer bb = ByteBuffer.wrap(bytes);
    bb.order(ByteOrder.BIG_ENDIAN);
    bb.putLong(uuid.getMostSignificantBits());
    bb.putLong(uuid.getLeastSignificantBits());
    return bb.array();
  }

  /**
   * Convert bytes to UUID, bytes must be in big endian which means significant bits first.
   *
   * @param bytes array in big endian format.
   * @return UUID
   */
  private static UUID fromBytes(byte[] bytes) {
    ByteBuffer bb = ByteBuffer.wrap(bytes);
    return new UUID(bb.getLong(), bb.getLong());
  }
}
