/*
 Copyright (c) 2010-2012 Nathan Rajlich
 Permission is hereby granted, free of charge, to any person
 obtaining a copy of this software and associated documentation
 files (the "Software"), to deal in the Software without
 restriction, including without limitation the rights to use,
 copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the
 Software is furnished to do so, subject to the following
 conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 OTHER DEALINGS IN THE SOFTWARE.
 */
//Copyright notice for websocket api used for purpose of this class
package ServerGPS;

//imports and stuff
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;

import javax.websocket.EncodeException;
import java.util.concurrent.*;
/**
 *
 * @author Matthew Bulat
 */
//endpoint annotation
@ServerEndpoint("/start")
public class GPSServer {



    //method used for purpose of opening new sessions
    //and checking if the databases are running fine

    @OnOpen
    public void onOpen(Session session) {
        try {
            session.getBasicRemote().sendText(data.check());
        } catch (IOException e) {
            //log.writeLog(" " + e);
        }
        //log.writeLog(" " + session.getId() + " has opened a connection");
    }

    //on message method which uses string for communication mainly webpage
    //when first connected it will check if admins credentials are correct
    //then it uses switch to pick the right action

    @OnMessage
    public void onMessage(String message, Session session) {


    }

    @OnMessage
    public void onMessage(byte[] message, Session session) throws InterruptedException {

    }

    @OnClose
    public void onClose(Session session) {
        //log.writeLog("Session " + session.getId() + " has ended");
    }

    public void reply(Session session) {
        try {
            //session.getBasicRemote().sendObject();
        } catch (IOException | EncodeException e) {
            //log.writeLog("Socket Input/Output exception or EncodeException on reply method " + e);
        }
    }
//new thread used for purpose of sending data on seperate thread



}
