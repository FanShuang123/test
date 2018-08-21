

//判断账号是否符合规范
function checkUserName(){
    var name=document.querySelector("#inputtext")
    //var userDivId=$("#userName_msg");
    // userDivId.html("");	
    var reg=/^[a-zA-Z][a-zA-Z0-9]{3,15}$/;	
      if(reg.test(name.value)==false){
        //userDivId.html("<font color='red'>用户名不正确</font>");
        alert("用户名不正确")
      return false;
      }
        return true;
      }
      checkUserName();


      //判断账号是否符合规范
      function checkPwd(){
        var password=document.getElementById("#inputPassword")
        //var pwdDivId=$("#userPwd_msg");
        // pwdDivId.html("");	
        var reg=/^[a-zA-Z0-9]{4,10}$/;	
          if(reg.test(password.value)==false){
            // pwdDivId.html("<font color='red'>密码不能含有非法字符，长度4-10之间</font>
            alert("密码不正确")
          return false;
            }
            return true;
          }
          checkPwd();
   