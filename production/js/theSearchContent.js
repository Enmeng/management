function show(item){
	
    var newNode=item.parentNode;
    // alert(newNode.id);
    var string=newNode.id;
    var stringId=string.split("_");
    var tableId="table_"+stringId[1];
    document.getElementById(tableId).style.display="block";
}

function hide(item){
	
    var newNode=item.parentNode;
    // alert(newNode.id);
    var string=newNode.id;
    var stringId=string.split("_");
    var tableId="table_"+stringId[1];
    document.getElementById(tableId).style.display="none";
}