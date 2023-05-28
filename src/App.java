import models.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Station> stations = new ArrayList<>();
        Station lisbonStation = new Station("Estação de Lisboa", "Lisboa", new Coordinates(38.7223, -9.1393));
        Station portoStation = new Station("Estação do Porto", "Porto", new Coordinates(41.1496, -8.6109));
        Station bragaStation = new Station("Estação de Braga", "Braga", new Coordinates(41.5454, -8.4265));
        Station coimbraStation = new Station("Estação de Coimbra", "Coimbra", new Coordinates(40.2033, -8.4103));
        Station aveiroStation = new Station("Estação de Aveiro", "Aveiro", new Coordinates(40.6405, -8.6538));
        Station faroStation = new Station("Estação de Faro", "Faro", new Coordinates(37.0194, -7.9304));
        Station setubalStation = new Station("Estação de Setúbal", "Setúbal", new Coordinates(38.5257, -8.8921));
        Station bragancaStation = new Station("Estação de Bragança", "Bragança", new Coordinates(41.8057, -6.7593));
        Station evoraStation = new Station("Estação de Évora", "Évora", new Coordinates(38.5719, -7.9097));
        Station guardaStation = new Station("Estação da Guarda", "Guarda", new Coordinates(40.5372, -7.2673));
        Station viseuStation = new Station("Estação de Viseu", "Viseu", new Coordinates(40.6610, -7.9097));
        Station vianaDoCasteloStation = new Station("Estação de Viana do Castelo", "Viana do Castelo", new Coordinates(41.6932, -8.8329));
        Station funchalStation = new Station("Estação do Funchal", "Funchal", new Coordinates(32.6669, -16.9240));
        Station pontaDelgadaStation = new Station("Estação de Ponta Delgada", "Ponta Delgada", new Coordinates(37.7416, -25.6687));
        Station amaranteStation = new Station("Estação de Amarante", "Amarante", new Coordinates(41.2708, -8.0828));
        Station sintraStation = new Station("Estação de Sintra", "Sintra", new Coordinates(38.8029, -9.3817));
        Station albufeiraStation = new Station("Estação de Albufeira", "Albufeira", new Coordinates(37.0891, -8.2479));
        Station covilhaStation = new Station("Estação da Covilhã", "Covilhã", new Coordinates(40.2824, -7.5030));
        Station elvasStation = new Station("Estação de Elvas", "Elvas", new Coordinates(38.8817, -7.1637));
        Station almadaStation = new Station("Estação de Almada", "Almada", new Coordinates(38.6765, -9.1605));

        stations.add(lisbonStation);
        stations.add(portoStation);
        stations.add(bragaStation);
        stations.add(coimbraStation);
        stations.add(aveiroStation);
        stations.add(faroStation);
        stations.add(setubalStation);
        stations.add(bragancaStation);
        stations.add(evoraStation);
        stations.add(guardaStation);
        stations.add(viseuStation);
        stations.add(vianaDoCasteloStation);
        stations.add(funchalStation);
        stations.add(pontaDelgadaStation);
        stations.add(amaranteStation);
        stations.add(sintraStation);
        stations.add(albufeiraStation);
        stations.add(covilhaStation);
        stations.add(elvasStation);
        stations.add(almadaStation);


        List<Connection> connections = new ArrayList<>();
        connections.add(new Connection(lisbonStation, portoStation, new Preferences(100, 71, 2)));
        connections.add(new Connection(portoStation, bragaStation, new Preferences(75, 75, 2)));
        connections.add(new Connection(bragaStation, coimbraStation, new Preferences(118, 118, 3)));
        connections.add(new Connection(coimbraStation, aveiroStation, new Preferences(111, 111, 2)));
        connections.add(new Connection(aveiroStation, faroStation, new Preferences(70, 70, 2)));
        connections.add(new Connection(faroStation, setubalStation, new Preferences(75, 75, 2)));
        connections.add(new Connection(setubalStation, bragancaStation, new Preferences(120, 120, 2)));
        connections.add(new Connection(bragancaStation, evoraStation, new Preferences(146, 146, 3)));
        connections.add(new Connection(evoraStation, guardaStation, new Preferences(80, 80, 3)));
        connections.add(new Connection(guardaStation, viseuStation, new Preferences(80, 97, 3)));
        connections.add(new Connection(viseuStation, vianaDoCasteloStation, new Preferences(99, 99, 4)));
        connections.add(new Connection(vianaDoCasteloStation, funchalStation, new Preferences(151, 151, 4)));
        connections.add(new Connection(funchalStation, pontaDelgadaStation, new Preferences(151, 140, 4)));
        connections.add(new Connection(pontaDelgadaStation, amaranteStation, new Preferences(211, 211, 2)));
        connections.add(new Connection(amaranteStation, sintraStation, new Preferences(101, 101, 3)));
        connections.add(new Connection(sintraStation, albufeiraStation, new Preferences(138, 138, 2)));
        connections.add(new Connection(albufeiraStation, covilhaStation, new Preferences(90, 90, 4)));
        connections.add(new Connection(covilhaStation, elvasStation, new Preferences(85, 85, 4)));
        connections.add(new Connection(elvasStation, lisbonStation, new Preferences(98, 98, 3)));
        connections.add(new Connection(lisbonStation, viseuStation, new Preferences(86, 86, 2)));
        connections.add(new Connection(portoStation, viseuStation, new Preferences(142, 142, 3)));
        connections.add(new Connection(portoStation, bragancaStation, new Preferences(92, 92, 2)));
        connections.add(new Connection(viseuStation, amaranteStation, new Preferences(87, 87, 2)));


        //types can be time, price, or stops
        StationGraph graph = new StationGraph(stations, connections, "time");
        graph.findBestRoute(lisbonStation, viseuStation);
    }
}
