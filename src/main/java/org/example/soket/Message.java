package org.example.soket;

import java.nio.ByteBuffer;
import java.util.Arrays;

import static org.example.soket.ByteArrayUtils.toByteArray;


public record Message(int commandType, int userId, String message) {

    public byte[] toBytes() {
        byte[] answer = new byte[8 + message.getBytes().length];
        System.arraycopy(toByteArray(commandType), 0, answer, 0, 4);
        System.arraycopy(toByteArray(userId), 0, answer, 4, 4);
        System.arraycopy(message.getBytes(), 0, answer, 8, message.getBytes().length);
        return answer;
    }

    public static Message fromBytes(byte[] messageInBytes) {

        ByteBuffer commandType = ByteBuffer.wrap(Arrays.copyOfRange(messageInBytes, 0, 4));
        ByteBuffer userId = ByteBuffer.wrap(Arrays.copyOfRange(messageInBytes, 4, 8));
        String message = new String(Arrays.copyOfRange(messageInBytes, 8, messageInBytes.length));

        return new Message(commandType.getInt(), userId.getInt(), message);
    }
}
