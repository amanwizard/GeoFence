package com.mobile.push.client;


public class AndroidPush {
	//"senderID" : "343274135301"
	public native static void init() /*-{
		var push = $wnd.PushNotification.init({
			"android" : {
				"senderID" : "65962483480"
			},
			"ios" : {
				"alert" : "true",
				"badge" : "true",
				"sound" : "true"
			},
			"windows" : {}
		});

		push.on('registration', function(data) {
			$wnd.alert("registered id : "+data.registrationId);
			$doc.getElementById("regId").value = data.registrationId;
		});

		push.on('notification', function(data) {		
			console.log(data.notificationId);
			$wnd.alert("notificationId"+data.notificationId);
		});

		push.on('error', function(e) {
			$wnd.alert("Got error");
		});
	}-*/;

}
