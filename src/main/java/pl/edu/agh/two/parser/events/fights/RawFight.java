package pl.edu.agh.two.parser.events.fights;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 12/1/2015.
 */
public class RawFight {
    private String introduction;
    private RawEnemy enemy;
    private List<RawAction> actions;
    private String textIfWin;
    private String textIfLose;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public RawEnemy getEnemy() {
        return enemy;
    }

    public void setEnemy(RawEnemy enemy) {
        this.enemy = enemy;
    }

    public List<RawAction> getActions() {
        return actions;
    }

    public void setActions(List<RawAction> actions) {
        this.actions = actions;
    }

    public String getTextIfWin() {
        return textIfWin;
    }

    public void setTextIfWin(String textIfWin) {
        this.textIfWin = textIfWin;
    }

    public String getTextIfLose() {
        return textIfLose;
    }

    public void setTextIfLose(String textIfLose) {
        this.textIfLose = textIfLose;
    }
}
