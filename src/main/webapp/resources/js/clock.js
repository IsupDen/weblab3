let clock = document.querySelector('#analog-svg');


function updateTime() {
    let date = new Date();
    clock.querySelector('#second').setAttribute('x2', (150 + 125 * Math.sin(Math.PI * date.getSeconds() / 30)).toString());
    clock.querySelector('#second').setAttribute('y2', (150 - 125 * Math.cos(Math.PI * date.getSeconds() / 30)).toString());
    clock.querySelector('#minute').setAttribute('x2', (150 + 110 * Math.sin(Math.PI / 30 * (date.getMinutes() + date.getSeconds() / 60))).toString());
    clock.querySelector('#minute').setAttribute('y2', (150 - 110 * Math.cos(Math.PI / 30 * (date.getMinutes() + date.getSeconds() / 60))).toString());
    clock.querySelector('#hour').setAttribute('x2', (150 + 90 * Math.sin(Math.PI / 6 * (date.getHours() + date.getMinutes() / 60 + date.getSeconds() / 3600))).toString());
    clock.querySelector('#hour').setAttribute('y2', (150 - 90 * Math.cos(Math.PI / 6 * (date.getHours() + date.getMinutes() / 60 + date.getSeconds() / 3600))).toString());
    document.querySelector('#date').innerHTML = date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear();
}

updateTime();
setInterval(updateTime, 9000);
