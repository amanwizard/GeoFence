package com.mobile.push.client;

public class CameraJsni {

	

	public native void takePic() /*-{

		$wnd.navigator.camera.getPicture(onSuccess, onFail, {
			quality : 50,
			destinationType : $wnd.navigator.camera.DestinationType.FILE_URI
		});

		function onSuccess(imageData) {
			var imageSrc = "data:image/jpeg;base64," + imageData;
			
			alert('alert:  ' + imageSrc);
			console.log(imageSrc);
		}

		function onFail(message) {
			alert('Failed because: ' + message);
		}
	}-*/;

	

}
