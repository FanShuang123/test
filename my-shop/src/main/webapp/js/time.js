//    会员消费的消费时间
function showTime(){
    nowtime=new Date();
    year=nowtime.getFullYear();
    month=nowtime.getMonth()+1;
    date=nowtime.getDate();
    document.querySelector(".time").innerText=year+"年"+month+"月"+date+" "+nowtime.toLocaleTimeString();
};
setInterval("showTime()",1000);

