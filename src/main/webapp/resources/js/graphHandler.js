function drawMainPoint(x, y) {
    let point = $('#point');
    point.attr('cx', 150 + 30 * x);
    point.attr('cy', 150 - 30 * y);
}

function changeCoord() {
    let x = document.getElementById('input-form:X_hinput').value;
    let y = document.getElementById('input-form:Y_hinput').value;
    if (x && y) {
        drawMainPoint(x, y);
    }
}

function onChangeR() {
    let r = document.getElementById('input-form:R_hinput').value;
    // console.log("change: " + r)
    if (!r || r < 1) {
        r = 1;
    }
    if (r > 4) {
        r = 4;
    }
    document.getElementById('input-form:R_hinput').value = r;
    document.getElementById('input-form:R_input').value = r;
    setR([{name: 'r', value: r}])
    changeR(r);
}

function onEditR() {
    let r = document.getElementById('input-form:R_hinput').value;
    // console.log("key: " + r)
    if (r && r >= 1 && r <= 4) {
        changeR(r);
    }
}

function changeR(input_r) {
    let r = input_r * 30;
    let rect = $('#rect');
    rect.css('x', 150 - r / 2);
    rect.css('width', r / 2);
    rect.css('y', 150 - r);
    rect.css('height', r);
    $('#circle').attr('d', "M 150 150 L 150 " + (150 + r) + " A " + r + " " + r + " 1 0 1 " + (150 - r) + ",150 z");
    $('#triangle').attr('d', "M 150 150 L " + (150 + r / 2) + " 150 L 150 " + (150 - r) + " z");
    $('#first-x-tick').attr('x1', 150 - r);
    $('#first-x-tick').attr('x2', 150 - r);
    $('#second-x-tick').attr('x1', 150 - r / 2);
    $('#second-x-tick').attr('x2', 150 - r / 2);
    $('#third-x-tick').attr('x1', 150 + r / 2);
    $('#third-x-tick').attr('x2', 150 + r / 2);
    $('#forth-x-tick').attr('x1', 150 + r);
    $('#forth-x-tick').attr('x2', 150 + r);
    $('#first-y-tick').attr('y1', 150 - r);
    $('#first-y-tick').attr('y2', 150 - r);
    $('#second-y-tick').attr('y1', 150 - r / 2);
    $('#second-y-tick').attr('y2', 150 - r / 2);
    $('#third-y-tick').attr('y1', 150 + r / 2);
    $('#third-y-tick').attr('y2', 150 + r / 2);
    $('#forth-y-tick').attr('y1', 150 + r);
    $('#forth-y-tick').attr('y2', 150 + r);
    $('#left-r').attr('x', 150 - r - 5);
    $('#right-r').attr('x', 150 + r - 5);
    $('#top-r').attr('y', 150 - r + 5);
    $('#bottom-r').attr('y', 150 + r + 5);
}