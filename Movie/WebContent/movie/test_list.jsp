<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../../Movie/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('#btn').click(function(){
			var name = $("#na").val();
			
			$.ajax({
				url:"MovieList.me",
				method:"get",
				dataType :"json",
				data:{name:name},
				success:function(data){
					$.each(data,function(data,item){
						
					$('table').append("<tr><th>"+item.title+"</th><th>"+item.director+"</th><th>"+item.actor+"</th><th>"+item.userRating
							+"</th><th><img src="+item.image+"></th></tr>")
					});
					
					
				}
				
			});
			
// 			$.getJSON('MovieList.me',function(data){
// 				$.each(data,function(index,item){
// 					$('table').append("<tr><th>"+item.title+"</th><th>"+item.director+"</th><th>"+item.actor+"</th><th>"+item.userRating
// 							+"</th><th><img src="+item.image+"></th></tr>")
// 				});
// 			});
		});
	});
</script>
</head>
<body>
	 <input type="text" id="na" name="na">
	 <input type="submit" id="btn" value="버튼">
<table border="1">
<tr><th>타이틀</th><th>디렉터</th><th>액터</th><th>평점</th><th>썸네일</th></tr>
</table>
</body>
</html>

