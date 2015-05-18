var exec = require('cordova/exec');

var MediaVolumePlugin = {
	show: function(successCallback, errorCallback) {
		return exec(
			successCallback, // success callback function
			errorCallback, // error callback function
			'MediaVolumePlugin', // mapped to our native Java class called "CalendarPlugin"
			'openMediaVolume', // with this action name
			[
				// {
				// 	"myVar": myVar // and this array of custom arguments to create our entry
				// }
			]
		); 
	 }
}

module.exports = MediaVolumePlugin;