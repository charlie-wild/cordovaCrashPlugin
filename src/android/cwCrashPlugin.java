// declare the name of the Java package our plugin resides in.
// This is typically lowercase and in reverse-URL format.
package com.thinkmoney.cordova.plugins.pluginsample;

// Next import external types that we depend on.
// The four included here are always going to be needed for any Cordova plugin.
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
// The above three lines could have been replaced by "import org.apache.cordova.*;" but
// it is generally considered to import only what you want (unless this gets unwieldy)
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
        // We should always wrap the code in our execute method in a try/catch to ensure
        // no unhandled error gets thrown. 
        try {
            // Typically we will do different things based on the action passed in, and
            // make assumptions about the number and type of items in the arg array.
            // Unless these are trivially simple we should abstract these into separate
            // methods, into which we pass the callback context (so we can return results)
            // and our unwrapped parameters.
            // (In some more complex plugins it may be better to save the callback context in
            // an instance field rather than passing it through long chains of methods.)
            switch(action) {
                case "MY_FIRST_METHOD":
                    // Here we expect to have 2 argments in our array - a string and an int.
                    runMyFirstMethod(callbackContext, args.getString(0), args.getInt(1));

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
        catch(Throwable e) {
            // Throwable is the superclass of all errors/exceptions in Java so catching it
            // guarantees no errors will go unhandled. Typically we'd just return the error
            // message, as we do here, though it's possible to be more sophisticated and
            // return a JSON object containing more info, stack trace etc.

            // "error" is a helper method on CallbackContext that returns a PluginResult
            // with status "ERROR" and some value. The value can be a string, int or JSONObject.
            callbackContext.error(e.toString());

            // Return false as there was something wrong with the input
            return false;
        }
    }

    // So here's the method that actually handles our action. We passed the callbackContext through
    // so we can send a result to the calling code (yay for asynchronous).
    private void runMyFirstMethod(CallbackContext callbackContext, String firstParameter, int secondParameter){
        try {
            // This is a sample so we won't do anything sophisticated. Just return a success result
            // containing a formatted string.
            String result = String.format("You submitted parameters '%s' and %d", 
                firstParameter, secondParameter);
            
            // "success" is a helper method on the CallbackContext that sends a PluginResult
            // with status "OK" and some value. The value can be a string, int, byte array,
            // JSONArray or JSONObject - or indeed nothing at all if all you need is to indicate success.
            callbackContext.success(result);
        } catch(IllegalFormatException e) {
            // "error" is a helper method that returns a PluginResult with status "ERROR" and
            // some value. The value can be a string, int or JSONObject.
            callbackContext.error(e.toString());
            return false;
        }
        
        // Note that Java's error handling syntax rules mean that any expected exception type
        // that can be thrown by methods we call, must be either handled by this method or
        // else declared on the method signature.
        // If we removed the "try/catch" in this method we would need to update the method
        // signature to: 
        
        // private void runMyFirstMethod(CallbackContext callbackContext, String firstParameter, int secondParameter) throws IllegalFormatException {

        // This would be OK as the outer "execute" method catches all Throwables.
    }
}