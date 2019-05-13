import java.util.*;

public class CountriesContinents
{
    public Country Alaska = new Country("Alaska", "North America", 1);
    public Country Alberta = new Country("Alberta", "North America", 1);
    public Country CentralAmerica = new Country("Central America", "North America", 1);
    public Country EasternUnitedStates = new Country("Eastern United States", "North America", 3);
    public Country Greenland = new Country("Greenland", "North America", 1);
    public Country NorthwestTerritory = new Country("Northwest Territory", "North America", 1);
    public Country Ontario = new Country("Ontario", "North America", 2);
    public Country Quebec = new Country("Quebec", "North America", 2);
    public Country WesternUnitedStates = new Country("Western United States", "North America", 3);
    public Country Argentina = new Country("Argentina", "South America", 1);
    public Country Brazil = new Country("Brazil", "South America", 2);
    public Country Peru = new Country("Peru", "South America", 1);
    public Country Venezuela = new Country("Venezuela", "South America", 1);
    public Country GreatBritain = new Country("Great Britain", "Europe", 2);
    public Country Iceland = new Country("Iceland", "Europe", 1);
    public Country NorthernEurope = new Country("Northern Europe", "Europe", 3);
    public Country Scandinavia = new Country("Scandinavia", "Europe", 2);
    public Country SouthernEurope = new Country("Southern Europe", "Europe", 3);
    public Country Ukraine = new Country("Ukraine", "Europe", 1);
    public Country WesternEurope = new Country("Western Europe", "Europe", 3);
    public Country Congo = new Country("Congo", "Africa", 1);
    public Country EastAfrica = new Country("East Africa", "Africa", 2);
    public Country Egypt = new Country("Egypt", "Africa", 1);
    public Country Madagascar = new Country("Madagascar", "Africa", 1);
    public Country NorthAfrica = new Country("North Africa", "Africa", 2);
    public Country SouthAfrica = new Country("South Africa", "Africa", 2);
    public Country Afghanistan = new Country("Afghanistan", "Asia", 1);
    public Country China = new Country("China", "Asia", 3);
    public Country India = new Country("India", "Asia", 3);
    public Country Irkutsk = new Country("Irkutsk", "Asia", 1);
    public Country Japan = new Country("Japan", "Asia", 2);
    public Country Kamchatka = new Country("Kamchatka", "Asia", 1);
    public Country MiddleEast = new Country("Middle East", "Asia", 3);
    public Country Mongolia = new Country("Mongolia", "Asia", 1);
    public Country Siam = new Country("Siam", "Asia", 2);
    public Country Siberia = new Country("Siberia", "Asia", 1);
    public Country Ural = new Country("Ural", "Asia", 1);
    public Country Yakutsk = new Country("Yakutsk", "Asia", 1);
    public Country EasternAustralia = new Country("Eastern Australia", "Australia", 3);
    public Country Indonesia = new Country("Indonesia", "Australia", 2);
    public Country NewGuinea = new Country("New Guinea", "Australia", 1);
    public Country WesternAustralia = new Country("Western Australia", "Australia", 2);
    
