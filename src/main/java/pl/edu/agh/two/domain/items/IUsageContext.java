package pl.edu.agh.two.domain.items;

/**
 * Representes context in with item is used (like some Events, Precognitions, Room etc.)
 */
public interface IUsageContext {
    void registerOnFizishListener(IContextFinishListener contextFinishListener);
}
