// The .m file is the actual implementation logic of our class.
// Apparently .m stands for "methods", though apparently it originally stood for "messages"...

// First we import anything we need. In this case it is just our Header file; anything
// imported by that automatically gets included here. If we needed to import anything else
// for our implementation, that the headers (ie method signatures) don't need to know about,
// we would import them here.
#import "cwCrashPlugin.h"

// We declare what interface we are implementing (the details will be imported from the header file)
@interface cwCrashPlugin ()
@end

// and now for the implementation.
@implementation cwCrashPlugin

// to the calling code (yay async).
- (void)CRASH_METHOD:(CDVInvokedUrlCommand*)command {
            int *a = nil; *a = 0;   
     
}
@end // It's easy to miss this out if you copy and paste.
    // It is the end of the @implementation section we started about 90 lines back.