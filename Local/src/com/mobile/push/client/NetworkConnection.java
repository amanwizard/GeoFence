package com.mobile.push.client;


public class NetworkConnection {
	
	public native static void init() /*-{
		var networkState = $wnd.navigator.connection.type;
		
		var states = {};
	    states[$wnd.Connection.UNKNOWN]  = 'Unknown connection';
	    states[$wnd.Connection.ETHERNET] = 'Ethernet connection';
	    states[$wnd.Connection.WIFI]     = 'WiFi connection';
	    states[$wnd.Connection.CELL_2G]  = 'Cell 2G connection';
	    states[$wnd.Connection.CELL_3G]  = 'Cell 3G connection';
	    states[$wnd.Connection.CELL_4G]  = 'Cell 4G connection';
	    states[$wnd.Connection.CELL]     = 'Cell generic connection';
	    states[$wnd.Connection.NONE]     = 'No network connection';
	
	    $wnd.alert('Connection type: ' + states[networkState]);
    
	}-*/;
	
	public native static void hideBody() /*-{
		var myElement = $wnd.document.getElementById("main_body");
		myElement.style.display = "none";
	}-*/;
	
	public native static void showBody() /*-{
		var myElement = $wnd.document.getElementById("main_body");
		myElement.style.display = "initial";
	}-*/;
	
}
