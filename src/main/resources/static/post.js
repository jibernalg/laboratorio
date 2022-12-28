function postAffiliate(){
	const formAff=document.querySelector('.formAff');
	const formDataAff= new FormData(formAff);
	const resAff=Object.fromEntries(formDataAff);
	const payloadAff=JSON.stringify(resAff);
		
	fetch('http://localhost:8080/affiliates/guardarAffiliates', {
		method:"POST",
		body:payloadAff,
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

function postApp(){

	const formApp=document.querySelector('.formApp');
	const formDataApp= new FormData(formApp);

	const idTest=formDataApp.get('id_test');
	const idAffiliate=formDataApp.get('id_affiliate');
		
	
	const date = new Date(formDataApp.get('date_ap'));
	const isoString=date.toISOString();
	const[year,month,day]=isoString.substring(0,10).split('-');
	const formattedDate=`${day}-${month}-${year}`;
 
	
	const test={id: idTest};
	const affiliate={id: idAffiliate};

	const payloadApp=JSON.stringify({
		date_ap:formattedDate,
		hour_ap:formDataApp.get('hour_ap'),
		id_test:test,
		id_affiliate:affiliate
	});

	console.log(payloadApp)

		
	fetch('http://localhost:8080/appoinments/guardarAppoinment', {
		method:"POST",
		body:payloadApp,
		headers:{
			'Content-Type': 'application/json',
		}
	}).then(response=>{
		if(response.ok){
			initialLoadApp();
			console.log("exito");
		}else{
			console.log("error");
		}
	})	
}

function postTest(){
	const formTes=document.querySelector('.formTes');
	const formDataTes= new FormData(formTes);
	const resTes=Object.fromEntries(formDataTes);
	const payloadTes=JSON.stringify(resTes);
	
	fetch('http://localhost:8080/tests/guardarTest', {
		method:"POST",
		body:payloadTes,
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