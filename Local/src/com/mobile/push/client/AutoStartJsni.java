package com.mobile.push.client;

public class AutoStartJsni {

	public native static void init()/*-{

		$wnd.cordova.plugins.autoStart.enable();

		console.log('AutoStart enable');

	}-*/;

}