    public Country[] AlaskaNeighbours = {Alberta, NorthwestTerritory, Kamchatka};
    public Country[] AlbertaNeighbours = {Alaska, NorthwestTerritory, Ontario, WesternUnitedStates};
    public Country[] CentralAmericaNeighbours = {WesternUnitedStates, Venezuela};
    public Country[] EasternUnitedStatesNeighbours = {WesternUnitedStates, Ontario, Quebec};
    public Country[] GreenlandNeighbours = {NorthwestTerritory, Ontario, Quebec, Iceland};
    public Country[] NorthwestTerritoryNeighbours = {Alaska, Greenland, Ontario, Alberta};
    public Country[] OntarioNeighbours = {NorthwestTerritory, Greenland, Quebec, EasternUnitedStates, WesternUnitedStates, Alberta};
    public Country[] QuebecNeighbours = {Ontario, Greenland, EasternUnitedStates};
    public Country[] WesternUnitedStatesNeighbours = {Alberta, Ontario, EasternUnitedStates ,CentralAmerica};
    public Country[] ArgentinaNeighbours = {Peru, Brazil};
    public Country[] BrazilNeighbours = {Venezuela, NorthAfrica, Argentina, Peru};
    public Country[] PeruNeighbours = {Argentina, Brazil, Venezuela};
    public Country[] VenezuelaNeighbours = {CentralAmerica, Brazil, Argentina};
    public Country[] GreatBritainNeighbours = {Iceland, Scandinavia, NorthernEurope, WesternEurope};
    public Country[] IcelandNeighbours = {Greenland, GreatBritain};
    public Country[] NorthernEuropeNeighbours = {GreatBritain, Ukraine, SouthernEurope, WesternEurope};
    public Country[] ScandinaviaNeighbours = {GreatBritain, Ukraine};
    public Country[] SouthernEuropeNeighbours = {WesternEurope, NorthernEurope, Ukraine, Egypt, NorthAfrica};
    public Country[] UkraineNeighbours = {Scandinavia, Ural, Afghanistan, MiddleEast, SouthernEurope, NorthernEurope};
    public Country[] WesternEuropeNeighbours = {GreatBritain, NorthernEurope, SouthernEurope, NorthAfrica};
    public Country[] CongoNeighbours = {NorthAfrica, Egypt, EastAfrica, SouthAfrica};
    public Country[] EastAfricaNeighbours = {Egypt, Madagascar, SouthAfrica, Congo};
    public Country[] EgyptNeighbours = {SouthernEurope, MiddleEast, EastAfrica, Congo, NorthAfrica};
    public Country[] MadagascarNeighbours = {EastAfrica, SouthAfrica};
    public Country[] NorthAfricaNeighbours = {WesternEurope, SouthernEurope, Egypt, Congo, Brazil};
    public Country[] SouthAfricaNeighbours = {Congo, EastAfrica, Madagascar};
    public Country[] AfghanistanNeighbours = {Ukraine, Ural, Siberia, China, India, MiddleEast};
    public Country[] ChinaNeighbours = {Afghanistan, Siberia, Mongolia, Siam, India};
    public Country[] IndiaNeighbours = {MiddleEast, Afghanistan, China, Siam};
    public Country[] IrkutskNeighbours = {Siberia, Yakutsk, Kamchatka, Mongolia};
    public Country[] JapanNeighbours = {Kamchatka, Mongolia};
    public Country[] KamchatkaNeighbours = {Yakutsk, Alaska, Japan, Mongolia, Irkutsk};
    public Country[] MiddleEastNeighbours = {Ukraine, Afghanistan, India, Egypt};
    public Country[] MongoliaNeighbours = {Siberia, Irkutsk, Kamchatka, Japan, China};
    public Country[] SiamNeighbours = {India, China, Indonesia};
    public Country[] SiberiaNeighbours = {Ural, Yakutsk, Irkutsk, Mongolia, China, Afghanistan};
    public Country[] UralNeighbours = {Ukraine, Siberia, Afghanistan};
    public Country[] YakutskNeighbours = {Siberia, Kamchatka, Irkutsk};
    public Country[] EasternAustraliaNeighbours = {NewGuinea, WesternAustralia};
    public Country[] IndonesiaNeighbours = {EasternAustralia, NewGuinea};
    public Country[] NewGuineaNeighbours = {EasternAustralia, Indonesia, WesternAustralia};
    public Country[] WesternAustraliaNeighbours = {EasternAustralia, Indonesia, NewGuinea};

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
        Ukraine.setAdjacentCountries(UkraineNeighbours);
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
    
    Country[] NorthAmericaCountries = {Alaska, Alberta, CentralAmerica, EasternUnitedStates, Greenland, NorthwestTerritory, Ontario, Quebec, WesternUnitedStates};
    Country[] SouthAmericaCountries = {Argentina, Brazil, Peru, Venezuela};
    Country[] EuropeCountries = {GreatBritain, Iceland, NorthernEurope, Scandinavia, SouthernEurope, Ukraine, WesternEurope};
    Country[] AfricaCountries = {Congo, EastAfrica, Egypt, Madagascar, NorthAfrica, SouthAfrica};
    Country[] AsiaCountries = {Afghanistan, China, India, Irkutsk, Japan, Kamchatka, MiddleEast, Mongolia, Siam, Siberia, Ural, Yakutsk};
    Country[] AustraliaCountries = {EasternAustralia, Indonesia, NewGuinea, WesternAustralia};
    
    Continent NorthAmerica = new Continent("North America", 5, NorthAmericaCountries);
    Continent SouthAmerica = new Continent("South America", 2, SouthAmericaCountries);
    Continent Europe = new Continent("Europe", 5, EuropeCountries);
    Continent Africa = new Continent("Africa", 3, AfricaCountries);
    Continent Asia = new Continent("Asia", 7, AsiaCountries);
    Continent Australia = new Continent("Australia", 2, AustraliaCountries);
    
    public Country getCountry(String country)
    {
        Country countryFound = null;
        for (int i = 0; i < NorthAmericaCountries.length; i++)
        {
            if (NorthAmericaCountries[i].getName() == country)
            {
                countryFound = NorthAmericaCountries[i];
                return countryFound;
            }
        }
        
        for (int i = 0; i < SouthAmericaCountries.length; i++)
        {
            if (SouthAmericaCountries[i].getName() == country)
            {
                countryFound = SouthAmericaCountries[i];
                return countryFound;
            }
        }
        
        for (int i = 0; i < EuropeCountries.length; i++)
        {
            if (EuropeCountries[i].getName() == country)
            {
                countryFound = EuropeCountries[i];
                return countryFound;
            }
        }
        
        for (int i = 0; i < AfricaCountries.length; i++)
        {
            if (AfricaCountries[i].getName() == country)
            {
                countryFound = AfricaCountries[i];
                return countryFound;
            }
        }
        
        for (int i = 0; i < AsiaCountries.length; i++)
        {
            if (AsiaCountries[i].getName() == country)
            {
                countryFound = AsiaCountries[i];
                return countryFound;
            }
        }
        
        for (int i = 0; i < AustraliaCountries.length; i++)
        {
            if (AustraliaCountries[i].getName() == country)
            {
                countryFound = AustraliaCountries[i];
                return countryFound;
            }
        }
        return countryFound;
    }
}
