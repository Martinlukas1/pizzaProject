
window.onscroll = function () {scrollFunction()}

function scrollFunction () {
    if (document.body.scrollTop>95 ||document.documentElement.scrollTop > 95){
        document.getElementById("container").style.padding = "10px";
    } else {
        document.getElementById("container").style.padding = "15px";
    }
}
