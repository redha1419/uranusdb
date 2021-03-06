package com.uranusdb.actions.node;

import com.uranusdb.events.ExchangeEvent;
import com.uranusdb.server.Constants;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.StatusCodes;

import static com.uranusdb.server.UranusServer.graphs;

public interface DeleteNode {

    static void handle(ExchangeEvent exchangeEvent, int number, boolean respond) {
        boolean succeeded = graphs[number].removeNode(exchangeEvent.getParameters().get(Constants.LABEL), exchangeEvent.getParameters().get(Constants.ID));

        if (respond) {
            HttpServerExchange exchange = exchangeEvent.get();
            if (succeeded) {
                exchange.setStatusCode(StatusCodes.NO_CONTENT);
            } else {
                exchange.setStatusCode(StatusCodes.NOT_FOUND);
            }
            exchangeEvent.clear();
        }
    }
}
