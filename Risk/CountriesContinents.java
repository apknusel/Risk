import java.util.*;

public class CountriesContinents
{
    Country Alaska = new Country("Alaska", "Alaska", "North America", 1);
    Country Alberta = new Country("Alberta", "Alberta", "North America", 1);
    Country CentralAmerica = new Country("Central America", "CentralAmerica", "North America", 1);
    Country EasternUnitedStates = new Country("Eastern United States", "EasternUnitedStates", "North America", 3);
    Country Greenland = new Country("Greenland", "Greenland", "North America", 1);
    Country NorthwestTerritory = new Country("Northwest Territory", "NorthwestTerritory", "North America", 1);
    Country Ontario = new Country("Ontario", "Ontario", "North America", 2);
    Country Quebec = new Country("Quebec", "Quebec", "North America", 2);
    Country WesternUnitedStates = new Country("Western United States", "WesternUnitedStates", "North America", 3);
    Country Argentina = new Country("Argentina", "Argentina", "South America", 1);
    Country Brazil = new Country("Brazil", "Brazil", "South America", 2);
    Country Peru = new Country("Peru", "Peru", "South America", 1);
    Country Venezuela = new Country("Venezuela", "Venezuela", "South America", 1);
    Country GreatBritain = new Country("Great Britain", "GreatBritain", "Europe", 2);
    Country Iceland = new Country("Iceland", "Iceland", "Europe", 1);
    Country NorthernEurope = new Country("Northern Europe", "NorthernEurope", "Europe", 3);
    Country Scandinavia = new Country("Scandinavia", "Scandinavia", "Europe", 2);
    Country SouthernEurope = new Country("Southern Europe", "SouthernEurope", "Europe", 3);
    Country Russia = new Country("Russia", "Russia", "Europe", 1);
    Country WesternEurope = new Country("Western Europe", "WesternEurope", "Europe", 3);
    Country Congo = new Country("Congo", "Congo", "Africa", 1);
    Country EastAfrica = new Country("East Africa", "EastAfrica", "Africa", 2);
    Country Egypt = new Country("Egypt", "Egypt", "Africa", 1);
    Country Madagascar = new Country("Madagascar", "Madagascar", "Africa", 1);
    Country NorthAfrica = new Country("North Africa", "NorthAfrica", "Africa", 2);
    Country SouthAfrica = new Country("South Africa", "SouthAfrica", "Africa", 2);
    Country Afghanistan = new Country("Afghanistan", "Afghanistan", "Asia", 1);
    Country China = new Country("China", "China", "Asia", 3);
    Country India = new Country("India", "India", "Asia", 3);
    Country Irkutsk = new Country("Irkutsk", "Irkutsk", "Asia", 1);
    Country Japan = new Country("Japan", "Japan", "Asia", 2);
    Country Kamchatka = new Country("Kamchatka", "Kamchatka", "Asia", 1);
    Country MiddleEast = new Country("Middle East", "MiddleEast", "Asia", 3);
    Country Mongolia = new Country("Mongolia", "Mongolia", "Asia", 1);
    Country Siam = new Country("Siam", "Siam", "Asia", 2);
    Country Siberia = new Country("Siberia", "Siberia", "Asia", 1);
    Country Ural = new Country("Ural", "Ural", "Asia", 1);
    Country Yakutsk = new Country("Yakutsk", "Yakutsk", "Asia", 1);
    Country EasternAustralia = new Country("Eastern Australia", "EasternAustralia", "Australia", 3);
    Country Indonesia = new Country("Indonesia", "Indonesia", "Australia", 2);
    Country NewGuinea = new Country("New Guinea", "NewGuinea", "Australia", 1);
    Country WesternAustralia = new Country("Western Australia", "WesternAustralia", "Australia", 2);

