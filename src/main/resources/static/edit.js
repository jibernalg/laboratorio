function editAffiliate(){
    
    const formEditAff=document.querySelector('.editFormAff');
	const formDataEditAff= new FormData(formEditAff);
	
	const resEditAff=Object.fromEntries(formDataEditAff);
	const payloadEditAff=JSON.stringify(resEditAff);

	fetch('http://localhost:8080/affiliates/actualizarAffiliates', {
		method:"PUT",
        body:payloadEditAff,
		headers:{
			'Content-Type': 'application/json',
		}
	}).then(response=>{
		if(response.ok){
			initialLoadAff();
		}else{
			
		}
	})		
}

function editApp(){
    
    const formEditApp=document.querySelector('.editFormApp');
	const formDataEditApp= new FormData(formEditApp);
	
	
	const idTest=formDataEditApp.get('id_test');
	const idAffiliate=formDataEditApp.get('id_affiliate');
		
	
	const date = new Date(formDataEditApp.get('date_ap'));
	const isoString=date.toISOString();
	const[year,month,day]=isoString.substring(0,10).split('-');
	const formattedDate=`${day}-${month}-${year}`;
 
	
	const test={id: idTest};
	const affiliate={id: idAffiliate};

	const payloadEditApp=JSON.stringify({
		id:formDataEditApp.get('id'),
		date_ap:formattedDate,
		hour_ap:formDataEditApp.get('hour_ap'),
		id_test:test,
		id_affiliate:affiliate
	});

	fetch('http://localhost:8080/appoinments/actualizarAppoinment', {
		method:"PUT",
        body:payloadEditApp,
		headers:{
			'Content-Type': 'application/json',
		}
	}).then(response=>{
		if(response.ok){
			initialLoadApp();
		}else{
			
		}
	})		
}

function editTest(){
    
    const formEditTes=document.querySelector('.editFormTes');
	const formDataEditTes= new FormData(formEditTes);
	
	const resEditTes=Object.fromEntries(formDataEditTes);
	const payloadEditTes=JSON.stringify(resEditTes);

	fetch('http://localhost:8080/tests/actualizarTest', {
		method:"PUT",
        body:payloadEditTes,
		headers:{
			'Content-Type': 'application/json',
		}
	}).then(response=>{
		if(response.ok){
			initialLoadTes();
		}else{
			
		}
	})		
}