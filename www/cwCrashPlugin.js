var exec = require('cordova/exec');


exports.myFirstMethod = function (success, error) {
    exec(success, error, 'PluginSample', 'CRASH_METHOD');
};