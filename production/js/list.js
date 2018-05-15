window.onload=function(){
	$(function () {
    $("table > tbody > tr").click(function () {
        location.href = $(this).find("a").attr("href");
    });
})
}