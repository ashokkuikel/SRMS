//JavaScript codes

//function goNewWin() {
//
////***Get what is below onto one line***
//
//window.open("login.jsp",'TheNewpop','toolbar=1,
//location=1,directories=1,status=1,menubar=1,
//scrollbars=1,resizable=1'); 
//
////***Get what is above onto one line*** 
//
//self.close()
//
//}


function reload(){
    var container=document.getElementsByClassName("reload");
    var content=container.innerHTML;
    container.innerHTML=content;
}