package pl.edu.agh.two.theGame.model.player;

public enum SimplePlayerStatistic implements PlayerStatistic<Number> {
    BLOOD_ALCOHOL_CONTENT("Blood alcohol content") {
        @Override
        public Double initialValue() {
            return 0.0;
        }
    }, ETCS_POINTS("ETCS points") {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };
    private final String name;

    SimplePlayerStatistic(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
