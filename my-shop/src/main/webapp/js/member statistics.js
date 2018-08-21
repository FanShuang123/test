  // 表格的生成时间
  function showTime(){
    nowtime=new Date();
    year=nowtime.getFullYear();
    month=nowtime.getMonth()+1;
    date=nowtime.getDate();
    document.querySelector("#span").innerText=year+"年"+month+"月"+date+" "+nowtime.toLocaleTimeString(); 
    };
    showTime();