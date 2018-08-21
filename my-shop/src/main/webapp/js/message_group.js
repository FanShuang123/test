window.onload=function(){
				var oDiv = document.getElementsByClassName("megs_cont");
				var oBut = document.getElementsByClassName("but");
				oDiv[oBut.length-1].style.display="block";
				var ten = oBut[oBut.length-1];
				for (var i = 0;i<oBut.length;i++) {
					oBut[i].indent = i;
					//通过自定义属性获得下标值
					oBut[i].onclick=function() {
						ten.style.background="#1acdff";
						//点击时把上一个隐藏
						oDiv[ten.indent].style.display = "none";
						document.getElementById("Thirdframe").style.display = "none";
						this.style.background = "#00B5F6"
						oDiv[this.indent].style.display = "block";
						ten = this
					}
				}
				
				//获取当前系统时间
				function getNowFormatDate() {
				    var date = new Date();
				    var seperator1 = "/";
				    var seperator2 = ":";
				    var month = date.getMonth() + 1;
				    var strDate = date.getDate();
				    if (month >= 1 && month <= 9) {
				        month = "0" + month;
				    }
				    if (strDate >= 0 && strDate <= 9) {
				        strDate = "0" + strDate;
				    }
				    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
				            + " " + date.getHours() + seperator2 + date.getMinutes()
				            + seperator2 + date.getSeconds();
				    return currentdate;
				}
				document.getElementById("sj").value=getNowFormatDate();
				document.getElementById("sjs").value=getNowFormatDate();
			}
			//定时发送失效
			function ds() {
				var displays = document.getElementById("sj");
				document.getElementById("sjs").disabled=false;
				displays.disabled=false;
			}
			//即时发送失效
			function js() {
				var displays = document.getElementById("sj");
				document.getElementById("sjs").disabled=true;
				displays.disabled=true;
			}
			//点击出现会员列表
			
			function seach() {
				if(document.getElementById("search_result").style.display=="none"){
					document.getElementById("search_result").style.display="block";
				}else{
					document.getElementById("search_result").style.display="none";
				}
			}
			function sel() {
				if (document.getElementById("sel_1").value==2) {
					document.getElementById("cen").innerHTML="尊敬的客户：您尾号为{LCardID}的会员卡，于{Time}在本店消费{TempMoney}元，账户余额{Money}元，感谢您的光临！";
				}else if(document.getElementById("sel_1").value==3){
					document.getElementById("cen").innerHTML="尊敬的客户：您尾号为{LCardID}的会员卡，于{Time}在本店充值{TempMoney}元，账户余额{Money}元，感谢您的光临！";
				}else if(document.getElementById("sel_1").value==4){
					document.getElementById("cen").innerHTML="尊敬的客户：您尾号为{LCardID}的记次卡，于{Time}在本店充次{TempMoney}元，账户剩余{Count}次，感谢您的光临！";
				}else if(document.getElementById("sel_1").value==5){
					document.getElementById("cen").innerHTML="尊敬的客户：您尾号为{LCardID}的会员卡，于{Time}在本店花费{TempPoint}分兑换礼品，账户剩余{Point}分，感谢您的光临！";
				}else if(document.getElementById("sel_1").value==6){
					document.getElementById("cen").innerHTML="尊敬的{Name}，您已成为本店会员，期待您的光临！";
				}else{
					document.getElementById("cen").innerHTML="";
				}
			}
			function sel2() {
				if (document.getElementById("sel_2").value==2) {
					document.getElementById("cen_2").innerHTML="尊敬的客户：您尾号为{LCardID}的会员卡，于{Time}在本店消费{TempMoney}元，账户余额{Money}元，感谢您的光临！";
				}else if(document.getElementById("sel_2").value==3){
					document.getElementById("cen_2").innerHTML="尊敬的客户：您尾号为{LCardID}的会员卡，于{Time}在本店充值{TempMoney}元，账户余额{Money}元，感谢您的光临！";
				}else if(document.getElementById("sel_2").value==4){
					document.getElementById("cen_2").innerHTML="尊敬的客户：您尾号为{LCardID}的记次卡，于{Time}在本店充次{TempMoney}元，账户剩余{Count}次，感谢您的光临！";
				}else if(document.getElementById("sel_2").value==5){
					document.getElementById("cen_2").innerHTML="尊敬的客户：您尾号为{LCardID}的会员卡，于{Time}在本店花费{TempPoint}分兑换礼品，账户剩余{Point}分，感谢您的光临！";
				}else if(document.getElementById("sel_2").value==6){
					document.getElementById("cen_2").innerHTML="尊敬的{Name}，您已成为本店会员，期待您的光临！";
				}else{
					document.getElementById("cen_2").innerHTML="";
				}
			}