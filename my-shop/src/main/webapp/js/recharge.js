//选项卡
			window.onload=function(){
				var oDiv = document.getElementsByClassName("user_cont");
				var oBut = document.getElementsByClassName("but");
				oDiv[0].style.display="block";
				var ten = oBut[0];
				for (var i = 0;i<oBut.length;i++) {
					oBut[i].indent = i;
					//通过自定义属性获得下标值
					oBut[i].onclick=function() {
						ten.style.background="#1acdff";
						//点击时把上一个隐藏
						oDiv[ten.indent].style.display = "none";
						this.style.background = "#00B5F6"
						oDiv[this.indent].style.display = "block"
						ten = this
					}
				}
				//扣费续费部分
				var cDiv = document.getElementsByClassName("choose_cont");
				var cRadio = document.getElementsByName("money");
				cDiv[0].style.display="block";
				var tens = cRadio[0];
				for (var i = 0;i<cRadio.length;i++) {
					cRadio[i].indent = i;
					//通过自定义属性获得下标值
					cRadio[i].onclick=function() {
						//点击时把上一个隐藏
						cDiv[tens.indent].style.display = "none";
						cDiv[this.indent].style.display = "block"
						tens = this
					}
				}
				//充值记录部分
				var nDiv = document.getElementsByClassName("notes_cont");
				var nBut = document.getElementsByClassName("notes_but");
				nDiv[0].style.display="block";
				var nten = nBut[0];
				for (var i = 0;i<nBut.length;i++) {
					nBut[i].indent = i;
					//通过自定义属性获得下标值
					nBut[i].onclick=function() {
						nten.style.background="#1acdff";
						//点击时把上一个隐藏
						nDiv[nten.indent].style.display = "none";
						this.style.background = "#00B5F6"
						nDiv[this.indent].style.display = "block"
						nten = this
					}
				}
			}
			//超链接
			function addMoney() {
				alert("请到全局设置中开启员工提成");
			}
			//点击出现会员列表
			
			function seach() {
				if(document.getElementById("search_result").style.display=="none"){
					document.getElementById("search_result").style.display="block";
				}else{
					document.getElementById("search_result").style.display="none";
				}
			}