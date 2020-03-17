define(["jquery"], function(jQuery) {
    function init() {
        jQuery(".my-container").find("td").on("click", function (e) {
            jQuery(e.target).toggleClass("selected");
        });
    }

    init();

    return {
            init: init
    }

});