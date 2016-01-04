/**
 * jQuery Input Over Text. Displays a temporary label over your text fields and disappears on focus.
 *
 * Usage: jQuery("#fieldId").overText("Label:", "#999", "#000");
 * Copyright: MD http://developersrants.com
 */
jQuery.fn.overText = function(text, labelColor, activeColor) {
    this.each(function() {
        if (!jQuery(this).val()) {
            jQuery(this)
                .val(text)
                .css('color', labelColor);
        }
        
        jQuery(this)
            .focus(function() {
                if (jQuery(this).val() == text) {
                    jQuery(this)
                        .val('')
                        .css('color', activeColor);
                }
            })
            .blur(function() {
                if (!jQuery(this).val() || jQuery(this).val() == text) {
                    jQuery(this)
                        .val(text)
                        .css('color', labelColor);
                }
            });
    });
}