/**
 * Core script to handle plugins
 */

var Plugins = function() {

	"use strict";

	/**
	 * $.browser for jQuery 1.9
	 */
	var initBrowserDetection = function() {
		$.browser={};(function(){$.browser.msie=false;
		$.browser.version=0;if(navigator.userAgent.match(/MSIE ([0-9]+)\./)){
		$.browser.msie=true;$.browser.version=RegExp.$1;}})();
	}

	/**
	 * Daterangepicker
	 */
	var initDaterangepicker = function() {
		if ($.fn.daterangepicker) {
			$('.range').daterangepicker({
				startDate: moment().subtract('days', 29),
				endDate: moment(),
				minDate: '01/01/2012',
				maxDate: '12/31/2014',
				dateLimit: { days: 60 },
				showDropdowns: true,
				showWeekNumbers: true,
				timePicker: false,
				timePickerIncrement: 1,
				timePicker12Hour: true,
				ranges: {
				   'Today': [moment(), moment()],
				   'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
				   'Last 7 Days': [moment().subtract('days', 6), moment()],
				   'Last 30 Days': [moment().subtract('days', 29), moment()],
				   'This Month': [moment().startOf('month'), moment().endOf('month')],
				   'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
				},
				opens: 'left',
				buttonClasses: ['btn btn-default'],
				applyClass: 'btn-sm btn-primary',
				cancelClass: 'btn-sm',
				format: 'MM/DD/YYYY',
				separator: ' to ',
				locale: {
					applyLabel: 'Submit',
					fromLabel: 'From',
					toLabel: 'To',
					customRangeLabel: 'Custom Range',
					daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr','Sa'],
					monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
					firstDay: 1
				}
			},

			function (start, end) {
				var range_updated = start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY');

				App.blockUI($("#content"));
				setTimeout(function () {
					App.unblockUI($("#content"));
					noty({
						text: '<strong>Dashboard updated to ' + range_updated + '.</strong>',
						type: 'success',
						timeout: 1000
					});
					//App.scrollTo();
				}, 1000);

				$('.range span').html(range_updated);
			});

			$('.range span').html(moment().subtract('days', 29).format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
		}
	}

	/**
	 * Sparklines
	 */
	var initSparklines = function() {
		if ($.fn.sparkline) {
			// Set default options
			$.extend(true, $.fn.sparkline.defaults, {
				line: {
					highlightSpotColor: App.getLayoutColorCode('green'),
					highlightLineColor: App.getLayoutColorCode('red')
				},
				bar: {
					barColor: App.getLayoutColorCode('blue'),
					negBarColor: App.getLayoutColorCode('red'),
					barWidth: 5,
					barSpacing: 2
				},
				tristate: {
					posBarColor: App.getLayoutColorCode('green'),
					negBarColor: App.getLayoutColorCode('red')
				},
				box: {
					medianColor: App.getLayoutColorCode('red')
				}
			});

			$(window).resize(function () {
				$.sparkline_display_visible();
			}).resize();

			// Initialize statbox sparklines
			$('.statbox-sparkline').each(function () {
				$(this).sparkline('html', Plugins.getSparklineStatboxDefaults());
			})
		}
	}

	/**************************
	 * Tooltips               *
	 **************************/
	var initTooltips = function() {
		// Set default options

		// TODO: $.extend does not work since BS3!

		// This fixes issue #5865
		// (When using tooltips and popovers with the Bootstrap input groups,
		// you'll have to set the container option to avoid unwanted side effects.)
		$.extend(true, $.fn.tooltip.defaults, {
			container: 'body'
		});

		$('.bs-tooltip').tooltip({
			container: 'body'
		});
		$('.bs-focus-tooltip').tooltip({
			trigger: 'focus',
			container: 'body'
		});
	}

	/**************************
	 * Popovers               *
	 **************************/
	var initPopovers = function() {
		$('.bs-popover').popover();
	}

	/**************************
	 * Noty                   *
	 **************************/
	var initNoty = function() {
		if ($.noty) {
			// Set default options
			$.extend(true, $.noty.defaults, {
				type: 'alert',
				timeout: false,
				maxVisible: 5,
				animation: {
					open: {
						height:'toggle'
					},
					close: {
						height:'toggle'
					},
					easing: 'swing',
					speed: 200
				}
			});
		}
	}

	/**************************
	 * Easy Pie Chart         *
	 **************************/
	var initCircularCharts = function() {
		if ($.easyPieChart) {
			// Set default options
			$.extend(true, $.easyPieChart.defaultOptions, {
				lineCap: 'butt',
				animate: 500,
				barColor: App.getLayoutColorCode('blue')
			});

			// Initialize defaults
			$('.circular-chart').easyPieChart({
				size: 110,
				lineWidth: 10
			});
		}
	}

	/**************************
	 * DataTables             *
	 **************************/
	var initDataTables = function() {
		if ($.fn.dataTable) {
			// Set default options
			$.extend(true, $.fn.dataTable.defaults, {
				"oLanguage": {
					"sSearch": ""
				},
				"sDom": "<'row'<'dataTables_header clearfix'<'col-md-6'l><'col-md-6'f>r>>t<'row'<'dataTables_footer clearfix'<'col-md-6'i><'col-md-6'p>>>",
				// set the initial value
				"iDisplayLength": 5,
				fnDrawCallback: function () {
					if ($.fn.uniform) {
						$(':radio.uniform, :checkbox.uniform').uniform();
					}

					if ($.fn.select2) {
						$('.dataTables_length select').select2({
							minimumResultsForSearch: "-1"
						});
					}

					// SEARCH - Add the placeholder for Search and Turn this into in-line formcontrol
					var search_input = $(this).closest('.dataTables_wrapper').find('div[id$=_filter] input');

					// Only apply settings once
					if (search_input.parent().hasClass('input-group')) return;

					//search_input.attr('placeholder', 'Search')
					search_input.addClass('form-control')
					search_input.wrap('<div class="input-group"></div>');
					search_input.parent().prepend('<span class="input-group-addon"><i class="icon-search"></i></span>');
					//search_input.parent().prepend('<span class="input-group-addon"><i class="icon-search"></i></span>').css('width', '250px');

					// Responsive
					/*if (typeof responsiveHelper != 'undefined') {
						responsiveHelper.respond();
					}*/
				}
			});

			$.fn.dataTable.defaults.aLengthMenu = [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]];

			// Initialize default datatables
			$('.datatable').each(function () {
				var self = $(this);
				var options = {};

				/*
				 * Options via data-attribute
				 */

				// General Wrapper
				var data_dataTable = self.data('datatable');
				if (typeof data_dataTable != 'undefined') {
					$.extend(true, options, data_dataTable);
				}

				// Display Length
				var data_displayLength = self.data('displayLength');
				if (typeof data_displayLength != 'undefined') {
					$.extend(true, options, {
						"iDisplayLength": data_displayLength
					});
				}

				// Horizontal Scrolling
				var data_horizontalWidth = self.data('horizontalWidth');
				if (typeof data_horizontalWidth != 'undefined') {
					$.extend(true, options, {
						"sScrollX": "100%",
						"sScrollXInner": data_horizontalWidth,
						"bScrollCollapse": true
					});
				}

				/*
				 * Other
				 */

				// Checkable Tables
				if (self.hasClass('table-checkable')) {
					$.extend(true, options, {
						'aoColumnDefs': [
							{ 'bSortable': false, 'aTargets': [0] }
						]
					});
				}

				// TableTools
				if (self.hasClass('table-tabletools')) {
					$.extend(true, options, {
						"sDom": "<'row'<'dataTables_header clearfix'<'col-md-4'l><'col-md-8'Tf>r>>t<'row'<'dataTables_footer clearfix'<'col-md-6'i><'col-md-6'p>>>", // T is new
						"oTableTools": {
							"aButtons": [
								"copy",
								"print",
								"csv",
								"xls",
								"pdf"
							],
							"sSwfPath": "plugins/datatables/tabletools/swf/copy_csv_xls_pdf.swf"
						}
					});
				}

				// ColVis
				if (self.hasClass('table-colvis')) {
					$.extend(true, options, {
						"sDom": "<'row'<'dataTables_header clearfix'<'col-md-6'l><'col-md-6'Cf>r>>t<'row'<'dataTables_footer clearfix'<'col-md-6'i><'col-md-6'p>>>", // C is new
						"oColVis": {
							"buttonText": "Columns <i class='icon-angle-down'></i>",
							"iOverlayFade": 0
						}
					});
				}

				// If ColVis is used with checkable Tables
				if (self.hasClass('table-checkable') && self.hasClass('table-colvis')) {
					$.extend(true, options, {
						"oColVis": {
							"aiExclude": [0]
						}
					});
				}

				// Responsive Tables
				if (self.hasClass('table-responsive')) {
					var responsiveHelper;
					var breakpointDefinition = {
						tablet: 1024,
						phone: 480
					};

					// Preserve old function from $.extend above
					// to extend a function
					var old_fnDrawCallback = $.fn.dataTable.defaults.fnDrawCallback;

					$.extend(true, options, {
						bAutoWidth: false,
						fnPreDrawCallback: function () {
							// Initialize the responsive datatables helper once.
							if (!responsiveHelper) {
								responsiveHelper = new ResponsiveDatatablesHelper(this, breakpointDefinition);
							}
						},
						fnRowCallback: function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {
							responsiveHelper.createExpandIcon(nRow);
						},
						fnDrawCallback: function (oSettings) {
							// Extending function
							old_fnDrawCallback.apply(this, oSettings);

							responsiveHelper.respond();
						}
					});
				}

				$(this).dataTable(options);
			});
		}
	}

	/**************************
	 * Flot Defaults          *
	 **************************/
	var defaultPlotOptions = {
		colors: [App.getLayoutColorCode('blue'), App.getLayoutColorCode('red'), App.getLayoutColorCode('green'), App.getLayoutColorCode('purple'), App.getLayoutColorCode('grey'), App.getLayoutColorCode('yellow')],
		legend: {
			show: true,
			labelBoxBorderColor: "", // border color for the little label boxes
			backgroundOpacity: 0.95 // set to 0 to avoid background
		},
		series: {
			points: {
				show: false,
				radius: 3,
				lineWidth: 2, // in pixels
				fill: true,
				fillColor: "#ffffff",
				symbol: "circle" // or callback
			},
			lines: {
				// we don't put in show: false so we can see
				// whether lines were actively disabled
				show: true,
				lineWidth: 2, // in pixels
				fill: false,
				fillColor: { colors: [ { opacity: 0.4 }, { opacity: 0.1 } ] },
			},
			bars: {
				lineWidth: 1, // in pixels
				barWidth: 1, // in units of the x axis
				fill: true,
				fillColor: { colors: [ { opacity: 0.7 }, { opacity: 1 } ] },
				align: "left", // or "center"
				horizontal: false
			},
			pie: {
				show: false,
				radius: 1,
				label: {
					show: false,
					radius: 2/3,
					formatter: function(label, series){
						return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;text-shadow: 0 1px 0 rgba(0, 0, 0, 0.6);">'+label+'<br/>'+Math.round(series.percent)+'%</div>';
					},
					threshold: 0.1
				}
			},
			shadowSize: 0
		},
		grid: {
			show: true,
			borderColor: "#efefef", // set if different from the grid color
			tickColor: "rgba(0,0,0,0.06)", // color for the ticks, e.g. "rgba(0,0,0,0.15)"
			labelMargin: 10, // in pixels
			axisMargin: 8, // in pixels
			borderWidth: 0, // in pixels
			minBorderMargin: 10, // in pixels, null means taken from points radius
			mouseActiveRadius: 5 // how far the mouse can be away to activate an item
		},
		tooltipOpts: {
			defaultTheme: false
		},
		selection: {
			color: App.getLayoutColorCode('blue')
		}
	};

	var defaultPlotWidgetOptions = {
		colors: ['#ffffff'],
		legend: {
			show: false,
			backgroundOpacity: 0
		},
		series: {
			points: {
			}
		},
		grid: {
			tickColor: 'rgba(255, 255, 255, 0.1)',
			color: '#ffffff',
		},
		shadowSize: 1
	};

	/**************************
	 * Circle Dial (Knob)     *
	 **************************/
	var initKnob = function() {
		if ($.fn.knob) {
			$(".knob").knob();

			// All elements, which has no color specified, apply default color
			$('.knob').each(function () {
				if (typeof $(this).attr('data-fgColor') == 'undefined') {
					$(this).trigger('configure', {
						'fgColor': App.getLayoutColorCode('blue'),
						'inputColor': App.getLayoutColorCode('blue')
					});
				}
			});
		}
	}

	/**************************
	 * Sparkline Statbox Defaults
	 **************************/
	var defaultSparklineStatboxOptions = {
		type: 'bar',
		height: '19px',
		zeroAxis: false,
		barWidth: '4px',
		barSpacing: '1px',
		barColor: '#fff'
	}

	/**************************
	 * ColorPicker            *
	 **************************/
	var initColorPicker = function() {
		if ($.fn.colorpicker) {
			$('.bs-colorpicker').colorpicker();
		}
	}

	/**************************
	 * Template               *
	 **************************/
	var initTemplate = function() {
		if ($.fn.template) {
			// Set default options
			$.extend(true, $.fn.template.defaults, {

			});
		}
	}

	return {

		// main function to initiate all plugins
		init: function () {
			initBrowserDetection(); // $.browser for jQuery 1.9
			initDaterangepicker(); // Daterangepicker for dashboard
			initSparklines(); // Small charts
			initTooltips(); // Bootstrap tooltips
			initPopovers(); // Bootstrap popovers
			initNoty(); // Notifications
			initDataTables(); // Managed Tables
			initCircularCharts(); // Easy Pie Chart
			initKnob(); // Circle Dial
			initColorPicker(); // Bootstrap ColorPicker
			//initTemplate(); // Template
		},

		getFlotDefaults: function() {
			return defaultPlotOptions;
		},

		getFlotWidgetDefaults: function() {
			return $.extend(true, {}, Plugins.getFlotDefaults(), defaultPlotWidgetOptions);
		},

		getSparklineStatboxDefaults: function() {
			return defaultSparklineStatboxOptions;
		}

	};

}();