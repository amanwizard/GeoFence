package com.mobile.push.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("greet")
public interface PushGcmService extends RemoteService{
	public void sendMsg(String push);
}
