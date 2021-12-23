
// window.onscroll = function () {scrollFunction()}
//
// function scrollFunction () {
//     if (document.body.scrollTop>95 ||document.documentElement.scrollTop > 95){
//         document.getElementById("container").style.padding = "10px";
//     } else {
//         document.getElementById("container").style.padding = "15px";
//     }
// }

// var ONLYONETIME_EXECUTE = null;
// window.addEventListener('load', function(){ // on page load
//
//     document.body.addEventListener('touchstart', function(e){
//
//         if (ONLYONETIME_EXECUTE == null) {
//
//             video.play();
//
//             //if you want to prepare more than one video/audios use this trick :
//             video2.play();
//             video2.pause();
//             // now video2 is buffering and you can play it programmability later
//             // My personal testing was maximum 6 video/audio for android
//             // and maybe 3 max for iOS using single click or touch.
//             // Every next click also can prepare more audios/videos.
//
//             ONLYONETIME_EXECUTE = 0;
//         }
//
//     }, false)
//
// }, false)

/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}
