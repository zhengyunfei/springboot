/*
 * charts/chart_simple.js
 *
 * Demo JavaScript used on charts-page for "Simple Chart".
 */

"use strict";

$(document).ready(function(){

	// Sample Data
	var sin = [], cos = [];
	for (var i = 0; i < 16; i += 0.5) {
		sin.push([i, Math.sin(i)]);
		cos.push([i, Math.cos(i)]);
	}

	// Initialize flot
	var plot = $.plot("#chart_simple",
		[{
			data: sin,
			label: "sin(x)"
		},{
			data: cos,
			label: "cos(x)"
		}],

		$.extend(true, {}, Plugins.getFlotDefaults(), {
			series: {
				lines: { show: true },
				points: { show: true },
				grow: { active: true }
			},
			grid: {
				hoverable: true,
				clickable: true
			},
			yaxis: {
				min: -1.1,
				max: 1.1
			},
			xaxis: {
				min: 0,
				max: 15
			},
			tooltip: true,
			tooltipOpts: {
				content: '%s: %y'
			}
		})
	);

});