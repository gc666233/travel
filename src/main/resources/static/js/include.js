$(function () {
    $.get("header.html",function (data) {
        $("#header").html(data);
    });
    $.get("footer.html",function (data) {
        $("#footer").html(data);
    });
});
document.write('<script src="https://unpkg.com/axios/dist/axios.min.js"></script>');

