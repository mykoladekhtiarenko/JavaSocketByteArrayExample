package org.example.soket;

import java.nio.ByteBuffer;

public final class ByteArrayUtils {

    public static byte[] toByteArray(int i){
        return ByteBuffer.allocate(4).putInt(i).array();
    }

}
