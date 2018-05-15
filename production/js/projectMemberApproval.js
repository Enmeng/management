function test(obj){
	alert("审批成功");
	var objId=obj.id;
	var stringId=objId.split("_");
	// alert(stringId[1]);
	var checkboxId="it_"+stringId[1];
	var cks=document.getElementById(checkboxId);
	if(cks.type=="checkbox"){
		cks.checked=true;
	}

}