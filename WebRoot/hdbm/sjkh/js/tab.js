
function qiehuan1(num){
for(var id = 1;id<=7;id++){
if(id==num){document.getElementById("tit_"+id).className="z_maingba_off";document.getElementById("box_"+id).className="z_maingba_box_block";}
else{document.getElementById("tit_"+id).className="z_maingba_on";document.getElementById("box_"+id).className="z_maingba_box_on";}
}}
