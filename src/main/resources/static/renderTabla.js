const tbodyAff=document.querySelector('.tbodyAff');
const tableAff=document.querySelector('.tableAff');

function initialLoadAff(){

fetch('http://localhost:8080/affiliates/consultarAffiliates')
   
  .then(response=>response.json()) 
  
  .then(data=> {
          
    tbodyAff.innerHTML="";
                 
    data.forEach(function(item) {
      var row = document.createElement('tr');
 
      Object.keys(item).forEach(function(key) {
        var cell = document.createElement('td');
        cell.textContent = item[key];
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
    });
    
    tableAff.appendChild(tbodyAff);
  })
  
  .catch(function(error) {
    
  });
 
}

const tbodyApp=document.querySelector('.tbodyApp');
const tableApp=document.querySelector('.tableApp');

function initialLoadApp(){

fetch('http://localhost:8080/appoinments/consultarAppoinments')
   
  .then(response=>response.json()) 
  
  .then(data=> {
          
    tbodyApp.innerHTML="";
                 
    data.forEach(function(item) {
      var row = document.createElement('tr');

      createCells(item,row);
 
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
    });
    
    tableApp.appendChild(tbodyApp);
  })
  
  .catch(function(error) {
    
  });
 
}
function createCells(obj, row) {
  Object.keys(obj).forEach(function(key) {
    var cell = document.createElement('td');
    if (typeof obj[key] === 'object') {
      createCells(obj[key], row);
    } else {
      cell.textContent = obj[key];
      row.appendChild(cell);
    }
  });
}



const tbodyTes=document.querySelector('.tbodyTes');
const tableTes=document.querySelector('.tableTes');

function initialLoadTes(){

fetch('http://localhost:8080/tests/consultarTests')
   
  .then(response=>response.json()) 
  
  .then(data=> {
          
    tbodyTes.innerHTML="";
                 
    data.forEach(function(item) {
      var row = document.createElement('tr');
 
      Object.keys(item).forEach(function(key) {
        var cell = document.createElement('td');
        cell.textContent = item[key];
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
    });
    
    tableTes.appendChild(tbodyTes);
  })
  
  .catch(function(error) {
    
  });
 
}



