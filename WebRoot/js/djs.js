var interval = 1000; 
function ShowCountDown(year,month,day) 
{ 
var now = new Date(); 
var endDate = new Date(year, month-1, day); 
var leftTime=endDate.getTime()-now.getTime(); 
var leftsecond = parseInt(leftTime/1000); 
//var day1=parseInt(leftsecond/(24*60*60*6)); 
var day1=Math.floor(leftsecond/(60*60*24)); 
var hour=Math.floor((leftsecond-day1*24*60*60)/3600); 
var minute=Math.floor((leftsecond-day1*24*60*60-hour*3600)/60); 
var second=Math.floor(leftsecond-day1*24*60*60-hour*3600-minute*60); 
var day = document.getElementById('dayId');
var hour1 = document.getElementById('hourId');
var minute1 = document.getElementById('minuteId');
var second1 = document.getElementById('secondId');
day.innerHTML=day1;
hour1.innerHTML=hour;
minute1.innerHTML=minute;
second1.innerHTML=second;
} 
window.setInterval(function(){
	ShowCountDown(2014,11,11);
	}, interval); 