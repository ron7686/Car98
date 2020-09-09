$(function () {
    $('[data-toggle="tooltip"]').tooltip()
  })

  function startTime()   
            {   
                var today=new Date();//定義日期物件   
                var yyyy = today.getFullYear();//通過日期物件的getFullYear()方法返回年    
                var MM = today.getMonth()+1;//通過日期物件的getMonth()方法返回年    
                var dd = today.getDate();//通過日期物件的getDate()方法返回年     
                var hh=today.getHours();//通過日期物件的getHours方法返回小時   
                var mm=today.getMinutes();//通過日期物件的getMinutes方法返回分鐘   
                var ss=today.getSeconds();//通過日期物件的getSeconds方法返回秒   
                // 如果分鐘或小時的值小於10，則在其值前加0，比如如果時間是下午3點20分9秒的話，則顯示15：20：09   
                MM=checkTime(MM);
                dd=checkTime(dd);
                mm=checkTime(mm);   
                ss=checkTime(ss);    
                var day; //用於儲存星期（getDay()方法得到星期編號）
                if(today.getDay()==0)   day   =   "星期日 " 
                if(today.getDay()==1)   day   =   "星期一 " 
                if(today.getDay()==2)   day   =   "星期二 " 
                if(today.getDay()==3)   day   =   "星期三 " 
                if(today.getDay()==4)   day   =   "星期四 " 
                if(today.getDay()==5)   day   =   "星期五 " 
                if(today.getDay()==6)   day   =   "星期六 " 
                document.getElementById('nowDateTimeSpan').innerHTML=yyyy+"-"+MM +"-"+ dd +" " + hh+":"+mm+":"+ss+"   " + day;   
                setTimeout('startTime()',1000);//每一秒中重新載入startTime()方法 
            }   

            function checkTime(i)   
            {   
                if (i<10){
                    i="0" + i;
                }   
                  return i;
              }