function deleteAffiliate(){
    
	const id=inputDelAff.value;
	fetch(`http://localhost:8080/affiliates/eliminarAffiliates/${id}`, {
		method:"DELETE",
		headers:{
			'Content-Type': 'application/json',
		}
	}).then(response=>{
		if(response.ok){
			initialLoadAff();
			
		}else{
			console.log("No se elimino ningun elemento");
		}
	})		
}

function deleteApp(){
    
	const id=inputDelApp.value;
	fetch(`http://localhost:8080/appoinments/eliminarAppoinment/${id}`, {
		method:"DELETE",
		headers:{
			'Content-Type': 'application/json',
		}
	}).then(response=>{
		if(response.ok){
			initialLoadApp();
			
		}else{
			console.log("No se elimino ningun elemento");
		}
	})		
}

function deleteTest(){
    
	const id=inputDelTes.value;
	fetch(`http://localhost:8080/tests/eliminarTest/${id}`, {
		method:"DELETE",
		headers:{
			'Content-Type': 'application/json',
		}
	}).then(response=>{
		if(response.ok){
			initialLoadTes();
			
		}else{
			console.log("No se elimino ningun elemento");
		}
	})		
}