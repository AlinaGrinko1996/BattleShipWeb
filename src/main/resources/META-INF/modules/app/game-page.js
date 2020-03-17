define(["jquery"], function(jQuery) {
    function init() {
        jQuery("td").on("click", function (e) {
            jQuery(e.target).toggleClass("active");
            jQuery(e.target).find(".inner-link").trigger(e.type);
        });
    }

    function toggleClass(cellId) {
        jQuery(".my-container").find("[data-id=" + cellId + "]").toggleClass("selected");
    }

    function hit(className, cellId) {
        var element = jQuery(".opponent-container").find("[data-id=" + cellId + "]");
        element.addClass(className);
        element.find("div").removeClass("hidden");
    }

    init();

    return {
            init: init,
            toggleClass: toggleClass,
            hit: hit
    }
});