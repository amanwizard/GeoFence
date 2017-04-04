package com.mobile.push.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;

public class SmsJsni {

	public native static void init()/*-{

		if (!($wnd.SMS)) {
			console.log('SMS plugin not ready');
			return;
		}

		if ($wnd.SMS)
			$wnd.SMS.startWatch(function() {
				console.log('watching started');
			}, function() {
				console.log('watching failed');
			});

		$doc
				.addEventListener(
						'onSMSArrive',
						function(e) {
							var sms = e.data;
							var jsonStr = JSON.stringify(sms);
							@com.mobile.push.client.SmsJsni::convertToMap(Ljava/lang/String;)(jsonStr);
							console.log('sms converted! ..');
						});

	}-*/;

	public native static void readSmsList(String dateTime)/*-{
		console.log('date time: '+dateTime);
		if (!($wnd.SMS)) {
			console.log('SMS plugin not ready');
			return;
		}

		var filter = {
			box : 'inbox', // 'inbox' (default), 'sent', 'draft', 'outbox', 'failed', 'queued', and '' for all

			date : dateTime,
		};

		console.log('filter : '+JSON.stringify(filter));

		if ($wnd.SMS)
			$wnd.SMS.listSMS(filter, function(data) {
				
				console.log('sms listed as json array');
				console.log(JSON.stringify(data));

				if (Array.isArray(data)) {
					for ( var i in data) {
						var sms = data[i];
						
						console.log("message at "+i+" place "+sms);
						
						console.log("stringify message at "+i+" place "+JSON.stringify(sms));
					}
				}
			}, function(err) {
				console.log('error list sms: ' + err);
			});

	}-*/;

	public static Map<String, String> convertToMap(String jsonStr) {
		Map<String, String> map = new HashMap<String, String>();

		String smsContent = "";
		JSONObject jsonObj = (JSONObject) JSONParser.parseStrict(jsonStr);

		if (jsonObj != null) {
			for (String key : jsonObj.keySet()) {

				map.put(key, jsonObj.get(key).toString());
			}
		} else
			showAlert("json object is empty");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			smsContent = smsContent + entry.getKey() + ":" + entry.getValue()
					+ "  /";
		}
		showAlert(smsContent);

		long dateInt = Long.parseLong(map.get("date"));

		Date date = new Date(dateInt);
		showAlert(date.toString());
		return map;
	}

	public native static void showAlert(String str)/*-{
		$wnd.alert(str);
	}-*/;

}
