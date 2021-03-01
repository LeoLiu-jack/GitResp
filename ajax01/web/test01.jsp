
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
          //$("#msg").html(777);//点击按钮之后在msg的div里面，添加777
          /*

          关于同步和异步：

          设置
            async:true 异步
              通过观察得到结果，下面的alert弹框没有等到上面的ajax执行完毕，就执行了
              全程是两根线程，一根主线程负责执行方法中普通的代码，一根线程负责执行ajax
              两根线程彼此之间相互独立，互相是不受影响的

            async:false 同步
              通过观察得到结果，下面的alert弹框必须要等到上面的ajax执行完毕后，才能够执行
              全程是一根线程，线程是按照代码从上向下的顺序依次执行
              下面的代码必须要等到上面的代码执行完毕后，才能够执行


             未来实际项目开发中，一般情况下，我们都是使用异步请求可以有效的提升用户体验
             在特殊需求下，也会使用到同步


         */
          $.ajax({
            url:"myServlet01.do",//访问后台Servlet地址
            data:"key1=value1&key2=value2",//为后台传递的参数
            type:"get",//请求方式：get/post
            dataType:"text",//从后台接受数据的方式
            async:true,//异步请求为假，即同步
            success:function (data) {//回调函数，该函数的执行时机是后台执行完毕后，该函数才会执行
              //data:从后台响应回来的数据
              $("#msg").html(data);

            }
          })
          alert(123);
        })

      })
    </script>

  </head>
  <body>
  <button id="djBtn">点击按钮</button>
  <br/>
  <div id="msg" style="width: 200px;height: 200px;background-color: pink"></div>
  <br/>
  <div style="width: 200px;height: 200px;background-color: pink">
  </div>
  </body>
</html>
