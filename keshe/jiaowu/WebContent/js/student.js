/**
 * 
 */
$(function () {
    var Accordion = function (el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;

        var links = this.el.find('.link');

        links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
    }

    Accordion.prototype.dropdown = function (e) {
        var $el = e.data.el;
        $this = $(this),
            $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');

        if (!e.data.multiple) {
            $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
        }
        ;
    }

    var accordion = new Accordion($('#accordion'), false);
});
function query_all(object){
	var xmlhttp;
    if (window.XMLHttpRequest) {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // IE6, IE5 浏览器执行代码
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

            document.getElementById("result").innerHTML = xmlhttp.responseText;
        }
    }
	var url=null;
	if(object=="course"){
		url="/jiaowu/OperationServlet?action=query_all_course";
	}
	else{
		
	}
	xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function show_change(object){
	var result = document.getElementById("result");
	var show=null;

	var id=document.getElementById("id").value;

	if (object == "student") {
       
    	show = "<div id='show_change_student'  class='d_form'>"
        + "<h3>修改密码</h3>"
        + "<input id='num' type='text'  name='num'  disabled='disabled' value="+id+">"
 		+ "<input id='pastpassword' type='text' autocomplete='off' name='pastpassword' value placeholder='原密码' required>"
		+ "<input id='nowpassword' type='text' autocomplete='off' name='nowpassword' value placeholder='修改后密码' required>"
        + "<input id='submit' onclick=change('student') type='button' name='submit' value='修改'>"
        + "</div>";
    	result.innerHTML = show;
    }
}
function change(object){
	if (window.XMLHttpRequest) {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // IE6, IE5 浏览器执行代码
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

            document.getElementById("result").innerHTML = xmlhttp.responseText;
        }
    }
	var url=null;
	var id=document.getElementById("id").value;

	var somechange=document.getElementById("show_change_student").getElementsByTagName("input");
	var pastpassword=somechange[1].value.toString();
	var nowpassword =somechange[2].value.toString();
	if(object=="student"){
		url="/jiaowu/OperationServlet?action=change_student&id=" + id+"&pastpassword="+pastpassword+"&nowpassword="+nowpassword;	
	
	}
	xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function query_student(object) {
	
    var xmlhttp;
    if (window.XMLHttpRequest) {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // IE6, IE5 浏览器执行代码
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("result").innerHTML = xmlhttp.responseText;
        }
    }
    var url = null;
    //判断执行
	var id=document.getElementById("id").value;
    if (object == "course") {
        url = "/jiaowu/OperationServlet?action=query_student_course&id="+id;
    }
    else if (object == "score") {
        url = "/jiaowu/OperationServlet?action=query_student_score&id="+id;
    }
	else if(object=="achievement"){
		url = "/jiaowu/OperationServlet?action=query_student_achievement&id="+id;
		
	}
	else if(object=="information"){
		url="/jiaowu/OperationServlet?action=query_student&id="+id;
	}
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function insert_course(object){
	var xmlhttp;
    if (window.XMLHttpRequest) {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // IE6, IE5 浏览器执行代码
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("result").innerHTML = xmlhttp.responseText;
        }
    }
    var url = null;
    //判断执行
	var id=document.getElementById("id").value;
	url="/jiaowu/OperationServlet?action=insert_course&id="+id+"&courseid="+object;
	xmlhttp.open("GET",url,true);
	xmlhttp.send();
}
function delete_course(object){
	var xmlhttp;
    if (window.XMLHttpRequest) {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // IE6, IE5 浏览器执行代码
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("result").innerHTML = xmlhttp.responseText;
        }
    }
    var url = null;
    //判断执行
	var id=document.getElementById("id").value;
	url="/jiaowu/OperationServlet?action=delete_course&id="+id+"&courseid="+object;
	xmlhttp.open("GET",url,true);
	xmlhttp.send();
}
