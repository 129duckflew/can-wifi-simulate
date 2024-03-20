package org.example.session;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.smartboot.socket.transport.AioSession;

import java.util.List;
import java.util.Vector;

@Slf4j
public class SessionHolder {

    public static List<AioSession> sessionList=new Vector<>();

    @SneakyThrows
    public static void addSession(AioSession session){
        if (session!=null){
            log.info("new session from ip={}",session.getRemoteAddress().getHostName());
            sessionList.add(session);
        }
    }

}
