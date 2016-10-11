/*
 * charts/chart_pie.js
 *
 * Demo JavaScript used on charts-page for "Pie Chart".
 */

"use strict";

$(document).ready(function(){

	// Sample Data
	var d_pie = [];
	var series = Math.floor(Math.random()*10)+1;
	for (var i = 0; i<series; i++) {
		d_pie[i] = { label: "Series "+(i+1), data: Math.floor(Math.random()*100)+1 }
	}

	$.plot("#chart_pie", d_pie, $.extend(true, {}, Plugins.getFlotDefaults(), {
		series: {
			pie: {
				show: true,
				radius: 1,
				label: {
					show: true
				}
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