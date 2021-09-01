/* 
This file creates the Javascript wrappers for our native Cordova actions.

First we require in the Cordova Exec function
which we will use to call our native Cordova actions from Javascript.
*/
var exec = require('cordova/exec');

/* 
Now we can declare our Javascript methods for wrapping the native Cordova actions;
these are declared as exports which will be made available on the "window.plugins.pluginSample" 
object (see the "clobbers" section in plugin.xml)
By convention the Javascript method is named in camelCase and takes two parameters for the
success and error callbacks, followed by any additional parameters. Note that in Javascript these
are untyped, but they will be unwrapped into fixed types in the native code so some discipline is
needed.
The method simply calls the cordova "exec" method imported above, passing in the following arguments:
  * success callback (function to be called if action returns success)
  * error callback (function to be called if action returns failure)
  * Name of the plugin class - here "PluginSample" - which must be matched by the name of the class
    in both iOS and Android implementations
  * Name of the action. Convention is to name this in UPPER_SNAKE_CASE. This will be passed as a
    parameter into the Android plugin; and will match the name of a method in the iOS plugin class.
  * An array containing the parameters. This will be available in the native classes as a
    JSONArray (Android Java) or NSArray (Objective-C)
*/
exports.myFirstMethod = function (success, error, myParameter1, myParameter2) {
    exec(success, error, 'PluginSample', 'MY_FIRST_METHOD', [myParameter1, myParameter2]);
};

// and same again for methods if required