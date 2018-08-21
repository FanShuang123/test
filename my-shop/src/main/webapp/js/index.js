//侧导航的选项卡
var aside=document.querySelectorAll(".aside ul li");
var item=document.querySelectorAll("#nav-tab");
var nav=document.querySelector("nav");
var flag=false;
    for(let i=0;i<item.length;i++){
        aside[i].onclick=function(e){
            itemDisplay(i);
            flag=true;

        };
        aside[i].onmouseover=function(e){
            if(flag){ 
                itemDisplay(i);
            }
        }

        item[i].onmouseleave=function(){
            for(let j=0;j<aside.length;j++){
            item[j].style.display="none";
        }
        flag=false;
    }
}
function itemDisplay(i){
    for(let j=0;j<aside.length;j++){
        item[j].style.display="none";
    }
    item[i].style.display="block";
}

// var lis= document.querySelector('.aside ul');
// var sidenav=document.querySelectorAll("sidenev")
// var item=document.querySelectorAll("#nav-tab");
//     lis.addEventListener('click', function(e){
//         var target = e.target || e.srcElement;
//         console.log(e)
//         if (target&&target.className.toLowerCase()=="sidenav") {
//             var that=target;
//             var index;
//             for(var i=0;i<item.length;i++)
//             if(sidenav  [i]===target){index=i};
//             console.log(index);
//             if(index>0){
//                 for(var j=0;j<item.length;j++){

//                     item[j].style.display="none";
//                   }
//               item[index].style.display="block";

//            }
//             }
              
//     })



//动态改变iframe标签的地址 
// var iframe=document.querySelector("#subject-cantent");
// item.forEach=function(ele,index){
//          ele.onclick=function(){
//              var itemId=0;
//             iframe.src=`"file:///D:/Program%20Files/my-shop/html/"+"itemId"+".html"`;
//          iframe.setAttribute("src","http")
//         };
//          } 

