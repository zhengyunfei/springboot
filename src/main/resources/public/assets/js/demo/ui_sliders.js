/*
 * ui_sliders.js
 *
 * Demo JavaScript used on Sliders-page.
 */

"use strict";

$(document).ready(function(){
	// Default slider
	$( '#slider-default' ).slider();

	// Snap to increments
	$( '#slider-snap-inc' ).slider({
		value: 100,
		min: 0,
		max: 500,
		step: 50,
		slide: function( event, ui ) {
			$( '#slider-snap-inc-amount' ).text( '$' + ui.value );
		}
	});
	$('#slider-snap-inc-amount').text('$' + $('#slider-snap-inc').slider('value'));

	// Range slider
	$( '#slider-range' ).slider({
		range: true,
		min: 0,
		max: 500,
		values: [ 75, 300 ],
		slide: function( event, ui ) {
			$( '#slider-range-amount' ).text( '$' + ui.values[ 0 ] + ' - $' + ui.values[ 1 ] );
		}
	});
	$( '#slider-range-amount' ).text( '$' + $( '#slider-range' ).slider( 'values', 0 ) + ' - $' + $( '#slider-range' ).slider( 'values', 1 ) );

	// Range with fixed minimum
	$( '#slider-range-min' ).slider({
		range: 'min',
		value: 37,
		min: 1,
		max: 700,
		slide: function( event, ui ) {
			$( '#slider-range-min-amount' ).text( '$' + ui.value );
		}
	});
	$('#slider-range-min-amount').text('$' + $('#slider-range-min').slider('value'));

	// Range with fixed maximum
	$( '#slider-range-max' ).slider({
		range: 'max',
		min: 1,
		max: 700,
		value: 300,
		slide: function( event, ui ) {
			$( '#slider-range-max-amount' ).text( '$' + ui.value );
		}
	});
	$('#slider-range-max-amount').text('$' + $('#slider-range-max').slider('value'));

	// Multiple vertical sliders
	$('#slider-vertical-multiple > span').each(function () {
		// read initial values from markup and remove that
		var value = parseInt($(this).text(), 10);
		$(this).empty().slider({
			value: value,
			range: 'min',
			animate: true,
			orientation: 'vertical'
		});
	});

	// Vertical range with fixed minimum
	$( '#slider-vertical-range-min' ).slider({
		range: 'min',
		value: 500,
		min: 1,
		max: 700,
		orientation: 'vertical',
		slide: function( event, ui ) {
			$( '#slider-vertical-range-min-amount' ).text( '$' + ui.value );
		}
	});
	$('#slider-vertical-range-min-amount').text('$' + $('#slider-vertical-range-min').slider('value'));
});