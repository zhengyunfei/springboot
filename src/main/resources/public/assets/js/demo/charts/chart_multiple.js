/*
 * charts/chart_multiple.js
 *
 * Demo JavaScript used on charts-page for "Multiple Statistics".
 */

"use strict";

$(document).ready(function(){

	// Sample Data
	var data_server_load = [];
	var data_used_ram    = [];

	// Random data for "Server load"
	for (var x = 0; x < 200; x+=5) {
		var y = Math.floor( 50 - 15 + Math.random() * 30 );
		data_server_load.push([x, y]);
	}

	// Random data for "Used RAM"
	function getRandomData() {
		if (data_used_ram.length > 0)
			data_used_ram = data_used_ram.slice(1);

		// do a random walk
		while (data_used_ram.length < 200) {
			var prev = data_used_ram.length > 0 ? data_used_ram[data_used_ram.length - 1] : 50;
			var y = prev + Math.random() * 10 - 5;
			if (y < 0)
			y = 0;
			if (y > 100)
			y = 100;
			data_used_ram.push(y);
		}

		// zip the generated y values with the x values
		var res = [];
		for (var i = 0; i < data_used_ram.length; ++i)
		res.push([i, data_used_ram[i]])
		return res;
	}

	var series_multiple = [
		{
			label: "Used RAM",
			data: getRandomData(),
			color: App.getLayoutColorCode('red'),
			lines: {
				fill: true
			},
			points: {
				show: false
			}
		},{
			label: "Server load",
			data: data_server_load,
			color: App.getLayoutColorCode('blue')
		}
	];

	// Initialize flot
	var plot = $.plot("#chart_multiple", series_multiple, $.extend(true, {}, Plugins.getFlotDefaults(), {
		series: {
			lines: { show: true },
			points: { show: true },
			grow: { active: true }
		},
		grid: {
			hoverable: true,
			clickable: true
		},
		tooltip: true,
		tooltipOpts: {
			content: '%s: %y'
		}
	}));

});