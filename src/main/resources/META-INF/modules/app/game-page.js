define(["jquery"], function(jQuery) {
    function init() {
        //for each click on table cell - trigger click event for nested action link
        jQuery("td").on("click", function (e) {
            jQuery(e.target).find(".inner-link").trigger(e.type);
        });
    }

    function toggleClass(cellId) {
        //when cell for ship is chosen, mark it as "selected"
        jQuery(".my-container").find("[data-id=" + cellId + "]").toggleClass("selected");
    }

    function hit(className, cellId) {
        //selecting cell needed
        var element = jQuery(".opponent-container").find("[data-id=" + cellId + "]");
        //adding class (depending of was the cell empty or not)
        element.addClass(className);
        //opening "X" letter to mark cells
        element.find("div").removeClass("hidden");
    }

    init();

    return {
            init: init,
            toggleClass: toggleClass,
            hit: hit
    }
});