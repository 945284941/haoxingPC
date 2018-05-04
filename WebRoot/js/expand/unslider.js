/**
 * 
 * http://www.bootcss.com/p/unslider/
 * jQuery轮播插件
 * 
 *   
如何使用Unslider
引入jQuery 和 Unslider
To use Unslider, you’ll need to make sure both the Unslider and jQuery scripts are included. If you’ve already got jQuery (you can test by opening your JavaScript console and typing !!window.jQuery — if it says true, you have jQuery), you don’t need to add the first line.
<script src="//code.jquery.com/jquery-latest.min.js"></script>
<script src="//unslider.com/unslider.js"></script>
准备HTML代码
Unslider doesn’t need any really awkward markup. In fact, all you need is a div and an unordered list. An example of some Unslider-friendly HTML is on the right.
You can add as many slides as you want: the example on the right just has three for the sake of brevity, but Unslider won’t work properly with one slide (but then it’s just a box).
<div class="banner">
    <ul>
        <li>This is a slide.</li>
        <li>This is another slide.</li>
        <li>This is a final slide.</li>
    </ul>
</div>
Make it pretty
You can change, add, and remove as much CSS per slide as you want, but there is a barebones style required by Unslider. It’s on the right (change the class name where .banner is the name of your slider).
.banner { position: relative; overflow: auto; }
    .banner li { list-style: none; }
        .banner ul li { float: left; }
Plug it all together
We’ve been through so much together, and I’m pleased to say the finish line is near. Our journey is almost over, just one more thing left to do. The JavaScript is on the right (make sure to put it in a script tag, and change .banner to whatever your slider’s element is).
$(function() {
    $('.banner').unslider();
});
参数
Although it’s lightweight, Unslider comes with a range of options to customise your slider. Here’s the default options provided. You can add, remove, or completely skip out the options object. It’s up to you.
$('.banner').unslider({
	speed: 500,               //  The speed to animate each slide (in milliseconds)
	delay: 3000,              //  The delay between slide animations (in milliseconds)
	complete: function() {},  //  A function that gets called after every slide animation
	keys: true,               //  Enable keyboard (left, right) arrow shortcuts
	dots: true,               //  Display dot navigation
	fluid: false              //  Support responsive design. May break non-responsive designs
});



支持触摸屏
If you want to add mobile/touch/swipe/whatever support to Unslider, you’ll need to include the jQuery.event.swipe plugin, then it’ll work out the box. Easy!



添加向前(previous)/向后（next）链接
A feature that’s often requested in Unslider, but isn’t included in-the-box, is previous/next links. Luckily, they’re easy enough to add with a little script, which utilises Unslider’s methods.
<!-- The HTML -->
<a href="#" class="unslider-arrow prev">Previous slide</a>
<a href="#" class="unslider-arrow next">Next slide</a>

<!-- And the JavaScript -->
<script>
    var unslider = $('.banner').unslider();

    $('.unslider-arrow').click(function() {
        var fn = this.className.split(' ')[1];

        //  Either do unslider.data('unslider').next() or .prev() depending on the className
        unslider.data('unslider')[fn]();
    });
</script>



存取Unslider的属性
Using jQuery’s wonderful data method, you can access and manually override any methods. Here’s a list of what you can do:
var slidey = $('.banner').unslider(),
    data = slidey.data('unslider');

//  Start Unslider
data.start();

//  Pause Unslider
data.stop();

//  Move to a slide index, with optional callback
data.move(2, function() {});
//  data.move(0);

//  Manually enable keyboard shortcuts
data.keys();

//  Move to the next slide (or the first slide if there isn't one)
data.next();

//  Move to the previous slide (or the last slide if there isn't one)
data.prev();

//  Append the navigation dots manually
 *   
 *   
 *   
 */

