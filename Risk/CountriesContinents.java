import java.util.*;

public class CountriesContinents
{
    //Creates all of the countries
    Country Alaska = new Country("Alaska", "Alaska", "North America");
    Country Alberta = new Country("Alberta", "Alberta", "North America");
    Country CentralAmerica = new Country("Central America", "CentralAmerica", "North America");
    Country EasternCanada  = new Country("Eastern Canada", "EasternCanada", "North America");
    Country EasternUnitedStates = new Country("Eastern United States", "EasternUnitedStates", "North America");
    Country Greenland = new Country("Greenland", "Greenland", "North America");
    Country NorthwestTerritory = new Country("Northwest Territory", "NorthwestTerritory", "North America");
    Country Ontario = new Country("Ontario", "Ontario", "North America");
    Country WesternUnitedStates = new Country("Western United States", "WesternUnitedStates", "North America");
    Country Argentina = new Country("Argentina", "Argentina", "South America");
    Country Brazil = new Country("Brazil", "Brazil", "South America");
    Country Peru = new Country("Peru", "Peru", "South America");
    Country Venezuela = new Country("Venezuela", "Venezuela", "South America");
    Country GreatBritain = new Country("Great Britain", "GreatBritain", "Europe");
    Country Iceland = new Country("Iceland", "Iceland", "Europe");
    Country NorthernEurope = new Country("Northern Europe", "NorthernEurope", "Europe");
    Country Scandinavia = new Country("Scandinavia", "Scandinavia", "Europe");
    Country SouthernEurope = new Country("Southern Europe", "SouthernEurope", "Europe");
    Country Russia = new Country("Russia", "Russia", "Europe");
    Country WesternEurope = new Country("Western Europe", "WesternEurope", "Europe");
    Country CentralAfrica = new Country("Central Africa", "Central Africa", "Africa");
    Country EastAfrica = new Country("East Africa", "EastAfrica", "Africa");
    Country Egypt = new Country("Egypt", "Egypt", "Africa");
    Country Madagascar = new Country("Madagascar", "Madagascar", "Africa");
    Country NorthAfrica = new Country("North Africa", "NorthAfrica", "Africa");
    Country SouthAfrica = new Country("South Africa", "SouthAfrica", "Africa");
    Country Afghanistan = new Country("Afghanistan", "Afghanistan", "Asia");
    Country China = new Country("China", "China", "Asia");
    Country India = new Country("India", "India", "Asia");
    Country Irkutsk = new Country("Irkutsk", "Irkutsk", "Asia");
    Country Japan = new Country("Japan", "Japan", "Asia");
    Country Kamchatka = new Country("Kamchatka", "Kamchatka", "Asia");
    Country MiddleEast = new Country("Middle East", "MiddleEast", "Asia");
    Country Mongolia = new Country("Mongolia", "Mongolia", "Asia");
    Country Siberia = new Country("Siberia", "Siberia", "Asia");
    Country SoutheastAsia = new Country("Southeast Asia", "SoutheastAsia", "Asia");
    Country Ural = new Country("Ural", "Ural", "Asia");
    Country Yakutsk = new Country("Yakutsk", "Yakutsk", "Asia");
    Country EasternAustralia = new Country("Eastern Australia", "EasternAustralia", "Australia");
    Country Indonesia = new Country("Indonesia", "Indonesia", "Australia");
    Country NewGuinea = new Country("New Guinea", "NewGuinea", "Australia");
    Country WesternAustralia = new Country("Western Australia", "WesternAustralia", "Australia");

