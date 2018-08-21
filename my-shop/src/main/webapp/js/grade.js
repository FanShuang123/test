


// 选项卡
  var box=document.querySelector("#box");
  var optst=document.querySelector("#st");
  var optnd=document.querySelector("#nd");
   optst.onclick=function(){
       box.style.transform="translateY(0)";
   }
    optnd.onclick=function(){
        box.style.transform="translateY(-220px)";
    }

    //select 变化
    var province=document.querySelector("#province");
    var money=document.querySelector("#money");
    var a=0;
    province.onchange=function(){
        if(a%2=="1"){
        money.innerHTML="元";
         }else{
            money.innerHTML="%";
         }
         a++;
    }