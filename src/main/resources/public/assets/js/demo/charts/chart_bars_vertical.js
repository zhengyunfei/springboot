/*
 * charts/chart_bars_vertical.js
 *
 * Demo JavaScript used on charts-page for "Vertical Bars".
 */

"use strict";

$(document).ready(function(){

	// Sample Data
	var d1 = [];
	for (var i = 0; i <= 7; i += 1)
		d1.push([i, parseInt(Math.random() * 30)]);

	var d2 = [];
	for (var i = 0; i <= 7; i += 1)
		d2.push([i, parseInt(Math.random() * 30)]);

	var d3 = [];
	for (var i = 0; i <= 7; i += 1)
		d3.push([i, parseInt(Math.random() * 30)]);

	var ds = new Array();

	ds.push({
		label: "Bar #1",
		data: d1,
		bars: {
			show: true,
			barWidth: 0.2,
			order: 1
		}
	});
	ds.push({
		label: "Bar #2",
		data: d2,
		bars: {
			show: true,
			barWidth: 0.2,
			order: 2
		}
	});
	ds.push({
		label: "Bar #3",
		data: d3,
		bars: {
			show: true,
			barWidth: 0.2,
			order: 3
		}
	});

	// Initialize Chart
	$.plot("#chart_bars_vertical", ds, $.extend(true, {}, Plugins.getFlotDefaults(), {
		series: {
			lines: { show: false },
			points: { show: false }
		},
		grid:{
			hoverable: true
		},
		tooltip: true,
		tooltipOpts: {
			content: '%s: %y'
		}
	}));

});