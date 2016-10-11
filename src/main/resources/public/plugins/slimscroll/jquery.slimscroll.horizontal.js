/*! Copyright (c) 2011 Piotr Rochala (http://rocha.la)
 * Dual licensed under the MIT (http://www.opensource.org/licenses/mit-license.php)
 * and GPL (http://www.opensource.org/licenses/gpl-license.php) licenses.
 *
 * Version: 0.6.5
 *
 */
(function($) {

  jQuery.fn.extend({
    slimScrollHorizontal: function(options) {

      var defaults = {
        wheelStep : 20,
        height : 'auto',
        width : '250px',
        size : '7px',
        color: '#000',
        position : 'bottom',
        distance : '1px',
        start : 'left',
        opacity : .4,
        alwaysVisible : false,
        disableFadeOut: false,
        railVisible : false,
        railColor : '#333',
        railOpacity : '0.2',
        railClass : 'slimScrollRail',
        barClass : 'slimScrollBar',
        wrapperClass : 'slimScrollDiv',
        allowPageScroll: false,
        scroll: 0,
        touchScrollStep: 200
      };

      var o = $.extend(defaults, options);

      // do it for every element that matches selector
      this.each(function(){

      var isOverPanel, isOverBar, isDragg, queueHide, touchDif,
        barWidth, percentScroll, lastScroll,
        divS = '<div></div>',
        minBarWidth = 30,
        releaseScroll = false;

        // used in event handlers and for better minification
        var me = $(this);

        //ensure we are not binding it again
        if (me.parent().hasClass('slimScrollDiv'))
        {
            //check if we should scroll existing instance
            if (scroll)
            {
                //find bar and rail
                bar = me.parent().find('.slimScrollBar');
                rail = me.parent().find('.slimScrollRail');

                //scroll by given amount of pixels
                scrollContent( me.scrollLeft() + parseInt(scroll), false, true);
            }

            return;
        }

        // wrap content
        var wrapper = $(divS)
          .addClass(o.wrapperClass)
          .css({
            position: 'relative',
            overflow: 'hidden',
            width: o.width,
            height: o.height
          });

        // update style for the div
        me.css({
          overflow: 'hidden',
          width: o.width,
          height: o.height
        });

        // create scrollbar rail
        var rail  = $(divS)
          .addClass(o.railClass)
          .css({
            width: '100%',
            height: o.size,
            position: 'absolute',
            bottom: 0,
            display: (o.alwaysVisible && o.railVisible) ? 'block' : 'none',
            'border-radius': o.size,
            background: o.railColor,
            opacity: o.railOpacity,
            zIndex: 90
          });

        // create scrollbar
        var bar = $(divS)
          .addClass(o.barClass)
          .css({
            background: o.color,
            height: o.size,
            position: 'absolute',
            bottom: 0,
            opacity: o.opacity,
            display: o.alwaysVisible ? 'block' : 'none',
            'border-radius' : o.size,
            BorderRadius: o.size,
            MozBorderRadius: o.size,
            WebkitBorderRadius: o.size,
            zIndex: 99
          });

        // set position
        var posCss = (o.position == 'top') ? { top: o.distance } : { bottom: o.distance };
        rail.css(posCss);
        bar.css(posCss);

        // wrap it
        me.wrap(wrapper);

        // append to parent div
        me.parent().append(bar);
        me.parent().append(rail);

        // make it draggable
        bar.draggable({
          axis: 'x',
          containment: 'parent',
          start: function() { isDragg = true; },
          stop: function() { isDragg = false; hideBar(); },
          drag: function(e)
          {
            // scroll content
            scrollContent(0, $(this).position().left, false);
          }
        });

        // on rail over
        rail.hover(function(){
          showBar();
        }, function(){
          hideBar();
        });

        // on bar over
        bar.hover(function(){
          isOverBar = true;
        }, function(){
          isOverBar = false;
        });

        // show on parent mouseover
        me.hover(function(){
          isOverPanel = true;
          showBar();
          hideBar();
        }, function(){
          isOverPanel = false;
          hideBar();
        });

        // support for mobile
        me.bind('touchstart', function(e,b){
          if (e.originalEvent.touches.length)
          {
            // record where touch started
            touchDif = e.originalEvent.touches[0].pageX;
          }
        });

        me.bind('touchmove', function(e){
          // prevent scrolling the page
          e.originalEvent.preventDefault();
          if (e.originalEvent.touches.length)
          {
            // see how far user swiped
            var diff = (touchDif - e.originalEvent.touches[0].pageX) / o.touchScrollStep;
            // scroll content
            scrollContent(diff, true);
          }
        });

        var _onWheel = function(e)
        {
          // use mouse wheel only when mouse is over
          if (!isOverPanel) { return; }

          var e = e || window.event;

          var delta = 0;
          if (e.wheelDelta) { delta = -e.wheelDelta/120; }
          if (e.detail) { delta = e.detail / 3; }

          // scroll content
          scrollContent(delta, true);

          // stop window scroll
          if (e.preventDefault && !releaseScroll) { e.preventDefault(); }
          if (!releaseScroll) { e.returnValue = false; }
        }

        function scrollContent(x, isWheel, isJump)
        {
          var delta = x;

          if (bar.css('left') == 'auto') {
          	bar.css('left', '0px');
          }
          if (isWheel)
          {
            // move bar with mouse wheel
            delta = parseInt(bar.css('left')) + x * parseInt(o.wheelStep) / 100 * bar.outerWidth();

            // move bar, make sure it doesn't go out
            var maxLeft = me.outerWidth() - bar.outerWidth();
            delta = Math.min(Math.max(delta, 0), maxLeft);

            // scroll the scrollbar
            bar.css({ left: delta + 'px' });
          }

          // calculate actual scroll amount
          percentScroll = parseInt(bar.css('left')) / (me.outerWidth() - bar.outerWidth());
          delta = percentScroll * (me[0].scrollWidth - me.outerWidth());

          if (isJump)
          {
            delta = x;
            var offsetLeft = delta / me[0].scrollWidth * me.outerWidth();
            bar.css({ left: offsetLeft + 'px' });
          }

          // scroll content
          me.scrollLeft(delta);

          // ensure bar is visible
          showBar();

          // trigger hide when scroll is stopped
          hideBar();
        }

        var attachWheel = function()
        {
          if (window.addEventListener)
          {
            this.addEventListener('DOMMouseScroll', _onWheel, false );
            this.addEventListener('mousewheel', _onWheel, false );
          }
          else
          {
            document.attachEvent("onmousewheel", _onWheel)
          }
        }

        // attach scroll events
        attachWheel();

        function getBarWidth()
        {
          // calculate scrollbar width and make sure it is not too small
          barWidth = Math.max((me.outerWidth() / me[0].scrollWidth) * me.outerWidth(), minBarWidth);
          bar.css({ width: barWidth + 'px' });
        }

        // set up initial width
        getBarWidth();

        function showBar()
        {
          // recalculate bar width
          getBarWidth();
          clearTimeout(queueHide);

          // when bar reached left or right
          if (percentScroll == ~~ percentScroll)
          {
            //release wheel
            releaseScroll = o.allowPageScroll;

            // publish approporiate event
            if (lastScroll != percentScroll)
            {
                var msg = (~~percentScroll == 0) ? 'left' : 'right';
                me.trigger('slimscroll', msg);
            }
          }
          lastScroll = percentScroll;

          // show only when required
          if(barWidth >= me.outerWidth()) {
            //allow window scroll
            releaseScroll = true;
            return;
          }
          bar.stop(true,true).fadeIn('fast');
          if (o.railVisible) { rail.stop(true,true).fadeIn('fast'); }
        }

        function hideBar()
        {
          // only hide when options allow it
          if (!o.alwaysVisible)
          {
            queueHide = setTimeout(function(){
              if (!(o.disableFadeOut && isOverPanel) && !isOverBar && !isDragg)
              {
                bar.fadeOut('slow');
                rail.fadeOut('slow');
              }
            }, 1000);
          }
        }

        // check start position
        if (o.start == 'right')
        {
          // scroll content to right
          bar.css({ left: me.outerWidth() - bar.outerWidth() });
          scrollContent(0, true);
        }
        else if (typeof o.start == 'object')
        {
          // scroll content
          scrollContent($(o.start).position().left, null, true);

          // make sure bar stays hidden
          if (!o.alwaysVisible) { bar.hide(); }
        }
      });

      // maintain chainability
      return this;
    }
  });

  jQuery.fn.extend({
    slimscrollHorizontal: jQuery.fn.slimScrollHorizontal
  });

})(jQuery);