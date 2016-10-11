/*
 * charts.js
 *
 * Demo JavaScript used on charts-page.
 */

"use strict";

$(document).ready(function(){

	// easy-pie-charts
	$('.circular-charts-reload').click(function(){
		$('.circular-chart.demo-reload').each(function() {
			var newValue = Math.floor(100*Math.random());
			$(this).data('easyPieChart').update(newValue);
			$('span', this).text(newValue);
		});
	});

});