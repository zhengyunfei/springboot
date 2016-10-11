/*
 * charts/chart_selection_zooming.js
 *
 * Demo JavaScript used on charts-page for "Selection and Zooming".
 */

"use strict";

$(document).ready(function(){

	//===== Sample Data =====//

	// Function for Sample Data
	function getData(x1, x2) {

		var d = [];
		for (var i = 0; i <= 100; ++i) {
			var x = x1 + i * (x2 - x1) / 100;
			d.push([x, Math.sin(x * Math.sin(x))]);
		}

		return [
			{ label: "sin(x sin(x))", data: d }
		];
	}

	var sample_data = getData(0, 3 * Math.PI);

	//===== Main Chart =====//

	// Options for the Main Chart
	var zoomable_chart_options = $.extend(true, {}, Plugins.getFlotDefaults(), {
		legend: {
			show: false
		},
		series: {
			lines: {
				show: true
			},
			points: {
				show: true
			}
		},
		yaxis: {
			ticks: 10
		},
		selection: {
			mode: "x"
		}
	});

	// Creating Main Chart
	var main_chart = $.plot("#chart_selection_zooming", sample_data, zoomable_chart_options);

	//===== Overview Chart =====//

	var overview_chart = $.plot("#chart_selection_zooming_overview", sample_data, $.extend(true, {}, Plugins.getFlotDefaults(), {
		legend: {
			show: false
		},
		series: {
			lines: {
				show: true,
				lineWidth: 1
			},
			shadowSize: 0
		},
		xaxis: {
			ticks: 3
		},
		yaxis: {
			ticks: 1
		},
		selection: {
			mode: "x"
		}
	}));

	//===== Connect the Two =====//

	$("#chart_selection_zooming").bind("plotselected", function (event, ranges) {

		// clamp the zooming to prevent eternal zoom

		if (ranges.xaxis.to - ranges.xaxis.from < 0.00001) {
			ranges.xaxis.to = ranges.xaxis.from + 0.00001;
		}

		if (ranges.yaxis.to - ranges.yaxis.from < 0.00001) {
			ranges.yaxis.to = ranges.yaxis.from + 0.00001;
		}

		// do the zooming

		main_chart = $.plot("#chart_selection_zooming", getData(ranges.xaxis.from, ranges.xaxis.to),
			$.extend(true, {}, zoomable_chart_options, {
				xaxis: { min: ranges.xaxis.from, max: ranges.xaxis.to },
				yaxis: { min: ranges.yaxis.from, max: ranges.yaxis.to }
			})
		);

		// don't fire event on the overview to prevent eternal loop

		overview_chart.setSelection(ranges, true);
	});

	$("#chart_selection_zooming_overview").bind("plotselected", function (event, ranges) {
		main_chart.setSelection(ranges);
	});

});