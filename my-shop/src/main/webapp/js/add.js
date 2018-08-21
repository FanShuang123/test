 // 下方文本框
tab();
function tab(){ 
    var frames=document.querySelectorAll("#text");
    var opts=document.querySelectorAll(".remarks");
            opts.forEach(function(ele,index){
                ele.onclick=function(){
                    frames.forEach(function(ele){ 
                        ele.style.display="none";            //让所有的样式隐藏
                        frames[index].style.display="block"; //让当前点击的frame出现
                    })
                }
        })
        opts[0].click();// 默认让它初始为第一个
}

//设置过期时间的禁选
   var yes=document.querySelector(".yes");
   var no=document.querySelector(".no");
   yes.onclick=function(){
     if(yes.checked){
         no.disabled=false;
     }else {
         no.disabled=true;
     }
   }


