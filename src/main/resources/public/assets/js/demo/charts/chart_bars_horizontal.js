/*
 * charts/chart_bars_horizontal.js
 *
 * Demo JavaScript used on charts-page for "Horizontal Bars".
 */

"use strict";

$(document).ready(function(){

	// Sample Data
	var d1h = [];
	for (var i = 0; i <= 3; i += 1)
		d1h.push([parseInt(Math.random() * 30), i]);

	var d2h = [];
	for (var i = 0; i <= 3; i += 1)
		d2h.push([parseInt(Math.random() * 30), i]);

	var d3h = [];
	for (var i = 0; i <= 3; i += 1)
		d3h.push([parseInt(Math.random() * 30), i]);

	var ds = new Array();

	ds.push({
		label: "Bar #1",
		data: d1h,
		bars: {
			show: true,
			barWidth: 0.2,
			order: 1
		}
	});
	ds.push({
		label: "Bar #2",
		data: d2h,
		bars: {
			show: true,
			barWidth: 0.2,
			order: 2
		}
	});
	ds.push({
		label: "Bar #3",
		data: d3h,
		bars: {
			show: true,
			barWidth: 0.2,
			order: 3
		}
	});

	// Initialize Chart
	$.plot("#chart_bars_horizontal", ds, $.extend(true, {}, Plugins.getFlotDefaults(), {
		series: {
			lines: { show: false },
			points: { show: false },
			bars: {
				fillColor: { colors: [ { opacity: 1 }, { opacity: 0.7 } ] },
				horizontal: true
			}
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