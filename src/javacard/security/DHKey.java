/**
 * Java Card 3.0.5 API
 * url: https://docs.oracle.com/javacard/3.0.5/index.html
 *
 * Copyright (C) 2020, Oracle and/or its affiliates. All rights reserved.
 */

package javacard.security;

import javacard.security.CryptoException;
import javacard.security.Key;
import javacard.security.KeyBuilder;
import javacard.security.Signature;

/**
 * The <code>DHKey</code> interface is the base interface for the DH
 * algorithm's private and public key implementations. A DH private key
 * implementation must also implement the <code>DHPrivateKey</code> interface
 * methods. A DH public key implementation must also implement the
 * <code>DHPublicKey</code> interface methods. <p> Component Q is an optional
 * key component. When the other 3 components of the key (X or Y, P, G) are set,
 * the key is initialized and ready for use. <p>
 *
 * @see DHPublicKey DHPublicKey
 * @see DHPrivateKey DHPrivateKey
 * @see KeyBuilder KeyBuilder
 * @see Signature Signature
 * @see javacardx.crypto.KeyEncryption javacardx.crypto.KeyEncryption
 */
public interface DHKey {

  /**
   * Sets the prime parameter value of the key. The plain text data format is
   * big-endian and right-aligned (the least significant bit is the least
   * significant bit of last byte). Input prime parameter data is copied into
   * the internal representation. The value of P limits the value of the
   * public value Y.
   * <p>
   * Note:
   * <ul>
   * <li><em>If the key object implements the
   * </em><code>javacardx.crypto.KeyEncryption</code><em> interface and the
   * </em><code>Cipher</code><em> object specified via
   * </em><code>setKeyCipher()</code><em> is not </em><code>null</code><em>, the
   * prime parameter value is decrypted using the </em><code>Cipher</code><em>
   * object.</em>
   * </ul>
   *
   * @param buffer
   *            the input buffer
   * @param offset
   *            the offset into the input buffer at which the prime parameter
   *            value begins
   * @param length
   *            the length of the prime parameter value
   * @exception CryptoException
   *                with the following reason code:
   *                <ul>
   *                <li><code>CryptoException.ILLEGAL_VALUE</code> if the
   *                input parameter data length is inconsistent with the
   *                implementation or if input data decryption is required and
   *                fails.
   *                </ul>
   */
  void setP(byte[] buffer, short offset, short length) throws CryptoException;

  /**
   * Sets the optional subprime parameter value of the key. The plain text data
   * format is big-endian and right-aligned (the least significant bit is the
   * least significant bit of last byte). Input subprime parameter data is
   * copied into the internal representation. The value of Q limits the value of
   * the private value X. <p> Note: <ul> <li><em>If the key object implements
   * the </em><code>javacardx.crypto.KeyEncryption</code><em> interface and the
   * </em><code>Cipher</code><em> object specified via
   * </em><code>setKeyCipher()</code><em> is not </em><code>null</code><em>, the
   * subprime parameter value is decrypted using the
   * </em><code>Cipher</code><em> object.</em>
   * </ul>
   *
   * @param buffer
   *            the input buffer
   * @param offset
   *            the offset into the input buffer at which the subprime
   *            parameter value begins
   * @param length
   *            the length of the subprime parameter value
   * @exception CryptoException
   *                with the following reason code:
   *                <ul>
   *                <li><code>CryptoException.ILLEGAL_VALUE</code> if the
   *                input parameter data length is inconsistent with the
   *                implementation or if input data decryption is required and
   *                fails.
   *                </ul>
   */
  void setQ(byte[] buffer, short offset, short length) throws CryptoException;

  /**
   * Sets the base parameter value of the key. The plain text data format is
   * big-endian and right-aligned (the least significant bit is the least
   * significant bit of last byte). Input base parameter data is copied into
   * the internal representation.
   * <p>
   * Note:
   * <ul>
   * <li><em>If the key object implements the
   * </em><code>javacardx.crypto.KeyEncryption</code><em> interface and the
   * </em><code>Cipher</code><em> object specified via
   * </em><code>setKeyCipher()</code><em> is not </em><code>null</code><em>, the
   * base parameter value is decrypted using the </em><code>Cipher</code><em>
   * object.</em>
   * </ul>
   *
   * @param buffer
   *            the input buffer
   * @param offset
   *            the offset into the input buffer at which the base parameter
   *            value begins
   * @param length
   *            the length of the base parameter value
   * @exception CryptoException
   *                with the following reason code:
   *                <ul>
   *                <li><code>CryptoException.ILLEGAL_VALUE</code> if the
   *                input parameter data length is inconsistent with the
   *                implementation or if input data decryption is required and
   *                fails.
   *                </ul>
   */
  void setG(byte[] buffer, short offset, short length) throws CryptoException;

  /**
   * Returns the prime parameter value of the key in plain text. The data
   * format is big-endian and right-aligned (the least significant bit is the
   * least significant bit of last byte).
   *
   * @param buffer
   *            the output buffer
   * @param offset
   *            the offset into the output buffer at which the prime parameter
   *            value starts
   * @return the byte length of the prime parameter value returned
   * @exception CryptoException
   *                with the following reason code:
   *                <ul>
   *                <li><code>CryptoException.UNINITIALIZED_KEY</code> if
   *                the prime parameter has not been successfully initialized
   *                since the time the initialized state of the key was set to
   *                false.
   *                </ul>
   * @see Key Key
   */
  short getP(byte[] buffer, short offset);

  /**
   * Returns the subprime parameter value of the key in plain text. The data
   * format is big-endian and right-aligned (the least significant bit is the
   * least significant bit of last byte). The value of q limits the size of the
   * private value X.
   *
   * @param buffer
   *            the output buffer
   * @param offset
   *            the offset into the output buffer at which the subprime
   *            parameter value begins
   * @return the byte length of the subprime parameter value returned
   * @exception CryptoException
   *                with the following reason code:
   *                <ul>
   *                <li><code>CryptoException.UNINITIALIZED_KEY</code> if
   *                the subprime parameter has not been successfully
   *                initialized since the time the initialized state of the
   *                key was set to false.
   *                </ul>
   * @see Key Key
   */
  short getQ(byte[] buffer, short offset);

  /**
   * Returns the base parameter value of the key in plain text. The data
   * format is big-endian and right-aligned (the least significant bit is the
   * least significant bit of last byte).
   *
   * @param buffer
   *            the output buffer
   * @param offset
   *            the offset into the output buffer at which the base parameter
   *            value begins
   * @return the byte length of the base parameter value returned
   * @exception CryptoException
   *                with the following reason code:
   *                <ul>
   *                <li><code>CryptoException.UNINITIALIZED_KEY</code> if
   *                the base parameter has not been successfully initialized
   *                since the time the initialized state of the key was set to
   *                false.
   *                </ul>
   * @see Key Key
   */
  short getG(byte[] buffer, short offset);
}
