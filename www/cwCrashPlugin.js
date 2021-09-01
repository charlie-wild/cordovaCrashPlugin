var exec = require('cordova/exec');


exports.myFirstMethod = function (success, error) {
    exec(success, error, 'cwCrashPlugin', 'CRASH_METHOD');
};