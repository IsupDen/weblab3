package ru.isupden.weblab3.util;

import ru.isupden.weblab3.model.Hit;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class AreaChecker {
    public void checkPoint(Hit hit) {
        LocalDateTime startTime = LocalDateTime.now(ZoneOffset.UTC);
        hit.setResult(checkArea(hit.getCoord().getX(), hit.getCoord().getY(), hit.getCoord().getR()));
        hit.getTime().setCurrentTime(startTime.minusMinutes(hit.getTimeZone()).format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
        hit.getTime().setExecutionTime(LocalDateTime.now().minusNanos(startTime.getNano()).getNano() / 1000);
    }

    private boolean checkArea(double x, double y, double r) {
        return inTriangle(x, y, r) || inSquare(x, y, r) || inCircle(x, y, r);
    }

    private boolean inTriangle(double x, double y, double r) {
        return x >= 0 && y >= 0 && y <= -2 * x + r;
    }
    private boolean inSquare(double x, double y, double r) {
        return x <= 0 && y >= 0 && x >= -r / 2 && y <= r;
    }
    private boolean inCircle(double x, double y, double r) {
        return x <= 0 && y <= 0 && x * x + y * y <= r * r;
    }
}
