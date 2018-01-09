package com.goshop.app.data.realm;

public class EncryptionKey {

    public static byte[] generateKey() {
        // TODO: Generate a key to encrypt realm
        // IMPORTANT! This is a silly way to generate a key. It is also never stored.
        // For proper key handling please consult:
        // * https://developer.android.com/training/articles/keystore.html
        // * http://nelenkov.blogspot.dk/2012/05/storing-application-secrets-in-androids.html
        byte[] key = new byte[64];
        for (int i = 0; i < 64; i++) {
            key[i] = Integer.valueOf(i).byteValue();
        }
        return key;
    }
}