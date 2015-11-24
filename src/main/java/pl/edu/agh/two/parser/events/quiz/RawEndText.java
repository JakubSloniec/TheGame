package pl.edu.agh.two.parser.events.quiz;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 11/17/2015.
 */
public class RawEndText {
    private List<Integer> forNotes;
    private List<RawAward> awards;
    private String textToDisplay;

    public List<Integer> getForNotes() {
        return forNotes;
    }

    public void setForNotes(List<Integer> forNotes) {
        this.forNotes = forNotes;
    }

    public String getTextToDisplay() {
        return textToDisplay;
    }

    public void setTextToDisplay(String textToDisplay) {
        this.textToDisplay = textToDisplay;
    }

    public List<RawAward> getAwards() {
        return awards;
    }

    public void setAwards(List<RawAward> awards) {
        this.awards = awards;
    }
}
