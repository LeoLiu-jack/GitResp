
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<%--加入base路径之后，所有的只能是绝对路径，不能是相对路径
所有的前端资源都是在web文件路径下开始寻找的--%>
  <head>
    <base href="<%=basePath%>">
    <title>$Title$</title>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script>

      $(function(){
        //alert(123)
        //在id=msg的div里面添加内容
        //第一步：拿到div元素
        //第二步：往div里面添加内容
        $("#djBtn").click(function () {

          $.ajax({
            url:"myServlet04.do",//访问后台Servlet地址
            type:"get",//请求方式：get/post
            dataType:"json",//从后台接受数据的方式,json格式
            //json处理数据，对象的集合或者单纯的只是数据，成功实现了前后端分离

            //async:true,//异步请求为假，即同步
            success:function (data) {//回调函数，该函数的执行时机是后台执行完毕后，该函数才会执行
              alert(data);

              $("#id1").html(data.s1.id);
              $("#name1").html(data.s1.name);
              $("#age1").html(data.s1.age);
              $("#id2").html(data.s2.id);
              $("#name2").html(data.s2.name);
              $("#age2").html(data.s2.age);

            }
          })
        })

      })
    </script>

  </head>
  <body>
  <button id="djBtn">点击按钮</button>
  <br/>
  学员1:<br/>
  编号：<span id="id1"></span><br/>
  姓名：<span id="name1"></span><br/>
  年龄：<span id="age1"></span><br/>
  <br/>
  学员2:<br/>
  编号：<span id="id2"></span><br/>
  姓名：<span id="name2"></span><br/>
  年龄：<span id="age2"></span><br/>

  </body>
</html>
