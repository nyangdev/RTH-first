const fileDOM = document.querySelector('#inputImage');
const preview = document.querySelector('#holder');

fileDOM.addEventListener('change', () => {
    debugger
    const reader = new FileReader();
    reader.onload = ({ target }) => {
        debugger
        preview.src = target.result;
    };
    debugger
    reader.readAsDataURL(fileDOM.files[0]);
});