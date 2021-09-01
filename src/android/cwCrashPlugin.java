// declare the name of the Java package our plugin resides in.
// This is typically lowercase and in reverse-URL format.
package com.charliwild.cordova.plugin.cwCrashPlugin;


import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;

// Now we declare our plugin class. It must match the name of the file, be in Pascal case
// (aka UpperCamelCase), and extend the CordovaPlugin class.
public class PluginSample extends CordovaPlugin {
    
    // Every implementation of CordovaPlugin has an "execute" method. 
    // This has the following parameters:
    // * action: the name of the action passed in from the javascript (eg MY_FIRST_METHOD)
    // * args: a JSONArray containing the parameter values passed in
    // * callbackContext: a Cordova object used to send results back to the calling application
    //   (as Cordova plugin methods are asynchronous by nature).
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {        
               switch(action) {
                case "CRASH_METHOD":                   
                    runCrash(callbackContext);
                    // We return true to indicate that the action was successfully started,
                    // even if this later returns an error result.
                    return true;
                default:
                    // We should always have a catch-all in case some numpty calls our cordova
                    // action with the wrong action name.
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
                    // Return false as there was something wrong with the input
                    return false;
            }              
    }

    // So here's the method that actually handles our action. We passed the callbackContext through
    // so we can send a result to the calling code (yay for asynchronous).
    private void runCrash(CallbackContext callbackContext){       
            int a[] = new int[5];
            a[5] = 30/0;  
            callbackContext.success();          
   
}