package com.mobile.push.client;

public class NfcJsni {

	public native static void init() /*-{
		$wnd.nfc.enabled(function() {
			$wnd.alert('yes!')
		},
		// msg is one of NO_NFC (no hardware support) or NFC_DISABLED (supported but disabled)
		function(msg) {
			$wnd.alert(msg)
			$wnd.nfc.showSettings();
		});

	}-*/;

	public native static void write()/*-{

		var records = [ $wnd.ndef.uriRecord("http://bixuser.bixera.com/index.html") ];

		$wnd.nfc.write(records, function() {
			$wnd.alert("write success");
			console.log("write success")
		}, function() {
			$wnd.alert("write failure");
			console.log("write error")
		});

	}-*/;

}
