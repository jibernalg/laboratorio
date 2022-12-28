//ZONA MENU INICIAL
//Boton afiliados
const affBtn=document.querySelector('.affBtn');
affBtn.addEventListener('click',function(){
    toggleHiddenMenuAff();
})

//Boton citas
const appBtn=document.querySelector('.appBtn');
appBtn.addEventListener('click',function(){
    toggleHiddenMenuApp();
})

//Boton examenes
const tesBtn=document.querySelector('.tesBtn');
tesBtn.addEventListener('click',function(){
    toggleHiddenMenuTes();
})



//ZONA USUARIOS---------------------------------------------------------
//Boton agregar
const addAffBtn=document.querySelector('.addAffBtn');
addAffBtn.addEventListener('click',function(){
    toggleHiddenAffAgg();  
})

//Boton crear
const crearAffBtn=document.querySelector("#crearAffBtn");
crearAffBtn.addEventListener('click',function(){
    postAffiliate();
    clearAllAff();
    toggleHiddenAffAgg();
})

//Boton limpiar
const nameAff = document.querySelector("#nameAff");
const ageAff = document.querySelector("#ageAff"); 
const mailAff = document.querySelector("#mailAff");

function clearAllAff(){
    nameAff.value="";
    ageAff.value="";
    mailAff.value="";
}

const clearAffBtn=document.querySelector("#clearAffBtn");
clearAffBtn.addEventListener('click',function(){
    clearAllAff();
})

//Boton ver todos
const allAffBtn=document.querySelector(".allAffBtn");
allAffBtn.addEventListener('click',function(){
    initialLoadAff();    
})
//Boton ver lista
const verListaAffBtn=document.querySelector("#verAffTabla");
verListaAffBtn.addEventListener('click',function(){
    initialLoadAff();    
    toggleHiddenAffAgg();
})

//Boton consultar
const inputFindAff = document.querySelector("#inputFindAff");
const findAffBtn=document.querySelector('.findAffBtn');
findAffBtn.addEventListener('click',function(){
    findAffiliate();
    inputFindAff.value="";
})

//Boton editar
const inputAffEdit = document.querySelector("#inputAffEdit");
const editAffBtn=document.querySelector('.editAffBtn');
editAffBtn.addEventListener('click',function(){
    toggleHiddenAffEdit();  
    
})

//Boton actualizar
const actAffBtn=document.querySelector("#updateAffBtn");
actAffBtn.addEventListener('click',function(){
    editAffiliate();    
    clearAllAff();
    toggleHiddenAffEdit();
})

//Boton eliminar
const inputDelAff = document.querySelector("#inputDelAff");
const delAffBtn=document.querySelector('.delAffBtn');
delAffBtn.addEventListener('click',function(){
    deleteAffiliate();
    inputDelAff.value="";
})

//Boton volver
const backAffBtn=document.querySelector('.backAffBtn');
backAffBtn.addEventListener('click',function(){
    toggleHiddenMenuAff();
})


//ZONA CITAS-----------------------------------------------------------
//Boton agregar
const addAppBtn=document.querySelector('.addAppBtn');
addAppBtn.addEventListener('click',function(){
    toggleHiddenAppAgg();  
})

//Boton crear
const crearAppBtn=document.querySelector("#crearAppBtn");
crearAppBtn.addEventListener('click',function(){
    postApp();
    clearAllApp();
    toggleHiddenAppAgg();
})

//Boton limpiar
const fechaApp = document.querySelector("#date_ap");
const horaApp = document.querySelector("#hour_ap"); 
const idtest = document.querySelector("#id_test"); 
const idaffiliate = document.querySelector("#id_affiliate"); 

function clearAllApp(){
    fechaApp.value="";
    horaApp.value="";
    idtest.value="";
    idaffiliate.value="";
}

const clearAppBtn=document.querySelector("#clearAppBtn");
clearAppBtn.addEventListener('click',function(){
    clearAllApp();
})

//Boton ver todos
const allAppBtn=document.querySelector(".allAppBtn");
allAppBtn.addEventListener('click',function(){
    initialLoadApp();    
})
//Boton ver lista
const verListaAppBtn=document.querySelector("#verAppTabla");
verListaAppBtn.addEventListener('click',function(){
    initialLoadApp();    
    toggleHiddenAppAgg();
})

//Boton consultar
const inputFindApp = document.querySelector("#inputFindApp");
const findAppBtn=document.querySelector('.findAppBtn');
findAppBtn.addEventListener('click',function(){
    findApp();
    inputFindApp.value="";
})

//Boton editar
const inputAppEdit = document.querySelector("#inputAppEdit");
const editAppBtn=document.querySelector('.editAppBtn');
editAppBtn.addEventListener('click',function(){
    toggleHiddenAppEdit();  
    
})

//Boton actualizar
const actAppBtn=document.querySelector("#updateAppBtn");
actAppBtn.addEventListener('click',function(){
    editApp();    
    clearAllApp();
    toggleHiddenAppEdit();
})

//Boton eliminar
const inputDelApp = document.querySelector("#inputDelApp");
const delAppBtn=document.querySelector('.delAppBtn');
delAppBtn.addEventListener('click',function(){
    deleteApp();
    inputDelApp.value="";
})

//Boton volver
const backAppBtn=document.querySelector('.backAppBtn');
backAppBtn.addEventListener('click',function(){
    toggleHiddenMenuApp();
})


//ZONA TESTS-----------------------------------------------------------
//Boton agregar
const addTesBtn=document.querySelector('.addTesBtn');
addTesBtn.addEventListener('click',function(){
    toggleHiddenTesAgg();  
})

//Boton crear
const crearTesBtn=document.querySelector("#crearTesBtn");
crearTesBtn.addEventListener('click',function(){
    postTest();
    clearAllTes();
    toggleHiddenTesAgg();
})

//Boton limpiar
const nameTes = document.querySelector("#nameTes");
const descriptionTes = document.querySelector("#descriptionTes"); 

function clearAllTes(){
    nameTes.value="";
    descriptionTes.value=""
}

const clearTesBtn=document.querySelector("#clearTesBtn");
clearTesBtn.addEventListener('click',function(){
    clearAllTes();
})

//Boton ver todos
const allTesBtn=document.querySelector(".allTesBtn");
allTesBtn.addEventListener('click',function(){
    initialLoadTes();    
})
//Boton ver lista
const verListaTesBtn=document.querySelector("#verTesTabla");
verListaTesBtn.addEventListener('click',function(){
    initialLoadTes();    
    toggleHiddenTesAgg();
})

//Boton consultar
const inputFindTes = document.querySelector("#inputFindTes");
const findTesBtn=document.querySelector('.findTesBtn');
findTesBtn.addEventListener('click',function(){
    findTest();
    inputFindTes.value="";
})

//Boton editar
const inputEditTes = document.querySelector("#inputEditTes");
const editTesBtn=document.querySelector('.editTesBtn');
editTesBtn.addEventListener('click',function(){
    toggleHiddenTesEdit();  
    
})

//Boton actualizar
const actTesBtn=document.querySelector("#updateTesBtn");
actTesBtn.addEventListener('click',function(){
    editTest();    
    clearAllTes();
    toggleHiddenTesEdit();
})

//Boton eliminar
const inputDelTes = document.querySelector("#inputDelTes");
const delTesBtn=document.querySelector('.delTesBtn');
delTesBtn.addEventListener('click',function(){
    deleteTest();
    inputDelTes.value="";
})

//Boton volver
const backTesBtn=document.querySelector('.backTesBtn');
backTesBtn.addEventListener('click',function(){
    toggleHiddenMenuTes();
})