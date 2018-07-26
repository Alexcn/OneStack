jQuery(function($){

    $.supersized({

        // Functionality
        slide_interval     : 4000,    // Length between transitions
        transition         : 1,    // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
        transition_speed   : 1000,    // Speed of transition
        performance        : 1,    // 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)

        // Size & Position
        min_width          : 0,    // Min width allowed (in pixels)
        min_height         : 0,    // Min height allowed (in pixels)
        vertical_center    : 1,    // Vertically center background
        horizontal_center  : 1,    // Horizontally center background
        fit_always         : 0,    // Image will never exceed browser width or height (Ignores min. dimensions)
        fit_portrait       : 1,    // Portrait images will not exceed browser height
        fit_landscape      : 0,    // Landscape images will not exceed browser width

        // Components
        slide_links        : 'blank',    // Individual links for each slide (Options: false, 'num', 'name', 'blank')
        slides             : [    // Slideshow Images
                                //  {image : '/static/login/img/backgrounds/11.jpg'},
                                 {image : '/static/login/img/backgrounds/22.jpg'},
                                //  {image : '/static/login/img/backgrounds/33.jpg'},
                                //  {image : '/static/login/img/backgrounds/44.jpg'},
                                 {image : '/static/login/img/backgrounds/77.jpeg'},
                                 {image : '/static/login/img/backgrounds/88.jpg'},
                                 {image : '/static/login/img/backgrounds/88.jpg'},
                                 {image : '/static/login/img/backgrounds/99.jpg'},
                                 {image : '/static/login/img/backgrounds/111.jpg'},
                                 {image : '/static/login/img/backgrounds/112.jpg'},
                                //  {image : '/static/login/img/backgrounds/113.jpg'},
                                 {image : '/static/login/img/backgrounds/114.jpg'},
                                 {image : '/static/login/img/backgrounds/115.jpg'},
                                 {image : '/static/login/img/backgrounds/116.jpg'},
                                //  {image : '/static/login/img/backgrounds/66.png'},
                             ]

    });

});
