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
    var url = null;
    if(object=="student"){
		url = "/jiaowu/AdminServlet?action=query_all_student";
	}
	else if(object=="course"){
		url = "/jiaowu/AdminServlet?action=query_all_course";
	}
	else if(object=="score"){
		url = "/jiaowu/AdminServlet?action=query_all_score";
	}
	else if(object=="achievement"){
		url = "/jiaowu/AdminServlet?action=query_all_achievement";
	}
	xmlhttp.open("GET", url, true);
    xmlhttp.send();
	
	
}
function query_studentofcourse(object){
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
	url="/jiaowu/AdminServlet?action=query_studentofcourse&courseid="+object;
	xmlhttp.open("GET",url,true);
	xmlhttp.send();
}
function show_insert(object){
	var result = document.getElementById("result");
	var show=null;
	if (object == "student") {
       
    	show = "<div id='show_insert_student'  class='d_form'>"
        + "<h3>请输入新增学生信息</h3>"
       + "<input id='num' type='text' name='num' autocomplete='off' autofocus='autofocus' value placeholder='学号' required>"
        + "<input id='password' type='text' name='password'autocomplete='off'  value placeholder='密码' required>"
		+ "<input id='name' type='text' name='name'autocomplete='off'  value placeholder='姓名' required>"
		+ "<input id='card' type='text' name='card' autocomplete='off' value placeholder='身份证号' required>"
		+ "<input id='sex' type='text' name='sex' autocomplete='off' value placeholder='性别' required>"
		+ "<input id='birth' type='date' name='birth' autocomplete='off' value placeholder='出生日期' required>"
		+ "<input id='age' type='text' name='age' autocomplete='off' value placeholder='年龄' required>"
        + "<input id='minzu' type='text' name='minzu' autocomplete='off' value placeholder='民族' required>"
		+ "<input id='class' type='text' name='class' autocomplete='off' value placeholder='班级' required>"
		+ "<input id='yuanxi' type='text' name='yuanxi' autocomplete='off' value placeholder='院系' required>"
        + "<input id='submit' onclick=insert('student') type='button' name='submit' value='插入'>"
        + "</div>";
    	result.innerHTML = show;
    }
	else if(object=="course"){
		show = "<div id='show_insert_course'  class='d_form'>"
        + "<h3>请输入新增课程信息</h3>"
 		+ "<input id='num' type='text' name='num' autocomplete='off' autofocus='autofocus' value placeholder='课程号' required>"
        + "<input id='name' type='text' autocomplete='off'  name='name' value placeholder='课程名' required>"
        + "<input id='teacher' type='text' autocomplete='off' name='teacher' value placeholder='教师' required>"
		+ "<input id='score' type='text' name='score' autocomplete='off'  value placeholder='学分' required>"
 		+ "<input id='time' type='text' name='time' autocomplete='off' value placeholder='时间' required>"
		+ "<input id='place' type='text' name='place' autocomplete='off' value placeholder='地点' required>"
        + "<input id='submit' onclick=insert('course') type='button' name='submit' value='插入'>"
        + "</div>";
    	result.innerHTML = show;
	}
	else if(object=="score"){
		show = "<div id='show_insert_score'  class='d_form'>"
        + "<h3>请输入新增成绩信息</h3>"
        + "<input id='num' type='text' autocomplete='off' autofocus='autofocus' name='num' value placeholder='学号' required>"
        + "<input id='name' type='text' autocomplete='off' name='name' value placeholder='姓名' required>"
		+ "<input id='course' type='text' autocomplete='off'  name='course' value placeholder='课程' required>"
 		+ "<input id='score' type='text' autocomplete='off' name='score' value placeholder='分数' required>"
	 	+ "<input id='submit' onclick=insert('score') type='button' name='submit' value='插入'>"
        + "</div>";
    	result.innerHTML = show;
	}
	else if(object=="achievement"){
		show = "<div id='show_insert_achievement'  class='d_form'>"
        + "<h3>请输入新增社会成果信息</h3>"
        + "<input id='num' type='text' autocomplete='off' autofocus='autofocus' name='num' value placeholder='学号' required>"
        + "<input id='name' type='text' autocomplete='off' name='name' value placeholder='姓名' required>"
		+ "<input id='time' type='text' autocomplete='off' name='time' value placeholder='时间' required>"
 		+ "<input id='detail' type='text' autocomplete='off' name='detail' value placeholder='成果' required>"
	 	+ "<input id='submit' onclick=insert('achievement') type='button' name='submit' value='插入'>"
        + "</div>";
    	result.innerHTML = show;
	}
	else{
		
	}
	
}
function show_delete(object){
	var result = document.getElementById("result");
	var show=null;
	if (object == "student") {
       
    	show = "<div id='show_delete_student'  class='d_form'>"
        + "<h3>请输入删除学生信息</h3>"
        + "<input id='username' type='text' autocomplete='off' autofocus='autofocus' name='username' value placeholder='姓名' required>"
 		+ "<input id='num' type='text' name='num' autocomplete='off' value placeholder='学号' required>"
        + "<input id='submit' onclick=delete_student() type='button' name='submit' value='删除'>"
        + "</div>";
    	result.innerHTML = show;
    }
	else if(object=="course"){
		show = "<div id='show_delete_course'  class='d_form'>"
        + "<h3>请输入删除课程信息</h3>"
		+ "<input id='id' type='text' name='id' autocomplete='off' value placeholder='课程号' required>"
        + "<input id='name' type='text' autocomplete='off' autofocus='autofocus' name='name' value placeholder='课程名' required>"
        + "<input id='teacher' type='text' name='teacher' autocomplete='off' value placeholder='教师' required>"
		
        + "<input id='submit' onclick=delete_course() type='button' name='submit' value='删除'>"
        + "</div>";
    	result.innerHTML = show;
	}
	else if(object=="score"){
		show = "<div id='show_delete_score'  class='d_form'>"
        + "<h3>请输入删除成绩信息</h3>"
        + "<input id='num' type='text' autocomplete='off' autofocus='autofocus' name='num' value placeholder='学号' required>"
        + "<input id='name' type='text' name='name' autocomplete='off' value placeholder='姓名' required>"
		+ "<input id='course' type='text' name='course' autocomplete='off' value placeholder='课程' required>"
	 	+ "<input id='submit' onclick=delete_score() type='button' name='submit' value='删除'>"
        + "</div>";
    	result.innerHTML = show;
	}
	else if(object=="achievement"){
		show = "<div id='show_delete_achievement'  class='d_form'>"
        + "<h3>请输入删除社会成果信息</h3>"
        + "<input id='num' type='text' autocomplete='off' autofocus='autofocus' name='num' value placeholder='学号' required>"
        + "<input id='name' type='text' autocomplete='off' name='name' value placeholder='姓名' required>"
		+ "<input id='time' type='text' autocomplete='off' name='time' value placeholder='时间' required>"
 		+ "<input id='detail' type='text' autocomplete='off' name='detail' value placeholder='成果' required>"
	 	+ "<input id='submit' onclick=delete_achievement() type='button' name='submit' value='删除'>"
        + "</div>";
    	result.innerHTML = show;
	}
	else {
		
	}
}
function show_change(object){
	var result = document.getElementById("result");
	var show=null;
	if (object == "student") {
       
    	show = "<div id='show_change_student'  class='d_form'>"
        + "<h3>请输入修改学生信息</h3>"
        + "<input id='usednum' type='text' autocomplete='off' autofocus='autofocus' name='usedname' value placeholder='原学号' required>"
        +"<br/>"
        + "<input id='username' type='text' name='username' autocomplete='off' value placeholder='姓名' required>"
        + "<input id='password' type='text' name='password' autocomplete='off' value placeholder='密码' required>"
 		+ "<input id='num' type='text' name='num' autocomplete='off' value placeholder='学号' required>"
		+ "<input id='card' type='text' name='card' autocomplete='off' value placeholder='身份证号' required>"
		+ "<input id='sex' type='text' name='sex' autocomplete='off' value placeholder='性别' required>"
		+ "<input id='birth' type='date' name='birth' autocomplete='off' value placeholder='出生日期' required>"
		+ "<input id='age' type='text' name='age' autocomplete='off' value placeholder='年龄' required>"
        + "<input id='minzu' type='text' name='minzu' autocomplete='off' value placeholder='民族' required>"
		+ "<input id='class' type='text' name='class' autocomplete='off' value placeholder='班级' required>"
		+ "<input id='yuanxi' type='text' name='yuanxi' autocomplete='off' value placeholder='院系' required>"
        + "<input id='submit' onclick=change('student') type='button' name='submit' value='修改'>"
        + "</div>";
    	result.innerHTML = show;
    }
	else if(object=="course"){
		show = "<div id='show_change_course'  class='d_form'>"
        + "<h3>请输入修改课程信息</h3>"
        + "<input id='usednum' type='text' name='usednum' autocomplete='off' autofocus='autofocus' value placeholder='原课程号' required>"
		+ "<br/>"
 		+ "<input id='num' type='text' name='num' autocomplete='off' value placeholder='课程号' required>"
        + "<input id='name' type='text'  name='name' autocomplete='off'  value placeholder='课程名' required>"
        + "<input id='teacher' type='text' name='teacher' autocomplete='off' value placeholder='教师' required>"
		+ "<input id='score' type='text' name='score' autocomplete='off' value placeholder='学分' required>"
 		+ "<input id='time' type='text' name='time' autocomplete='off' value placeholder='时间' required>"
		+ "<input id='place' type='text' name='place' autocomplete='off' value placeholder='地点' required>"
        + "<input id='submit' onclick=change('course') type='button' name='submit' value='修改'>"
        + "</div>";
    	result.innerHTML = show;
	}
	else if(object=="score"){
		show = "<div id='show_change_score'  class='d_form'>"
        + "<h3>请输入修改成绩信息</h3>" 
        + "<input id='num' type='text' autocomplete='off' autofocus='autofocus' name='dnum' value placeholder='学号' required>"
        + "<input id='course' type='text' name='course' autocomplete='off' value placeholder='课程' required>"
		+ "<br/>"
 		+ "<input id='score' type='text' name='score' autocomplete='off'  value placeholder='分数' required>"
	 	+ "<input id='submit' onclick=change('score') type='button' name='submit' value='修改'>"
        + "</div>";
    	result.innerHTML = show;
	}
	else if(object=="achievement"){
		show = "<div id='show_change_achievement'  class='d_form'>"
        + "<h3>请输入修改社会成果信息</h3>"
        + "<input id='num' type='text' autocomplete='off' autofocus='autofocus' name='num' value placeholder='学号' required>"
        + "<input id='name' type='text' name='name' autocomplete='off' value placeholder='姓名' required>"
		+ "<input id='usedtime' type='text' name='usedtime' autocomplete='off' value placeholder='原时间' required>"
 		+ "<input id='useddetail' type='text' name='useddetail' autocomplete='off'  value placeholder='原成果' required>"
		+"<br/>"
 		+ "<input id='time' type='text' name='time' autocomplete='off' value placeholder='时间' required>"
 		+ "<input id='detail' type='text' name='detail' autocomplete='off' value placeholder='成果' required>"
	 	+ "<input id='submit' onclick=change('achievement') type='button' name='submit' value='修改'>"
        + "</div>";
    	result.innerHTML = show;
	}
	else{
		
	}
}
function insert(object) {
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
    if (object == "student") {
        var student = document.getElementById("show_insert_student").getElementsByTagName("input");
        var id = student[0].value;
        var password = student[1].value;
        var name=student[2].value;
        var card=student[3].value;
        var sex=student[4].value;
        var birth=student[5].value;
      	var age=student[6].value;
      	var minzu=student[7].value;
      	var ofClass=student[8].value;
      	var yuanxi=student[9].value;
        url = "/jiaowu/AdminServlet?action=insert_student&id=" + id + "&password=" + password
        +"&name=" +name+ "&card=" +card + "&sex=" +sex+ "&birth="+birth+"&age="+age+"&minzu="+minzu
        +"&ofClass=" +ofClass+"&yuanxi="+yuanxi; 
    }
    else if (object == "course") {
        var course = document.getElementById("show_insert_course").getElementsByTagName("input");
        var num = course[0].value;
        var name = course[1].value;
        var teacher=course[2].value;
        var score=course[3].value;
        var time=course[4].value;
		var place=course[5].value;
        url = "/jiaowu/AdminServlet?action=insert_course&num="+num+"&name="+name+"&teacher="+teacher+"&score="
		+score+"&time="+time+"&place="+place;
    }
    else if (object == "score") {
        var scorel = document.getElementById("show_insert_score").getElementsByTagName("input");
        var num = scorel[0].value;
        var name = scorel[1].value;
        var course = scorel[2].value;
		var score= scorel[3].value;
        url = "/jiaowu/AdminServlet?action=insert_score&num="+num+"&name="+name+"&course="
		+course+"&score="+score;
    }
    else if (object == "achievement") {
        var achievement = document.getElementById("show_insert_achievement").getElementsByTagName("input");
        var id = achievement[0].value;
        var name = achievement[1].value;
        var time = achievement[2].value;
       	var detail=achievement[3].value;
        url = "/jiaowu/AdminServlet?action=insert_achievement&id="+id+"&name="+name+"&time="+time+"&detail="+detail;
    }
    else {
        url = "/jiaowu/message.jsp";
    }
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function delete_student(){
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
    var stu=document.getElementById("show_delete_student").getElementsByTagName("input");
	var name=stu[0].value;
	var id=stu[1].value;
	url="/jiaowu/AdminServlet?action=delete_student&name="+name+"&id="+id;
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
}
function delete_course(){
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
    var course=document.getElementById("show_delete_course").getElementsByTagName("input");
	var id=course[0].value;
	var name=course[1].value;
	var teacher=course[2].value;
	url="/jiaowu/AdminServlet?action=delete_course&id="+id+"&name="+name+"&teacher="+teacher;
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
}
function delete_score(){
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
	var score=document.getElementById("show_delete_score").getElementsByTagName("input");
	var id=score[0].value;
	var name=score[1].value;
	var course=score[2].value;
	url="/jiaowu/AdminServlet?action=delete_score&id="+id+"&name="+name+"&course="+course;
	xmlhttp.open("GET",url,true);
	xmlhttp.send();
	
}
function delete_achievement(){
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
	var achievement=document.getElementById("show_delete_achievement").getElementsByTagName("input");
	var id=achievement[0].value;
	var name=achievement[1].value;
	var time=achievement[2].value;
	var detail=achievement[3].value;
	url="/jiaowu/AdminServlet?action=delete_achievement&id="+id+"&name="+name+"&time="+time+"&detail="+detail;
	xmlhttp.open("GET",url,true);
	xmlhttp.send();
}
function change(object){
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
	if(object=="student"){	
		var student=document.getElementById("show_change_student").getElementsByTagName("input");
		var usedid = student[0].value;
		var name=student[1].value;
        var password = student[2].value;
        var id=student[3].value;
        var card=student[4].value;
        var sex=student[5].value;
        var birth=student[6].value;
      	var age=student[7].value;
      	var minzu=student[8].value;
      	var ofClass=student[9].value;
      	var yuanxi=student[10].value;
		url="/jiaowu/AdminServlet?action=change_student&usedid="+usedid+"&name="+name+"&password="+password+
		"&id="+id+"&card="+card+"&sex="+sex+"&birth="+birth+"&age="+age+"&minzu="+minzu+"&ofClass="+ofClass
		+"&yuanxi="+yuanxi; 	
	}
	else if(object=="course"){
		var course=document.getElementById("show_change_course").getElementsByTagName("input");
		var usedid=course[0].value;
		var id=course[1].value;
		var name=course[2].value;
		var teacher=course[3].value;
		var score=course[4].value;
		var time=course[5].value;
		var place=course[6].value;
		url="/jiaowu/AdminServlet?action=change_course&usedid="+usedid+"&id="+id+"&name="+name+"&teacher="
		+teacher+"&score="+score+"&time="+time+"&place="+place;
	}
	else if(object=="score"){
		var score=document.getElementById("show_change_score").getElementsByTagName("input");
		var id=score[0].value;
		var course=score[1].value;
		var score=score[2].value;
		url="/jiaowu/AdminServlet?action=change_score&id="+id+"&course="+course+"&score="+score;
	}
	else if(object=="achievement"){
		var achievement=document.getElementById("show_change_achievement").getElementsByTagName("input");
		var id=achievement[0].value;
		var name=achievement[1].value;
		var usedtime=achievement[2].value;
		var useddetail=achievement[3].value;
		var time =achievement[4].value;
		var detail=achievement[5].value;
		url="/jiaowu/AdminServlet?action=change_achievement&id="+id+"&name="+name+"&usedtime="+usedtime+
		"&useddetail="+useddetail+"&time="+time+"&detail="+detail;
	}
	xmlhttp.open("GET",url,true);
	xmlhttp.send();
}
