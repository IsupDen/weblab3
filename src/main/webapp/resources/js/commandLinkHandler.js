function setY(e) {
    document.querySelectorAll('.y-input a').forEach(function (element) {
        element.className = '';
    })
    e.className = 'selected'
    document.getElementById('input-form:Y_hinput').value = e.innerHTML;
    changeCoord();
}