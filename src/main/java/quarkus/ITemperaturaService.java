package quarkus;

import java.util.List;

public interface ITemperaturaService {
    void addTemperatura(Temperatura t);

    List<Temperatura> getTemperaturas();

    boolean isEmpty();

    int maximaTemperatura();
}
