/*
 * charts/chart_filled_green.js
 *
 * Demo JavaScript used on charts-page for "Filled Chart (Green)".
 */

"use strict";

$(document).ready(function(){

	// Sample Data
	var d1 = [[1262304000000, 17], [1264982400000, 600], [1267401600000, 1200], [1270080000000, 1000], [1272672000000, 2000], [1275350400000, 2300], [1277942400000, 2700], [1280620800000, 2000], [1283299200000, 1300], [1285891200000, 1000], [1288569600000, 2300], [1291161600000, 2000]];

	var data1 = [
		{ label: "全部点击", data: d1, color: App.getLayoutColorCode('green') }
	];

	$.plot("#chart_filled_green", data1, $.extend(true, {}, Plugins.getFlotDefaults(), {
		xaxis: {
			min: (new Date(2009, 12, 1)).getTime(),
			max: (new Date(2010, 11, 2)).getTime(),
			mode: "time",
			tickSize: [1, "month"],
			monthNames: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
			tickLength: 0
		},
		series: {
			lines: {
				fill: true,
				lineWidth: 1.5
			},
			points: {
				show: true,
				radius: 2.5,
				lineWidth: 1.1
			}
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