/*
 * charts/chart_updating.js
 *
 * Demo JavaScript used on charts-page for "Auto Updating Chart".
 */

"use strict";

$(document).ready(function(){

	// We use an inline data source in the example, usually data would be fetched from a server
	var data = [], totalPoints = 200;

	function getRandomData() {
		if (data.length > 0)
			data = data.slice(1);

		// do a random walk
		while (data.length < totalPoints) {
			var prev = data.length > 0 ? data[data.length - 1] : 50;
			var y = prev + Math.random() * 10 - 5;
			if (y < 0)
			y = 0;
			if (y > 100)
			y = 100;
			data.push(y);
		}

		// zip the generated y values with the x values
		var res = [];
		for (var i = 0; i < data.length; ++i)
		res.push([i, data[i]])
		return res;
	}

	// Initialize Plot
	var plot = $.plot("#chart_updating", [ getRandomData() ], $.extend(true, {}, Plugins.getFlotDefaults(), {
		yaxis: { min: 0, max: 100 },
		xaxis: { min: 0, max: 100 },
		series: {
			lines: {
				lineWidth: 1.5,
				fill: true
			}
		}
	}));

	function update() {
		plot.setData([ getRandomData() ]);
		// since the axes don't change, we don't need to call plot.setupGrid()
		plot.draw();

		setTimeout(update, 250);
	}

	update();
});