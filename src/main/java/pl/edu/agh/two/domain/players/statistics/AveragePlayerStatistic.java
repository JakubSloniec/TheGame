package pl.edu.agh.two.domain.players.statistics;

import pl.edu.agh.two.domain.attributes.Attribute;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Puszek_SE on 2015-11-30.
 */
public class AveragePlayerStatistic extends SimplePlayerStatistic {

    private List<Double> marks;

    private AveragePlayerStatistic(String name){
        super(Attribute.createAttributeWithRange(name, 0d, Double.MAX_VALUE, Optional.<Double>empty()),-1d);
        marks = new LinkedList<>();
    }

    public static AveragePlayerStatistic createAverageStatistic(String name){
        return new AveragePlayerStatistic(name);
    }

    @Override
    public Double getCurrentValue() {
        if(marks.isEmpty()){
            return 0d;
        }
        return marks.stream().mapToDouble(d->d).average().getAsDouble();
    }


    @Override
    public void add(Double value) {
        marks.add(value);
    }
}