    //Creates a list of the neighbours of each country
    Country[] AlaskaNeighbours = {Alberta, NorthwestTerritory, Kamchatka};
    Country[] AlbertaNeighbours = {Alaska, NorthwestTerritory, Ontario, WesternUnitedStates};
    Country[] CentralAmericaNeighbours = {WesternUnitedStates, Venezuela};
    Country[] EasternCanadaNeighbours = {Ontario, Greenland, EasternUnitedStates};
    Country[] EasternUnitedStatesNeighbours = {WesternUnitedStates, Ontario, EasternCanada};
    Country[] GreenlandNeighbours = {NorthwestTerritory, Ontario, EasternCanada, Iceland};
    Country[] NorthwestTerritoryNeighbours = {Alaska, Greenland, Ontario, Alberta};
    Country[] OntarioNeighbours = {NorthwestTerritory, Greenland, EasternCanada, EasternUnitedStates, WesternUnitedStates, Alberta};
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
    Country[] CentralAfricaNeighbours = {NorthAfrica, Egypt, EastAfrica, SouthAfrica};
    Country[] EastAfricaNeighbours = {Egypt, Madagascar, SouthAfrica, CentralAfrica};
    Country[] EgyptNeighbours = {SouthernEurope, MiddleEast, EastAfrica, CentralAfrica, NorthAfrica};
    Country[] MadagascarNeighbours = {EastAfrica, SouthAfrica};
    Country[] NorthAfricaNeighbours = {WesternEurope, SouthernEurope, Egypt, CentralAfrica, Brazil};
    Country[] SouthAfricaNeighbours = {CentralAfrica, EastAfrica, Madagascar};
    Country[] AfghanistanNeighbours = {Russia, Ural, Siberia, China, India, MiddleEast};
    Country[] ChinaNeighbours = {Afghanistan, Siberia, Mongolia, SoutheastAsia, India};
    Country[] IndiaNeighbours = {MiddleEast, Afghanistan, China, SoutheastAsia};
    Country[] IrkutskNeighbours = {Siberia, Yakutsk, Kamchatka, Mongolia};
    Country[] JapanNeighbours = {Kamchatka, Mongolia};
    Country[] KamchatkaNeighbours = {Yakutsk, Alaska, Japan, Mongolia, Irkutsk};
    Country[] MiddleEastNeighbours = {Russia, Afghanistan, India, Egypt};
    Country[] MongoliaNeighbours = {Siberia, Irkutsk, Kamchatka, Japan, China};
    Country[] SiberiaNeighbours = {Ural, Yakutsk, Irkutsk, Mongolia, China, Afghanistan};
    Country[] SoutheastAsiaNeighbours = {India, China, Indonesia};
    Country[] UralNeighbours = {Russia, Siberia, Afghanistan};
    Country[] YakutskNeighbours = {Siberia, Kamchatka, Irkutsk};
    Country[] EasternAustraliaNeighbours = {NewGuinea, WesternAustralia};
    Country[] IndonesiaNeighbours = {EasternAustralia, NewGuinea};
    Country[] NewGuineaNeighbours = {EasternAustralia, Indonesia, WesternAustralia};
    Country[] WesternAustraliaNeighbours = {EasternAustralia, Indonesia, NewGuinea};

    
    public void setAdjacentCountries()
    {
        //Gives the countries their neighbours
        Alaska.setAdjacentCountries(AlaskaNeighbours);
        Alberta.setAdjacentCountries(AlbertaNeighbours);
        CentralAmerica.setAdjacentCountries(CentralAmericaNeighbours);
        EasternCanada.setAdjacentCountries(EasternCanadaNeighbours);
        EasternUnitedStates.setAdjacentCountries(EasternUnitedStatesNeighbours);
        Greenland.setAdjacentCountries(GreenlandNeighbours);
        NorthwestTerritory.setAdjacentCountries(NorthwestTerritoryNeighbours);
        Ontario.setAdjacentCountries(OntarioNeighbours);
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
        CentralAfrica.setAdjacentCountries(CentralAfricaNeighbours);
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
        Siberia.setAdjacentCountries(SiberiaNeighbours);
        SoutheastAsia.setAdjacentCountries(SoutheastAsiaNeighbours);
        Ural.setAdjacentCountries(UralNeighbours);
        Yakutsk.setAdjacentCountries(YakutskNeighbours);
        EasternAustralia.setAdjacentCountries(EasternAustraliaNeighbours);
        Indonesia.setAdjacentCountries(IndonesiaNeighbours);
        NewGuinea.setAdjacentCountries(NewGuineaNeighbours);
        WesternAustralia.setAdjacentCountries(WesternAustraliaNeighbours);
    }
    
    public void setCountries()
    {
        //Puts all of the countries into an arrayList
        countries.addAll(Arrays.asList(Alaska, Alberta, CentralAmerica, EasternCanada, EasternUnitedStates, Greenland, NorthwestTerritory, Ontario, WesternUnitedStates, Argentina, Brazil, Peru, Venezuela, GreatBritain, Iceland, NorthernEurope, Scandinavia, SouthernEurope, Russia, WesternEurope, CentralAfrica, EastAfrica, Egypt, Madagascar, NorthAfrica, SouthAfrica, Afghanistan, China, India, Irkutsk, Japan, Kamchatka, MiddleEast, Mongolia, Siberia, SoutheastAsia, Ural, Yakutsk, EasternAustralia, Indonesia, NewGuinea, WesternAustralia));
    }
    
    //Makes an array with all of the countries in each continent
    Country[] NorthAmericaCountries = {Alaska, Alberta, CentralAmerica, EasternCanada, EasternUnitedStates, Greenland, NorthwestTerritory, Ontario, WesternUnitedStates};
    Country[] SouthAmericaCountries = {Argentina, Brazil, Peru, Venezuela};
    Country[] EuropeCountries = {GreatBritain, Iceland, NorthernEurope, Scandinavia, SouthernEurope, Russia, WesternEurope};
    Country[] AfricaCountries = {CentralAfrica, EastAfrica, Egypt, Madagascar, NorthAfrica, SouthAfrica};
    Country[] AsiaCountries = {Afghanistan, China, India, Irkutsk, Japan, Kamchatka, MiddleEast, Mongolia, Siberia, SoutheastAsia, Ural, Yakutsk};
    Country[] AustraliaCountries = {EasternAustralia, Indonesia, NewGuinea, WesternAustralia};

    ArrayList<Country> countries = new ArrayList<Country>(42);
    
    //Makes the new continents
    Continent NorthAmerica = new Continent("North America", 5, NorthAmericaCountries);
    Continent SouthAmerica = new Continent("South America", 2, SouthAmericaCountries);
    Continent Europe = new Continent("Europe", 5, EuropeCountries);
    Continent Africa = new Continent("Africa", 3, AfricaCountries);
    Continent Asia = new Continent("Asia", 7, AsiaCountries);
    Continent Australia = new Continent("Australia", 2, AustraliaCountries);
    
    //Puts all of the continents into an array
    Continent[] continents = {NorthAmerica, SouthAmerica, Europe, Africa, Asia, Australia};
    
    public Country getCountry(String country)
    {
        Country countryFound = null;
        
        //Returns the country object from a string with the name of the country
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