    Country[] AlaskaNeighbours = {Alberta, NorthwestTerritory, Kamchatka};
    Country[] AlbertaNeighbours = {Alaska, NorthwestTerritory, Ontario, WesternUnitedStates};
    Country[] CentralAmericaNeighbours = {WesternUnitedStates, Venezuela};
    Country[] EasternUnitedStatesNeighbours = {WesternUnitedStates, Ontario, Quebec};
    Country[] GreenlandNeighbours = {NorthwestTerritory, Ontario, Quebec, Iceland};
    Country[] NorthwestTerritoryNeighbours = {Alaska, Greenland, Ontario, Alberta};
    Country[] OntarioNeighbours = {NorthwestTerritory, Greenland, Quebec, EasternUnitedStates, WesternUnitedStates, Alberta};
    Country[] QuebecNeighbours = {Ontario, Greenland, EasternUnitedStates};
    Country[] WesternUnitedStatesNeighbours = {Alberta, Ontario, EasternUnitedStates ,CentralAmerica};
    Country[] ArgentinaNeighbours = {Peru, Brazil};
    Country[] BrazilNeighbours = {Venezuela, NorthAfrica, Argentina, Peru};
    Country[] PeruNeighbours = {Argentina, Brazil, Venezuela};
    Country[] VenezuelaNeighbours = {CentralAmerica, Brazil, Argentina};
    Country[] GreatBritainNeighbours = {Iceland, Scandinavia, NorthernEurope, WesternEurope};
    Country[] IcelandNeighbours = {Greenland, GreatBritain};
    Country[] NorthernEuropeNeighbours = {GreatBritain, Russia, SouthernEurope, WesternEurope};
    Country[] ScandinaviaNeighbours = {GreatBritain, Russia};
    Country[] SouthernEuropeNeighbours = {WesternEurope, NorthernEurope, Russia, Egypt, NorthAfrica};
    Country[] RussiaNeighbours = {Scandinavia, Ural, Afghanistan, MiddleEast, SouthernEurope, NorthernEurope};
    Country[] WesternEuropeNeighbours = {GreatBritain, NorthernEurope, SouthernEurope, NorthAfrica};
    Country[] CongoNeighbours = {NorthAfrica, Egypt, EastAfrica, SouthAfrica};
    Country[] EastAfricaNeighbours = {Egypt, Madagascar, SouthAfrica, Congo};
    Country[] EgyptNeighbours = {SouthernEurope, MiddleEast, EastAfrica, Congo, NorthAfrica};
    Country[] MadagascarNeighbours = {EastAfrica, SouthAfrica};
    Country[] NorthAfricaNeighbours = {WesternEurope, SouthernEurope, Egypt, Congo, Brazil};
    Country[] SouthAfricaNeighbours = {Congo, EastAfrica, Madagascar};
    Country[] AfghanistanNeighbours = {Russia, Ural, Siberia, China, India, MiddleEast};
    Country[] ChinaNeighbours = {Afghanistan, Siberia, Mongolia, Siam, India};
    Country[] IndiaNeighbours = {MiddleEast, Afghanistan, China, Siam};
    Country[] IrkutskNeighbours = {Siberia, Yakutsk, Kamchatka, Mongolia};
    Country[] JapanNeighbours = {Kamchatka, Mongolia};
    Country[] KamchatkaNeighbours = {Yakutsk, Alaska, Japan, Mongolia, Irkutsk};
    Country[] MiddleEastNeighbours = {Russia, Afghanistan, India, Egypt};
    Country[] MongoliaNeighbours = {Siberia, Irkutsk, Kamchatka, Japan, China};
    Country[] SiamNeighbours = {India, China, Indonesia};
    Country[] SiberiaNeighbours = {Ural, Yakutsk, Irkutsk, Mongolia, China, Afghanistan};
    Country[] UralNeighbours = {Russia, Siberia, Afghanistan};
    Country[] YakutskNeighbours = {Siberia, Kamchatka, Irkutsk};
    Country[] EasternAustraliaNeighbours = {NewGuinea, WesternAustralia};
    Country[] IndonesiaNeighbours = {EasternAustralia, NewGuinea};
    Country[] NewGuineaNeighbours = {EasternAustralia, Indonesia, WesternAustralia};
    Country[] WesternAustraliaNeighbours = {EasternAustralia, Indonesia, NewGuinea};

    
    public void setAdjacentCountries()
    {
        Alaska.setAdjacentCountries(AlaskaNeighbours);
        Alberta.setAdjacentCountries(AlbertaNeighbours);
        CentralAmerica.setAdjacentCountries(CentralAmericaNeighbours);
        EasternUnitedStates.setAdjacentCountries(EasternUnitedStatesNeighbours);
        Greenland.setAdjacentCountries(GreenlandNeighbours);
        NorthwestTerritory.setAdjacentCountries(NorthwestTerritoryNeighbours);
        Ontario.setAdjacentCountries(OntarioNeighbours);
        Quebec.setAdjacentCountries(QuebecNeighbours);
        WesternUnitedStates.setAdjacentCountries(WesternUnitedStatesNeighbours);
        Argentina.setAdjacentCountries(ArgentinaNeighbours);
        Brazil.setAdjacentCountries(BrazilNeighbours);
        Peru.setAdjacentCountries(PeruNeighbours);
        Venezuela.setAdjacentCountries(VenezuelaNeighbours);
        GreatBritain.setAdjacentCountries(GreatBritainNeighbours);
        Iceland.setAdjacentCountries(IcelandNeighbours);
        NorthernEurope.setAdjacentCountries(NorthernEuropeNeighbours);
        Scandinavia.setAdjacentCountries(ScandinaviaNeighbours);
        SouthernEurope.setAdjacentCountries(SouthernEuropeNeighbours);
        Russia.setAdjacentCountries(RussiaNeighbours);
        WesternEurope.setAdjacentCountries(WesternEuropeNeighbours);
        Congo.setAdjacentCountries(CongoNeighbours);
        EastAfrica.setAdjacentCountries(EastAfricaNeighbours);
        Egypt.setAdjacentCountries(EgyptNeighbours);
        Madagascar.setAdjacentCountries(MadagascarNeighbours);
        NorthAfrica.setAdjacentCountries(NorthAfricaNeighbours);
        SouthAfrica.setAdjacentCountries(SouthAfricaNeighbours);
        Afghanistan.setAdjacentCountries(AfghanistanNeighbours);
        China.setAdjacentCountries(ChinaNeighbours);
        India.setAdjacentCountries(IndiaNeighbours);
        Irkutsk.setAdjacentCountries(IrkutskNeighbours);
        Japan.setAdjacentCountries(JapanNeighbours);
        Kamchatka.setAdjacentCountries(KamchatkaNeighbours);
        MiddleEast.setAdjacentCountries(MiddleEastNeighbours);
        Mongolia.setAdjacentCountries(MongoliaNeighbours);
        Siam.setAdjacentCountries(SiamNeighbours);
        Siberia.setAdjacentCountries(SiberiaNeighbours);
        Ural.setAdjacentCountries(UralNeighbours);
        Yakutsk.setAdjacentCountries(YakutskNeighbours);
        EasternAustralia.setAdjacentCountries(EasternAustraliaNeighbours);
        Indonesia.setAdjacentCountries(IndonesiaNeighbours);
        NewGuinea.setAdjacentCountries(NewGuineaNeighbours);
        WesternAustralia.setAdjacentCountries(WesternAustraliaNeighbours);
    }
    
