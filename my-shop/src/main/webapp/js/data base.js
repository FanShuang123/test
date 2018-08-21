tab();
function tab(){
        var frames=document.querySelectorAll(".frame");
        var opts=document.querySelectorAll("#opt");
            opts.forEach(function(ele,index){   //遍历          
                ele.onclick=function(){
                    frames.forEach(function(ele){ 
                        ele.style.display="none";            //让所有的样式隐藏
                        frames[index].style.display="block"; //让当前点击的frame出现
                    })
                }
        })
        opts[0].click();   // 默认让它初始为第一个
}