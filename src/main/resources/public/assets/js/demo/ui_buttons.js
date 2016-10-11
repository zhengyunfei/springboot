/*
 * ui_buttons.js
 *
 * Demo JavaScript used on Buttons-page.
 */

"use strict";

$(document).ready(function(){

	//===== Stateful Buttons =====//

	$('#btn-load').on('click', function() {
		var btn = $(this);
		btn.button('loading');
		setTimeout(function () {
			btn.button('reset')
		}, 1500);
	});
	$('#btn-load-then-complete').on( 'click', function() {
		var btn = $(this);
		btn.button('loading');
		setTimeout(function () {
			btn.button('complete')
		}, 1500);
	});

});