/*
 * charts/chart_donut.js
 *
 * Demo JavaScript used on charts-page for "Donut Chart".
 */

"use strict";

$(document).ready(function(){

	// Sample Data
	var d_donut = [];
	var series = Math.floor(Math.random()*10)+1;
	for (var i = 0; i<series; i++) {
		d_donut[i] = { label: "Series "+(i+1), data: Math.floor(Math.random()*100)+1 }
	}

	$.plot("#chart_donut", d_donut, $.extend(true, {}, Plugins.getFlotDefaults(), {
		series: {
			pie: {
				show: true,
				innerRadius: 0.5,
				radius: 1
			}
		},
		grid: {
			hoverable: true
		},
		tooltip: true,
		tooltipOpts: {
			content: '%p.0%, %s', // show percentages, rounding to 2 decimal places
			shifts: {
				x: 20,
				y: 0
			}
		}
	}));

});