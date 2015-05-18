package com.example.myplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.content.Intent;

public class MediaVolumePlugin extends CordovaPlugin {
	 public static final String ACTION_OPEN_MEDIA_VOLUME = "openMediaVolume";

	 @Override
	 public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
	 	try {
	 		if (ACTION_OPEN_MEDIA_VOLUME.equals(action)) { 
	 		// JSONObject arg_object = args.getJSONObject(0);
	 		
	 		Context context=this.cordova.getActivity().getApplicationContext();
	 		AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	 		audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);

	 		callbackContext.success();
	 		   return true;
	 		}
	 		callbackContext.error("Invalid action");
	 		return false;
	 	} catch(Exception e) {
	 		System.err.println("Exception: " + e.getMessage());
	 		callbackContext.error(e.getMessage());
	 		return false;
	 	} 
	 }
}