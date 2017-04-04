package com.mobile.push.client;


public class NativeSpinner {
	
	public native static void init() /*-{
		$wnd.plugins.spinnerDialog.show(null,"hi neeraj",true);
	}-*/;
	
	public native static void hide() /*-{
		$wnd.plugins.spinnerDialog.hide();
	}-*/;
	
}
