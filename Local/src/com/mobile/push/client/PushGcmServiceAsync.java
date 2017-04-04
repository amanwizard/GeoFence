package com.mobile.push.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PushGcmServiceAsync {

	void sendMsg(String push, AsyncCallback<Void> callback);

}
