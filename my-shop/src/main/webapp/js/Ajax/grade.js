var jpage ;

$(function(){
	
	showMemberGradeForPage();
	
	$("#save").click(function(){
		
		addMemberGrade();
		clear1('memberGradeForm');
		
	});

	
	

	
});
/**
 * 清空form表单内容
 */
function clear1(formId){
	
	document.getElementById(formId).reset();
}
function addMemberGrade(){
	
	var data = $("#memberGradeForm").serialize();
	$.ajax({
	    url: "../../addMemberGrade",
	    data: data,
	    type: "post",
//	    dataType :"text",
	})

	  success:(function() {
	   alert("等级添加成功");
	   
		 jpage.loadData();
		
	  })

//	  .fail(function( xhr, status, errorThrown ) {
//	    alert( "Sorry, there was a problem!" );
//	    console.log( "Error: " + errorThrown );
//	    console.log( "Status: " + status );
//	    console.dir( xhr );
//	  
//
//	  });	
	
	
}
/**
 * 加载等级列表
 */
function showMemberGradeForPage(){
	jpage = $("#jpage").jpage({
		 url:"../../showMemberGradeForPage",
//		 pageSize:9,//每页显示条数
		 step:5,	// 步长   5 7 9
		 loadData:function(data) {  // 加载数据 入口 主动调用
			//alert($("#sname").val());
//			data.name = $("#sname").val(); //action name
			//data["BEAN.name"] = $("#sname").val();
		 },
		 beforeSend:function() {
			 
		 },
		 success:function(data,idx) {  //data -- list
			 var arr= [];
//			 alert(data.length);
			 for (var i = 0; i < data.length; i++) {
				

				 arr.push("<tr class=\"lv\">");
//				 arr.push(" <td>"+data[i].id+"</td>");
//				 arr.push("<td>"+data[i].id+"</td>");
				 arr.push("<td>"+idx++ +"</td>");
				 arr.push("<td>"+data[i].gradeName+"</td>");
				 arr.push("<td>"+data[i].gradeScore+"</td>");
				 arr.push("<td>"+data[i].gradeExchangeRatio+"</td>");
				 arr.push("<td>"+data[i].gradeGeneralDisRatio+"</td>");
				 arr.push("<td>"+data[i].gradeServeDisRatio+"</td>");
				 arr.push("<td>" +
				 		 " <a href=\"javascript:delMemberGradeById("+data[i].gradeId+");\">删</a>" +
				 		 " <a href=\"javascript:findMemberGradeById("+data[i].gradeId+");\">改</a>" +
				 		 "</td>");
				 arr.push("</tr>");
			}
			 var arrs = arr.join("");
			 $("#datas").html(arrs);
//			 clear1('memberGradeForm');//这里如果调用了的话就会无限死循环加载
//			 jpage.loadData(); //这里如果调用了的话就会无限死循环加载
			
		 }	 
});
	
	jpage.loadData();
}
/**
 * 先查找.把等级信息显示到form表单上     (后端)如果form表单上边没有id 就走添加方法,如果有id就走修改方法
 */
function findMemberGradeById(id){
	
	$.ajax({
		url: "../../findMemberGradeById",
		data:{"gradeId":id},
		type: "post",
		dataType :"json",
	})
	
	.done(function(json){
		
		
		alert(json);
		
	});
	
}
/**
 * 删除   后台实际上是修改了state 属性
 */
function delMemberGradeById (gradeId){
	$.ajax({
		url: "../../delMemberGradeById",
		data:{"gradeId":gradeId},
		type: "post",
//		dataType :"json",
	})
	
	.done(function(){
		
		
	});
}

function updateById (gradeId){
	$.ajax({
		url: "../../updateGradeById",
		data:{"gradeId":gradeId},
		type: "post",
		dataType :"json",
	})
	
	.done(function(json){
		alert(json);
		
	});
}
//	  function showMemberGradeForPage(){
//		$.ajax({
//			url: "../../showMemberGradeForPage",
////	    data: data,
//			type: "post",
//			dataType :"json",
//		})
//		
//		.done(function(json) {
//			alert(json);
//			
//		})