function drawHit(x, y, result) {
    point = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    point.style.cx = 150 + 30 * x;
    point.style.cy = 150 - 30 * y;
    point.style.r = 5;
    point.style.fill = result ? '#1d5e91' :'#78183a';
    document.getElementById('point').before(point);
}