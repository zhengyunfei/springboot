/*
 * FileInput Plugin JS v0.1.0
 *
 * Customized by Simon Stamm for Bootstrap 3
 *
 * 'Highly configurable' mutable plugin boilerplate
 * Author: @markdalgleish
 * Further changes, comments: @addyosmani
 * Licensed under the MIT license
 *
 */

;(function( $, window, document, undefined ) {
	"use strict";

	// our plugin constructor
	function FileInput( element, options ) {
		if( arguments.length ) {
			this._init( element, options );
		}
    };

    $.fn.fileInput = function( options ) {
		var options = $.extend({}, $.fn.fileInput.defaults, options);

		return this.each(function() {
			new FileInput( this, options );
		});
	};

	// Defaults
	$.fn.fileInput.defaults = {
		placeholder: 'No file selected...',
		buttontext: 'Browse...',
		inputsize: 'width-xlarge' // e.g. block-level
	};

	// the plugin prototype
	FileInput.prototype = {
		_init: function( element, options ) {
			this.element = $( element );
			this.options = $.extend( {}, this.defaults, options, this.element.data() );

			this._build();
		},

		_build: function () {

			this.element.css( {
				'position': 'absolute',
				'top': 0,
				'right': 0,
				'margin': 0,
				'cursor': 'pointer',
				'fontSize': '99px',
				'opacity': 0,
				'filter': 'alpha(opacity=0)'
			} )
			.on( 'change.fileupload', $.proxy( this._change, this) );

			this.container = $( '<div class="fileinput-holder input-group input-' + this.options.inputsize + '"></div>' )
				.append( $( '<div class="fileinput-preview uneditable-input" style="cursor: text; text-overflow: ellipsis; "></div>' )
						.addClass('form-control').text( this.options.placeholder ) )
				.append( $( '<span class="fileinput-btn btn" style="overflow: hidden; position: relative; cursor: pointer; "></span>' )
						.text( this.options.buttontext ) )
				.insertAfter( this.element );

			this.container.find('.fileinput-btn').wrap('<div class="input-group-btn"></div>');

			this.element.appendTo( this.container.find( '.fileinput-btn' ) );

		},

		_change: function ( e ) {

			var file = e.target.files !== undefined ? e.target.files[0] : { name: e.target.value.replace(/^.+\\/, '') };
			if ( !file ) return;

			this.container.find( '.fileinput-preview ' ).text(file.name);
		}
	}

})( jQuery, window , document );