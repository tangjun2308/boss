window.onload = function(){
    var thisURL = document.URL;
    var getval = thisURL.split('?')[1];
    var showval= getval.split("=")[1];
    
    
    $("#showDetail").attr('href',"detail.html?id=" + showval);
    

}