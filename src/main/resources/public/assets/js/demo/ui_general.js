/*
 * general_ui.js
 *
 * Demo JavaScript used on General UI-page.
 */

"use strict";

$(document).ready(function(){

	//===== Date Pickers & Time Pickers & Color Pickers =====//
	$( ".datepicker" ).datepicker({
		defaultDate: +7,
		showOtherMonths:true,
		autoSize: true,
		appendText: '<span class="help-block">(dd-mm-yyyy)</span>',
		dateFormat: 'dd-mm-yy'
		});

	$('.inlinepicker').datepicker({
		inline: true,
		showOtherMonths:true
	});

	$('.datepicker-fullscreen').pickadate();
	$('.timepicker-fullscreen').pickatime();

	// Color Picker
	var bodyStyle = $('body')[0].style;
	$('#colorpicker-event').colorpicker().on('changeColor', function(ev) {
		bodyStyle.backgroundColor = ev.color.toHex();
	});

	//===== Notifications =====//
	// @see: for default options, see assets/js/plugins.js (initNoty())

	$('.btn-notification').click(function() {
		var self = $(this);

		noty({
			text: self.data('text'),
			type: self.data('type'),
			layout: self.data('layout'),
			timeout: 2000,
			modal: self.data('modal'),
			buttons: (self.data('type') != 'confirm') ? false : [
				{
					addClass: 'btn btn-primary', text: 'Ok', onClick: function($noty) {
						$noty.close();
						noty({force: true, text: 'You clicked "Ok" button', type: 'success', layout: self.data('layout')});
					}
				}, {
					addClass: 'btn btn-danger', text: 'Cancel', onClick: function($noty) {
						$noty.close();
						noty({force: true, text: 'You clicked "Cancel" button', type: 'error', layout: self.data('layout')});
					}
				}
			]
		});

		return false;
	});

	//===== Slim Progress Bars (nprogress) =====//
	$('.btn-nprogress-start').click(function () {
		NProgress.start();
		$('#nprogress-info-msg').slideDown(200);
	});

	$('.btn-nprogress-set-40').click(function () {
		NProgress.set(0.4);
	});

	$('.btn-nprogress-inc').click(function () {
		NProgress.inc();
	});

	$('.btn-nprogress-done').click(function () {
		NProgress.done();
		$('#nprogress-info-msg').slideUp(200);
	});

	//===== Bootbox (Modals and Dialogs) =====//
	$("a.basic-alert").click(function(e) {
		e.preventDefault();
		bootbox.alert("Hello world!", function() {
			console.log("Alert Callback");
		});
	});

	$("a.confirm-dialog").click(function(e) {
		e.preventDefault();
		bootbox.confirm("Are you sure?", function(confirmed) {
			console.log("Confirmed: "+confirmed);
		});
	});

	$("a.multiple-buttons").click(function(e) {
		e.preventDefault();
		bootbox.dialog({
			message: "I am a custom dialog",
			title: "Custom title",
			buttons: {
				success: {
					label: "Success!",
					className: "btn-success",
					callback: function() {
						console.log("great success");
					}
				},
				danger: {
					label: "Danger!",
					className: "btn-danger",
					callback: function() {
						console.log("uh oh, look out!");
					}
				},
				main: {
					label: "Click ME!",
					className: "btn-primary",
					callback: function() {
						console.log("Primary button");
					}
				}
			}
		});
	});

	$("a.multiple-dialogs").click(function(e) {
		e.preventDefault();

		bootbox.alert("Prepare for multiboxes in 1 second...");

		setTimeout(function() {
			bootbox.dialog({
				message: "Do you like Melon?",
				title: "Fancy Title",
				buttons: {
					danger: {
						label: "No :-(",
						className: "btn-danger",
						callback: function() {
							bootbox.alert("Aww boo. Click the button below to get rid of all these popups.", function() {
								bootbox.hideAll();
							});
						}
					},
					success: {
						label: "Oh yeah!",
						className: "btn-success",
						callback: function() {
							bootbox.alert("Glad to hear it! Click the button below to get rid of all these popups.", function() {
								bootbox.hideAll();
							});
						}
					}
				}
			});
		}, 1000);
	});

	$("a.programmatic-close").click(function(e) {
		e.preventDefault();
		var box = bootbox.alert("This dialog will automatically close in two seconds...");
		setTimeout(function() {
			box.modal('hide');
		}, 2000);
	});

});