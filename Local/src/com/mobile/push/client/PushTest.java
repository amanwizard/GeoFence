package com.mobile.push.client;

import java.util.Date;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;
import com.googlecode.gwtphonegap.client.event.BackButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.BackButtonPressedHandler;
import com.googlecode.gwtphonegap.client.event.OffLineEvent;
import com.googlecode.gwtphonegap.client.event.OffLineHandler;
import com.googlecode.gwtphonegap.client.event.OnlineEvent;
import com.googlecode.gwtphonegap.client.event.OnlineHandler;
import com.googlecode.gwtphonegap.client.event.VolumeDownButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.VolumeDownButtonPressedHandler;
import com.googlecode.gwtphonegap.client.event.VolumeUpButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.VolumeUpButtonPressedHandler;
import com.googlecode.gwtphonegap.client.notification.AlertCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PushTest implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private final PhoneGap phoneGap = GWT.create(PhoneGap.class);
	private Logger logger = Logger.getLogger(getClass().getName());

	// private final PhoneGap push=GWT.create(.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button notifyButton = new Button("Notify");
		final TextBox nameField = new TextBox();
		final TextBox pushNotificationField = new TextBox();
		pushNotificationField.getElement().setId("regId");
		final Button sendPushNotificationButton = new Button(
				"Send Push Notification");
		final Button printerService = new Button("Check print service");
		final Button print = new Button("print");
		final Button toast = new Button("toast");
		final Button scan = new Button("scan");
		final Button sms = new Button("sms");
		final Button smsList = new Button("sms list");
		final Button alert = new Button("alert");
		final Button spinnerButton = new Button("Spinner");
		final Anchor whatsapp = new Anchor("whatsapp");
		final Button nfc = new Button("NFC");
		final Button writeNfc = new Button("NFC");
		final Button autoStart = new Button("AutoStart");
		final TextBox amount=new TextBox();
		
		final Button saveData = new Button("saveData");
		final Button getData = new Button("getData");
		final Button removeData = new Button("removeData");
		
		
		
		//for camera
	//	final Button cameraButton = new Button("Open Camera");

	//	nameField.setText("GWT User");
		final Label errorLabel = new Label();

		final HTMLPanel html = new HTMLPanel(
				"<div id="
						+ "neeraj"
						+ ">hey neeraj how are you </br> whats the plan for tonight <div>");
		
		
		

		phoneGap.addHandler(new PhoneGapAvailableHandler() {

			@Override
			public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
				errorLabel.setText("Phonegap available");

			}
		});

		phoneGap.addHandler(new PhoneGapTimeoutHandler() {

			@Override
			public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
				errorLabel.setText("Phonegap not available");

			}
		});

		errorLabel.setText("initing Phonegap");
		phoneGap.initializePhoneGap();
		RootPanel.get("errorLabelContainer").add(errorLabel);

		RootPanel.get("sendButtonContainer").add(saveData);
		RootPanel.get("sendButtonContainer").add(getData);
		RootPanel.get("sendButtonContainer").add(removeData);
		RootPanel.get("sendButtonContainer").add(nfc);
		
		
		nfc.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			ToastJsni.showToast("device name is "+phoneGap.getDevice().getModel());
				
			}
		});
		
		
		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
	/*	
		whatsapp.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String whatsappOpener="whatsapp://send?text=";
				whatsapp.setHref(whatsappOpener+" Hello Neeraj");
			}
		});

		
		*/
		
		saveData.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AndroidSharedPrefrenceJSNI.store("ID", "1234567890");
			}
		});
		getData.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					String fetch = AndroidSharedPrefrenceJSNI.getValue("ID");
					AndroidSharedPrefrenceJSNI.showAleart(fetch);
				}
			});
		removeData.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AndroidSharedPrefrenceJSNI.remove("ID");
			}
		});
		
		phoneGap.getEvent().getOffLineHandler()
				.addOfflineHandler(new OffLineHandler() {

					@Override
					public void onOffLine(OffLineEvent event) {
						NetworkConnection.hideBody();
					}
				});

		phoneGap.getEvent().getOnlineHandler()
				.addOnlineHandler(new OnlineHandler() {

					@Override
					public void onOnlineEvent(OnlineEvent event) {
						NetworkConnection.showBody();

					}
				});

		phoneGap.getEvent()
				.getVolumeUpButtonPressedHandler()
				.addVolumeUpButtonPressedHandler(
						new VolumeUpButtonPressedHandler() {

							@Override
							public void onVolumeUpButtonPressed(
									VolumeUpButtonPressedEvent event) {
								Window.alert("volume up");
							}
						});
		phoneGap.getEvent()
				.getVolumeDownButtonPressedHandler()
				.addVolumeDownButtonPressedHandler(
						new VolumeDownButtonPressedHandler() {

							@Override
							public void onVolumeDownButtonPressed(
									VolumeDownButtonPressedEvent event) {
								NativeSpinner.hide();

							}
						});

		phoneGap.getEvent().getBackButton()
				.addBackButtonPressedHandler(new BackButtonPressedHandler() {

					@Override
					public void onBackButtonPressed(BackButtonPressedEvent event) {
						Window.alert("Back Button");
					}
				});

	}
	
	

}
