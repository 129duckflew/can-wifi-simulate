package org.example.protocol;

import lombok.extern.slf4j.Slf4j;
import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;

@Slf4j
public class CanWifiProtocol implements Protocol<Object> {
    @Override
    public Object decode(ByteBuffer byteBuffer, AioSession aioSession) {
        log.info("decode ==============");
        int remain = byteBuffer.remaining();
        byte[] buf=new byte[remain];
        byteBuffer.get(buf);
        return new Object();
    }
}
