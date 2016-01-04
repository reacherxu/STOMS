/**
	Steve Elmer,	http://summergrand.com
	November 2011
	Placeholder labels for input elements 
		- includes password and select
		- inserts separate input element to be the placeholder
		- does *NOT* alter the value of the form's intrinsic inputs
	http://summergrand.com/cubemods/page/jqInputLabel

	License: GPL
	
	v1.0	November 4 2011	-	Initial version
**/



	$.fn.jqInputLabel = function (args) {

		$.extend($.fn.jqInputLabel.defaults, args);

		return this.each(function() {
			$this = $(this);

			// Create a new element to hold the inline field label
			if ($this.hasClass($.fn.jqInputLabel.defaults.requiredName))
				required = $.fn.jqInputLabel.defaults.requiredName;
			else
				required = '';

			$this.before("<input type='text' class='"+$.fn.jqInputLabel.defaults.labelName+" "+required+"' name='jqInputLabel_"+$this.attr('name')+"' value='"+$this.attr('title')+"'>");
			obj = $this.prev();
			var w = $this.css('width');
			if (w < 100) w += 100;
			obj.css('width', w);

			// On focus, hide the label and show & focus the real object
			obj.bind('focus.jqInputLabel', function() {
				$(this).hide(); 
				$(this).next().show(); 
				$(this).next().focus();
			} );

			// For selects, the actual field must be hidden and a change needs to check
			// whether to show the label again.  Selects can have an 'ignore' attribute
			// that prevents a given selection index from being treated as a real value.
			if ($this.attr('type') == 'select-one' || $this.attr('type') == 'select-multi') {
				$this.bind('change.jqInputLabel', function() {
					var i = $(this)[0].selectedIndex;
					var ignored = $(this).attr('ignore');
					if (typeof(ignored) != 'undefined' && i == ignored) {
						$(this).hide(); 
						$(this).prev().show(); 
						$(this).removeClass($.fn.jqInputLabel.defaults.activeName);
					} else
						$(this).addClass($.fn.jqInputLabel.defaults.activeName);
				} );

				// The initial state of the select depends on whether something is selected already
				var i = $this[0].selectedIndex;
				var ignored = $(this).attr('ignore');
				if (typeof(ignored) != 'undefined' && i == ignored) {
					$this.hide();
					$this.removeClass($.fn.jqInputLabel.defaults.activeName);
				} else {
					obj.hide();
					$this.addClass($.fn.jqInputLabel.defaults.activeName);
				}
			} else {

				// For passwords, the actual field must be hidden and a blur needs to check
				// whether to show the label again
				if ($this.val() == '') {
					$this.hide();
					$this.removeClass($.fn.jqInputLabel.defaults.activeName);
				} else {
					obj.hide();
					$this.addClass($.fn.jqInputLabel.defaults.activeName);
				}
				$this.bind('blur.jqInputLabel', function() {
					if ($(this)[0].value == '' || $(this)[0].value == $(this).attr('title')) { 
						$(this).hide(); 
						$(this).prev().show(); 
						$(this).removeClass($.fn.jqInputLabel.defaults.activeName);
					} else 
						$(this).addClass($.fn.jqInputLabel.defaults.activeName);
				} );
				$this.bind('change.jqInputLabel', function() {
					if ($(this)[0].value == '' || $(this)[0].value == $(this).attr('title')) { 
						$(this).hide(); 
						$(this).prev().show(); 
						$(this).removeClass($.fn.jqInputLabel.defaults.activeName);
					} else 
						$(this).addClass($.fn.jqInputLabel.defaults.activeName);
				} );
			}
		});
	};

	$.fn.jqInputLabel.defaults = { 
		labelName: 'xmp_label', 
		requiredName: 'required', 
		activeName: 'active' 
	};