    public void setCountries()
    {
        countries.addAll(Arrays.asList(Alaska, Alberta, CentralAmerica, EasternUnitedStates, Greenland, NorthwestTerritory, Ontario, Quebec, WesternUnitedStates, Argentina, Brazil, Peru, Venezuela, GreatBritain, Iceland, NorthernEurope, Scandinavia, SouthernEurope, Russia, WesternEurope, Congo, EastAfrica, Egypt, Madagascar, NorthAfrica, SouthAfrica, Afghanistan, China, India, Irkutsk, Japan, Kamchatka, MiddleEast, Mongolia, Siam, Siberia, Ural, Yakutsk, EasternAustralia, Indonesia, NewGuinea, WesternAustralia));
    }
    
    
    Country[] NorthAmericaCountries = {Alaska, Alberta, CentralAmerica, EasternUnitedStates, Greenland, NorthwestTerritory, Ontario, Quebec, WesternUnitedStates};
    Country[] SouthAmericaCountries = {Argentina, Brazil, Peru, Venezuela};
    Country[] EuropeCountries = {GreatBritain, Iceland, NorthernEurope, Scandinavia, SouthernEurope, Russia, WesternEurope};
    Country[] AfricaCountries = {Congo, EastAfrica, Egypt, Madagascar, NorthAfrica, SouthAfrica};
    Country[] AsiaCountries = {Afghanistan, China, India, Irkutsk, Japan, Kamchatka, MiddleEast, Mongolia, Siam, Siberia, Ural, Yakutsk};
    Country[] AustraliaCountries = {EasternAustralia, Indonesia, NewGuinea, WesternAustralia};

    ArrayList<Country> countries = new ArrayList<Country>(42);
    
    Continent NorthAmerica = new Continent("North America", 5, NorthAmericaCountries);
    Continent SouthAmerica = new Continent("South America", 2, SouthAmericaCountries);
    Continent Europe = new Continent("Europe", 5, EuropeCountries);
    Continent Africa = new Continent("Africa", 3, AfricaCountries);
    Continent Asia = new Continent("Asia", 7, AsiaCountries);
    Continent Australia = new Continent("Australia", 2, AustraliaCountries);
    
    Continent[] continents = {NorthAmerica, SouthAmerica, Europe, Africa, Asia, Australia};
    
    public Country getCountry(String country)
    {
        Country countryFound = null;
        for (int i = 0; i < NorthAmericaCountries.length; i++)
        {
            if (NorthAmericaCountries[i].getNameWithoutSpaces().equals(country))
            {
                countryFound = NorthAmericaCountries[i];
                return countryFound;
            }
        }
        
        for (int i = 0; i < SouthAmericaCountries.length; i++)
        {
            if (SouthAmericaCountries[i].getNameWithoutSpaces().equals(country))
            {
                countryFound = SouthAmericaCountries[i];
                return countryFound;
            }
        }
        
        for (int i = 0; i < EuropeCountries.length; i++)
        {
            if (EuropeCountries[i].getNameWithoutSpaces().equals(country))
            {
                countryFound = EuropeCountries[i];
                return countryFound;
            }
        }
        
        for (int i = 0; i < AfricaCountries.length; i++)
        {
            if (AfricaCountries[i].getNameWithoutSpaces().equals(country))
            {
                countryFound = AfricaCountries[i];
                return countryFound;
            }
        }
        
        for (int i = 0; i < AsiaCountries.length; i++)
        {
            if (AsiaCountries[i].getNameWithoutSpaces().equals(country))
            {
                countryFound = AsiaCountries[i];
                return countryFound;
            }
        }
        
        for (int i = 0; i < AustraliaCountries.length; i++)
        {
            if (AustraliaCountries[i].getNameWithoutSpaces().equals(country))
            {
                countryFound = AustraliaCountries[i];
                return countryFound;
            }
        }
        return countryFound;
    }
}
