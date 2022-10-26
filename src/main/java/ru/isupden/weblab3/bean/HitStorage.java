package ru.isupden.weblab3.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import ru.isupden.weblab3.dao.HitDao;
import ru.isupden.weblab3.model.Coord;
import ru.isupden.weblab3.model.Hit;
import ru.isupden.weblab3.util.AreaChecker;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Named("hitStorage")
@SessionScoped
@Data
public class HitStorage implements Serializable {
    @Inject
    private HitDao hitDao;
    private final AreaChecker areaChecker = new AreaChecker();
    private Hit curHit = new Hit();

    public HitStorage() {
        System.out.println(curHit);
    }

    public List<Hit> getSavedHits() {
        List<Hit> hits = hitDao.getHits();
        Coord coord = hits.get(0).getCoord();
        System.out.println(coord.getClass());
        System.out.println(coord.getX());
        System.out.println(coord.getClass());
        Collections.reverse(hits);
        return hits;
    }

    public void submitForm() {
        areaChecker.checkPoint(curHit);
        hitDao.saveHit(curHit);
        curHit = new Hit(curHit);
    }

    public void submitGraph() {
        String xCoordinate = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("x");
        String yCoordinate = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("y");
        curHit.getCoord().setX(Double.valueOf(xCoordinate));
        curHit.getCoord().setY(Double.valueOf(yCoordinate));
        areaChecker.checkPoint(curHit);
        hitDao.saveHit(curHit);
        curHit = new Hit(curHit);
    }

    public void clear() {
        hitDao.clear();
    }

    public void setTimeZone() {
        curHit.setTimeZone(Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("timeZone")));
    }

    public void setR() {
        curHit.getCoord().setR(Double.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("r")));
    }
}
