package com.piedpiper.univerrate.handler;

import com.piedpiper.univerrate.protocol.Request;
import com.piedpiper.univerrate.protocol.Response;

public interface Handler<T extends Request, R extends Response> {
    R handle(T request);
}
