package com.mobile.push.client;

public class ToastJsni {

	public native static void showToast(String msg) /*-{

		$wnd.plugins.toast.showWithOptions({
			message : msg,
			duration : "short",
			position : "bottom"
		}
		);

	}-*/;

}