(function($, f) {
	var Unslider = function() {
		//  Object clone
		var _ = this;

		//  Set some options
		_.o = {
			speed: 500,   // animation speed, false for no transition (integer or boolean)
			delay: 3000,  // delay between slides, false for no autoplay (integer or boolean)
			init: 0,      // init delay, false for no delay (integer or boolean)
			pause: !f,    // pause on hover (boolean)
			loop: !f,     // infinitely looping (boolean)
			keys: f,      // keyboard shortcuts (boolean)
			dots: f,      // display ••••o• pagination (boolean)
			arrows: f,    // display prev/next arrows (boolean)
			prev: '←',    // text or html inside prev button (string)
			next: '→',    // same as for prev option
			fluid: f,     // is it a percentage width? (boolean)
			complete: f,  // invoke after animation (function with argument)
			items: '>ul', // slides container selector
			item: '>li'   // slidable items selector
		};

		_.init = function(el, o) {
			//  Check whether we're passing any options in to Unslider
			_.o = $.extend(_.o, o);

			_.el = el;
			_.ul = el.find(_.o.items);
			_.max = [el.outerWidth() | 0, el.outerHeight() | 0];
			_.li = _.ul.find(_.o.item).each(function(index) {
				var me = $(this),
					width = me.outerWidth(),
					height = me.outerHeight();

				//  Set the max values
				if (width > _.max[0]) _.max[0] = width;
				if (height > _.max[1]) _.max[1] = height;
			});


			//  Cached vars
			var o = _.o,
				ul = _.ul,
				li = _.li,
				len = li.length;

			//  Current indeed
			_.i = 0;

			//  Set the main element
			el.css({width: _.max[0], height: li.first().outerHeight(), overflow: 'hidden'});

			//  Set the relative widths
			ul.css({position: 'relative', left: 0, width: (len * 100) + '%'});
			li.css({'float': 'left', width: (100 / len) + '%'});

			//  Autoslide
			setTimeout(function() {
				if (o.delay | 0) {
					_.play();

					if (o.pause) {
						el.on('mouseover mouseout', function(e) {
							_.stop();
							e.type == 'mouseout' && _.play();
						});
					};
				};
			}, o.init | 0);

			//  Keypresses
			if (o.keys) {
				$(document).keydown(function(e) {
					var key = e.which;

					if (key == 37)
						_.prev(); // Left
					else if (key == 39)
						_.next(); // Right
					else if (key == 27)
						_.stop(); // Esc
				});
			};

			//  Dot pagination
			o.dots && nav('dot');

			//  Arrows support
			o.arrows && nav('arrow');

			//  Patch for fluid-width sliders. Screw those guys.
			if (o.fluid) {
				$(window).resize(function() {
					_.r && clearTimeout(_.r);

					_.r = setTimeout(function() {
						var styl = {height: li.eq(_.i).outerHeight()},
							width = el.outerWidth();

						ul.css(styl);
						styl['width'] = Math.min(Math.round((width / el.parent().width()) * 100), 100) + '%';
						el.css(styl);
					}, 50);
				}).resize();
			};

			//  Swipe support
			if ($.event.special['swipe'] || $.Event('swipe')) {
				el.on('swipeleft swiperight swipeLeft swipeRight', function(e) {
					e.type.toLowerCase() == 'swipeleft' ? _.next() : _.prev();
				});
			};

			return _;
		};

		//  Move Unslider to a slide index
		_.to = function(index, callback) {
			var o = _.o,
				el = _.el,
				ul = _.ul,
				li = _.li,
				current = _.i,
				target = li.eq(index);

			//  To slide or not to slide
			if ((!target.length || index < 0) && o.loop == f) return;

			//  Check if it's out of bounds
			if (!target.length) index = 0;
			if (index < 0) index = li.length - 1;
			target = li.eq(index);

			var speed = callback ? 5 : o.speed | 0,
				obj = {height: target.outerHeight()};

			if (!ul.is(':animated')) {
				//  Handle those pesky dots
				el.find('.dot:eq(' + index + ')').addClass('active').siblings().removeClass('active');

				el.animate(obj, speed) && ul.animate($.extend({left: '-' + index + '00%'}, obj), speed, function(data) {
					_.i = index;

					$.isFunction(o.complete) && !callback && o.complete(el);
				});
			};
		};

		//  Autoplay functionality
		_.play = function() {
			_.t = setInterval(function() {
				_.to(_.i + 1);
			}, _.o.delay | 0);
		};

		//  Stop autoplay
		_.stop = function() {
			_.t = clearInterval(_.t);
			return _;
		};

		//  Move to previous/next slide
		_.next = function() {
			return _.stop().to(_.i + 1);
		};

		_.prev = function() {
			return _.stop().to(_.i - 1);
		};

		//  Create dots and arrows
		function nav(name, html) {
			if (name == 'dot') {
				html = '<ol class="dots">';
					$.each(_.li, function(index) {
						html += '<li class="' + (index == _.i ? name + ' active' : name) + '">' + ++index + '</li>';
					});
				html += '</ol>';
			} else {
				html = '<div class="';
				html = html + name + 's">' + html + name + ' prev">' + _.o.prev + '</div>' + html + name + ' next">' + _.o.next + '</div></div>';
			};

			_.el.addClass('has-' + name + 's').append(html).find('.' + name).click(function() {
				var me = $(this);
				me.hasClass('dot') ? _.stop().to(me.index()) : me.hasClass('prev') ? _.prev() : _.next();
			});
		};
	};

	//  Create a jQuery plugin
	$.fn.unslider = function(o) {
		var len = this.length;

		//  Enable multiple-slider support
		return this.each(function(index) {
			//  Cache a copy of $(this), so it
			var me = $(this),
				key = 'unslider' + (len > 1 ? '-' + ++index : ''),
				instance = (new Unslider).init(me, o);

			//  Invoke an Unslider instance
			me.data(key, instance).data('key', key);
		});
	};
})(jQuery, false);