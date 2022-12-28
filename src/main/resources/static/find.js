function findAffiliate(){
	const id=inputFindAff.value;
	fetch(`http://localhost:8080/affiliates/consultarAffiliatesById/${id}`)
	 
    	.then(response=>response.json()) 
	
		.then(data=> {
			tbodyAff.innerHTML="";
			var row = document.createElement('tr');
			Object.keys(data).forEach(function(key) {
				var cell=document.createElement('td');
				cell.textContent = data[key];
				row.appendChild(cell);
			});
			var editarBtn = document.createElement('button');
        	editarBtn.innerHTML="Editar";
        
      
        	var eliminarBtn = document.createElement('button');
        	eliminarBtn.innerHTML="Eliminar";
        	//eliminarBtn.setAttribute("class","delete-button")
        	//eliminarBtn.setAttribute("data-id",item.id)
        
        	var celled = document.createElement('td');
        	var cellel = document.createElement('td');
        
        	celled.appendChild(editarBtn);
        	cellel.appendChild(eliminarBtn);
          
        	row.appendChild(celled);
        	row.appendChild(cellel);
			
			tbodyAff.appendChild(row);
			tableAff.appendChild(tbodyAff);		
		})
		.catch(function(error) {
	
		});
}

function findApp(){
	const id=inputFindApp.value;
	fetch(`http://localhost:8080/appoinments/consultarAppoinmentById/${id}`)
	 
	.then(response=>response.json()) 
  
	.then(data=> {
			
		tbodyApp.innerHTML="";
		var row = document.createElement('tr');
		  
		createCells(data,row);
   
		var editarBtn = document.createElement('button');
		editarBtn.innerHTML="Editar";
		
		var eliminarBtn = document.createElement('button');
		eliminarBtn.innerHTML="Eliminar";
		
		var celled = document.createElement('td');
		var cellel = document.createElement('td');
		
		celled.appendChild(editarBtn);
		cellel.appendChild(eliminarBtn);
		  
		row.appendChild(celled);
		row.appendChild(cellel);
			
		tbodyApp.appendChild(row);
	  
	  
	    tableApp.appendChild(tbodyApp);
	})
	
	.catch(function(error) {
	  
	});
   
}
		  


function findTest(){
	const id=inputFindTes.value;
	fetch(`http://localhost:8080/tests/consultarTestById/${id}`)
	 
    	.then(response=>response.json()) 
	
		.then(data=> {
			tbodyTes.innerHTML="";
			var row = document.createElement('tr');
			Object.keys(data).forEach(function(key) {
				var cell=document.createElement('td');
				cell.textContent = data[key];
				row.appendChild(cell);
			});
			var editarBtn = document.createElement('button');
        	editarBtn.innerHTML="Editar";
        
      
        	var eliminarBtn = document.createElement('button');
        	eliminarBtn.innerHTML="Eliminar";
        	//eliminarBtn.setAttribute("class","delete-button")
        	//eliminarBtn.setAttribute("data-id",item.id)
        
        	var celled = document.createElement('td');
        	var cellel = document.createElement('td');
        
        	celled.appendChild(editarBtn);
        	cellel.appendChild(eliminarBtn);
          
        	row.appendChild(celled);
        	row.appendChild(cellel);
			
			tbodyTes.appendChild(row);
			tableTes.appendChild(tbodyTes);		
		})
		.catch(function(error) {
	
		});
}