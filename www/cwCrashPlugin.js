// Empty constructor
function cwCrashPlugin() { }

// The function that passes work along to native shells
// Message is a string, duration may be 'long' or 'short'
cwCrashPlugin.prototype.show = function (message, duration, successCallback, errorCallback) {
    var options = {};
    options.message = message;
    options.duration = duration;
    cordova.exec(successCallback, errorCallback, 'cwCrashPlugin', 'show', [options]);
}

// Installation constructor that binds cwCrashPlugin to window
cwCrashPlugin.install = function () {
    if (!window.plugins) {
        window.plugins = {};
    }
    window.plugins.cwCrashPlugin = new cwCrashPlugin();
    return window.plugins.cwCrashPlugin;
};
cordova.addConstructor(cwCrashPlugin.install);