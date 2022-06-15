let btn = document.querySelector(".boton");
let header = document.getElementById("header");
btn.addEventListener("click",()=>{
    btn.classList.toggle("active");
    header.classList.toggle("visible");
});

let cerrar = document.querySelector(".btn-close");
let abrir = document.querySelector(".btn-add");
let modal= document.querySelector(".modal");
let modalC= document.querySelector(".modal-container");
abrir.addEventListener("click",()=>{
    modalC.style.opacity="1";
    modalC.style.visibility="visible";
    modal.classList.toggle("modal-close");
});
cerrar.addEventListener("click",()=>{
    modal.classList.toggle("modal-close");
    setTimeout(()=>{
        modalC.style.opacity="0";
        modalC.style.visibility="hidden";
    },790);
});
window.addEventListener("click",(e)=>{
    if(e.target==modalC){
        modal.classList.toggle("modal-close");
        setTimeout(()=>{
            modalC.style.opacity="0";
            modalC.style.visibility="hidden";
        },790);
    };
});
