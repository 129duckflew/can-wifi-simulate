package org.example.processor;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.session.SessionHolder;
import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CanWifiProcessor implements MessageProcessor<Object> {

    @Override
    @SneakyThrows
    public void process(AioSession aioSession, Object req) {
        log.info("process===============");
        SessionHolder.addSession(aioSession);
    }

    @Override
    public void stateEvent(AioSession session, StateMachineEnum stateMachineEnum, Throwable throwable) {
        switch (stateMachineEnum){
            case NEW_SESSION -> {
                log.info("new session !!!");
                SessionHolder.sessionList.add(session   );
            }
        }
        MessageProcessor.super.stateEvent(session, stateMachineEnum, throwable);
    }
}
