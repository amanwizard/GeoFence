package com.mobile.push.client;

import com.google.gwt.user.client.Window;

public class ScannerJsni {

	 String link;
	
	public native  void scan(ScannerJsni instance) /*-{
		
		$wnd.cordova.plugins.barcodeScanner.scan(
		function(result) {
			var url=result.text;
			instance.@com.mobile.push.client.ScannerJsni::onScan(Ljava/lang/String;)(url);
			
		}, function(error) {
			alert("Scanning failed: " + error);
		}, {
			"preferFrontCamera" : false,
			"showFlipCameraButton" : true,
			"orientation" : "portrait"
		});
		
	}-*/;

	 public void onScan(String link){
		 this.link=link;
	 }

	public  String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	 
	 
	
}
