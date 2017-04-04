package com.mobile.push.client;

public class AndroidSharedPrefrenceJSNI {

	public native static void store(String key, String value) /*-{
		var store = null;
		$wnd.plugins.appPreferences.store(function(value) {
			store = value;
		}, function(error) {
			store = error;
		}, key, value);
	}-*/;

	interface CallBack {
		void onSuccess(String value);

		void onFailure(String value);
	}

	private static String store;
	static boolean executed = false;

	public static String getValue(final String key) {

		store = null;

		executed = false;

		fetch(key, new CallBack() {
			@Override
			public void onSuccess(String value) {
				store = value;
				showAleart("on success");
				executed = true;
			}

			@Override
			public void onFailure(String value) {
				store = value;
				showAleart("on Failure");
				executed = true;
			}
		});
		
		while(!executed){
			
		}
		
		return store;
	}

	public native static void fetch(String key, CallBack callBack) /*-{
		$wnd.plugins.appPreferences
				.fetch(
						function(value) {
							callBack.@com.mobile.push.client.AndroidSharedPrefrenceJSNI.CallBack::onSuccess(Ljava/lang/String;)(value);
						},
						function(error) {
							callBack.@com.mobile.push.client.AndroidSharedPrefrenceJSNI.CallBack::onFailure(Ljava/lang/String;)(error);
						}, key);
	}-*/;

	public native static void remove(String key) /*-{
		var store = null;
		$wnd.plugins.appPreferences.remove(function(value) {
			store = value;
		}, function(error) {
			store = error;
		}, key);
	}-*/;

	public native static String showAleart(String value) /*-{
		alert('value: ' + value);
	}-*/;

}
