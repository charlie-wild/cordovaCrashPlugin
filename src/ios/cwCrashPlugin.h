// This is the Header file for our plugin class. Objective-C is Apple's own extension
// of the venerable C language to make it object oriented in a different way from the way C++ did it.
// As it's based on C, headers are in a separate class from the code.
// The header basically defines the interface / public method signatures for the plugin class.
// Whether a method in the class is "public" or not depends on whether it is declared in the header.

// We start with a guard against importing the headers twice(!) by wrapping whole thing in a
// #ifndef directive ("if not defined") and then immediately defining the flag we just checked for.
#ifndef cwCrashPlugin_h
#define cwCrashPlugin_h

// Next import the headers of anything we depend on (CDVPlugin is the base class for Cordova plugins in Obj-C)
#import <Cordova/CDVPlugin.h>

// Now declare the interface (public methods) of our plugin.
// It must implement the CDVPlugin base class.
@interface cwCrashPlugin : CDVPlugin

// Declare the signature of our method. Unlike the Android Java implementation which 
// uses an "execute" method with an "action" parameter, the Obj-C implementation has
// actual methods with the name of the action; with input of a CDVInvokedUrlCommand object
// (which contains the input parameters and callback) and returning void.
// The "-" at the start indicates an instance method, as opposed to a static one ("+").
// Note that Obj-C methods have a colon before each argument (we'll see more details of this
// in the .m file)
- (void)CRASH_METHOD:(CDVInvokedUrlCommand*)command;

// Add more methods here if needed

@end  // end of the @interface declaration

#endif  // end of the #ifndef directive
