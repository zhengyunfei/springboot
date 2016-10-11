/*
 * form_components.js
 *
 * Demo JavaScript used on form-pages.
 */

"use strict";

$(document).ready(function(){

	//===== Autocomplete =====//
	// Using typehead.js-library
	$('#autocomplete-example').typeahead({
		name: 'autocomplete-example',
		local: [
			'Alabama','Alaska','Arizona','Arkansas','California','Colorado','Connecticut','Delaware','Florida','Georgia','Hawaii','Idaho','Illinois','Indiana','Iowa','Kansas','Kentucky','Louisiana','Maine','Maryland','Massachusetts','Michigan','Minnesota','Mississippi','Missouri','Montana','Nebraska','Nevada','New Hampshire','New Jersey','New Mexico','New York','North Dakota','North Carolina','Ohio','Oklahoma','Oregon','Pennsylvania','Rhode Island','South Carolina','South Dakota','Tennessee','Texas','Utah','Vermont','Virginia','Washington','West Virginia','Wisconsin','Wyoming'
		]
	});

	//===== Tags =====//
	// @see: for normal tags, see assets/js/plugins.form-components.js (initTags())

	// Custom Tags
	$('.tags-autocomplete').tagsInput({
		width: '100%',
		height: 'auto',
		autocomplete_url: 'assets/js/plugins/tagsinput/tags_autocomplete.html'
	});


	//===== Select2 =====//
	// @see: for default options, see assets/js/plugins.form-components.js (initSelect2())

	// Normal
	$('.select2-select-00').select2({
		allowClear: true
	});

	// Minimal Input Length
	$('.select2-select-01').select2({
		minimumInputLength: 3
	});

	// Tagging Support
	$('.select2-select-02').select2({
		tags: ['Sport', 'Gadget', 'Politics']
	});


	//===== Spinner =====//
	if ($.fn.spinner) {
		$( "#spinner-default" ).spinner();

		$( "#spinner-decimal" ).spinner({
			step: 0.01,
			numberFormat: "n"
		});

		$( "#culture" ).change(function() {
			var current = $( "#spinner-decimal" ).spinner( "value" );
			Globalize.culture( $(this).val() );
			$( "#spinner-decimal" ).spinner( "value", current );
		});

		$( "#currency" ).change(function() {
			$( "#spinner-currency" ).spinner( "option", "culture", $( this ).val() );
		});

		$( "#spinner-currency" ).spinner({
			min: 5,
			max: 2500,
			step: 25,
			start: 1000,
			numberFormat: "C"
		});

		$( "#spinner-overflow" ).spinner({
			spin: function( event, ui ) {
				if ( ui.value > 10 ) {
					$( this ).spinner( "value", -10 );
					return false;
				} else if ( ui.value < -10 ) {
					$( this ).spinner( "value", 10 );
					return false;
				}
			}
		});

		$.widget( "ui.timespinner", $.ui.spinner, {
			options: {
				// seconds
				step: 60 * 1000,
				// hours
				page: 60
			},

			_parse: function( value ) {
				if ( typeof value === "string" ) {
					// already a timestamp
					if ( Number( value ) == value ) {
						return Number( value );
					}
					return +Globalize.parseDate( value );
				}
				return value;
			},

			_format: function( value ) {
				return Globalize.format( new Date(value), "t" );
			}
		});

		$( "#spinner-time" ).timespinner();
		$( "#culture-time" ).change(function() {
			var current = $( "#spinner-time" ).timespinner( "value" );
			Globalize.culture( $(this).val() );
			$( "#spinner-time" ).timespinner( "value", current );
		});

		$( "#spinner-validation" ).spinner();
	}
});
