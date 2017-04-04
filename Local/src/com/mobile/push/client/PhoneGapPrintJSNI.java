package com.mobile.push.client;

public class PhoneGapPrintJSNI {

	public native static void init() /*-{
		$wnd.cordova.plugins.printer.isAvailable(function(isAvailable) {
			$wnd.alert(isAvailable ? 'Service is available'
					: 'Service NOT available');
		});
	}-*/;

	public native static Boolean isAvailable() /*-{
		var value = false;
		$wnd.cordova.plugins.printer.isAvailable(function(isAvailable) {
			if (isAvailable) {
				value = true;
			}
		});
		return @java.lang.Boolean::valueOf(Z)(value);
	}-*/;

	public native static void print(String htmlString) /*-{
		$wnd.cordova.plugins.printer.print(htmlString, 'Document.html',
				function() {
					$wnd.alert('printing finished or canceled')
				});
	}-*/;

	public native static void showError() /*-{
		$wnd.alert('not returning boolean')
	}-*/;
	
	public native static Boolean check() /*-{
		var value = true;
		
	return @java.lang.Boolean::valueOf(Z)(value);
}-*/;
}
