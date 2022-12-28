//Zona usuarios

const formularioAff=document.querySelector('.formularioAff');
const tablaAff=document.querySelector('.tablaAff');
const titleMain=document.querySelector('.titleMain');
const optionsMain=document.querySelector('.optionsMain');
const titleAff=document.querySelector('.titleAff');
const optionsAff=document.querySelector('.optionsAff');

const toggleHiddenMenuAff = () => {
  titleMain.classList.toggle('hidden');
  optionsMain.classList.toggle('hidden');
  titleAff.classList.toggle('hidden');
  optionsAff.classList.toggle('hidden');
  tablaAff.classList.toggle('hidden');
}

const toggleHiddenAffAgg = () => {
  formularioAff.classList.toggle('hidden');
  tablaAff.classList.toggle('hidden');
  optionsAff.classList.toggle('hidden');
}

const formularioEditarAff=document.querySelector('.formularioEditarAff');
const toggleHiddenAffEdit = () => {
  formularioEditarAff.classList.toggle('hidden');
  tablaAff.classList.toggle('hidden');
  optionsAff.classList.toggle('hidden');
}

//Zona citas

const formularioApp=document.querySelector('.formularioApp');
const tablaApp=document.querySelector('.tablaApp');
const titleApp=document.querySelector('.titleApp');
const optionsApp=document.querySelector('.optionsApp');

const toggleHiddenMenuApp = () => {
  titleMain.classList.toggle('hidden');
  optionsMain.classList.toggle('hidden');
  titleApp.classList.toggle('hidden');
  optionsApp.classList.toggle('hidden');
  tablaApp.classList.toggle('hidden');
}

const toggleHiddenAppAgg = () => {
  formularioApp.classList.toggle('hidden');
  tablaApp.classList.toggle('hidden');
  optionsApp.classList.toggle('hidden');
}

const formularioEditarApp=document.querySelector('.formularioEditarApp');
const toggleHiddenAppEdit = () => {
  formularioEditarApp.classList.toggle('hidden');
  tablaApp.classList.toggle('hidden');
  optionsApp.classList.toggle('hidden');
}


//Zona examenes

const formularioTes=document.querySelector('.formularioTes');
const tablaTes=document.querySelector('.tablaTes');
const titleTes=document.querySelector('.titleTes');
const optionsTes=document.querySelector('.optionsTes');

const toggleHiddenMenuTes = () => {
  titleMain.classList.toggle('hidden');
  optionsMain.classList.toggle('hidden');
  titleTes.classList.toggle('hidden');
  optionsTes.classList.toggle('hidden');
  tablaTes.classList.toggle('hidden');
}

const toggleHiddenTesAgg = () => {
  formularioTes.classList.toggle('hidden');
  tablaTes.classList.toggle('hidden');
  optionsTes.classList.toggle('hidden');
}

const formularioEditarTes=document.querySelector('.formularioEditarTes');
const toggleHiddenTesEdit = () => {
  formularioEditarTes.classList.toggle('hidden');
  tablaTes.classList.toggle('hidden');
  optionsTes.classList.toggle('hidden');
}
