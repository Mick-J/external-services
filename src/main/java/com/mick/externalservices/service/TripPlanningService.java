package com.mick.externalservices.service;

import com.mick.externalservices.dto.*;
import com.mick.externalservices.utils.CommonUtils;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

@Service
public class TripPlanningService {
    private static final LocalDate MOCK_DATE = LocalDate.now();

    //
    public  List<Accommodation> getDestinationAccommodations(String airportCode) {
        CommonUtils.sleep(Duration.ofSeconds(1));
        return getAllAccommodations().getOrDefault(CommonUtils.normalize(airportCode), List.of());
    }

    //
    public  List<Event> getDestinationEvent(String airportCode) {
        CommonUtils.sleep(Duration.ofSeconds(1));
        return getAllEvents().getOrDefault(CommonUtils.normalize(airportCode), List.of());
    }

    public LocalRecommendations getLocalRecommendations(String airportCode) {
        CommonUtils.sleep(Duration.ofSeconds(1));
        return getAllLocalRecommendations().getOrDefault(CommonUtils.normalize(airportCode), null);
    }

    public Transportation getDestinationTransportation(String airportCode) {
        CommonUtils.sleep(Duration.ofSeconds(1));
        return getAllTransportation().getOrDefault(CommonUtils.normalize(airportCode), null);
    }

    public Weather getDestinationWeather(String airportCode) {
        CommonUtils.sleep(Duration.ofSeconds(1));
        return getAllWeather().getOrDefault(CommonUtils.normalize(airportCode), null);
    }

    /* **********************************************************************
        HELPERS
    **********************************************************************  */


    private  Map<String, List<Accommodation>> getAllAccommodations() {
        Map<String, List<Accommodation>> data = new LinkedHashMap<>();

        data.put( "LAS", List.of(
                new Accommodation("The Strip Resort & Casino", "Hotel", 220, 4.7),
                new Accommodation("Desert Oasis Villa", "Villa", 180, 4.5)));

        data.put( "ATL", List.of(
                new Accommodation("Peachtree Grand Hotel", "Hotel", 175, 4.5),
                new Accommodation("Midtown Garden Suites", "Apartment", 145, 4.3)));

        data.put( "JFK",List.of(
                new Accommodation("Manhattan Central Hotel", "Hotel", 260, 4.6),
                new Accommodation("Queens Comfort Suites", "Hotel", 185, 4.2)));

        data.put( "SFO",List.of(
                new Accommodation("Golden Gate Hotel", "Hotel", 240, 4.6),
                new Accommodation("Pacific Heights Residence", "Apartment", 210, 4.4)));

        data.put( "GRU",List.of(
                new Accommodation("Guarulhos Executive Hotel", "Hotel", 120, 4.3),
                new Accommodation("São Paulo Garden Suites", "Hotel", 145, 4.5)));

        data.put( "GIG",List.of(
                new Accommodation("Copacabana Beach Hotel", "Hotel", 160, 4.6),
                new Accommodation("Rio Vista Apartments", "Apartment", 135, 4.3)));

        data.put( "BSB",List.of(
                new Accommodation("Brasília Palace Hotel", "Hotel", 130, 4.4),
                new Accommodation("Capital Suites", "Hotel", 105, 4.2)));

        data.put( "SSA", List.of(
                new Accommodation("Salvador Bahia Resort", "Resort", 150, 4.5),
                new Accommodation("Pelourinho Guest House", "Guesthouse", 90, 4.3)));

        data.put( "CDG", List.of(
                new Accommodation("Paris Airport Hotel", "Hotel", 190, 4.4),
                new Accommodation("Montmartre Boutique Hotel", "Hotel", 230, 4.7)));

        data.put( "NCE", List.of(
                new Accommodation("Nice Riviera Hotel", "Hotel", 210, 4.6),
                new Accommodation("Promenade Sea View", "Apartment", 195, 4.5)));

        data.put( "MRS", List.of(
                new Accommodation("Marseille Harbor Hotel", "Hotel", 145, 4.3),
                new Accommodation("Provence Guest Suites", "Guesthouse", 115, 4.2)));

        data.put( "BOD", List.of(
                new Accommodation("Bordeaux Wine Hotel", "Hotel", 155, 4.5),
                new Accommodation("Garonne Riverside Suites", "Apartment", 135, 4.3)));

        data.put( "FRA", List.of(
                new Accommodation("Frankfurt Central Hotel", "Hotel", 180, 4.4),
                new Accommodation("Main River Suites", "Apartment", 150, 4.3)));

        data.put( "MUC", List.of(
                new Accommodation("Munich City Hotel", "Hotel", 195, 4.6),
                new Accommodation("Bavarian Garden Inn", "Hotel", 165, 4.4)));

        data.put( "BER", List.of(
                new Accommodation("Berlin Mitte Hotel", "Hotel", 155, 4.5),
                new Accommodation("Brandenburg Suites", "Apartment", 135, 4.3)));

        data.put( "DUS", List.of(
                new Accommodation("Düsseldorf Riverside Hotel", "Hotel", 150, 4.4),
                new Accommodation("Rhine Comfort Suites", "Hotel", 125, 4.2)));

        data.put( "JNB", List.of(
                new Accommodation("Johannesburg Central Hotel", "Hotel", 120, 4.3),
                new Accommodation("Sandton Luxury Suites", "Hotel", 175, 4.6)));

        data.put( "CPT", List.of(
                new Accommodation("Cape Town Waterfront Hotel", "Hotel", 180, 4.7),
                new Accommodation("Table Mountain Lodge", "Lodge", 145, 4.5)));

        data.put( "DUR", List.of(
                new Accommodation("Durban Beach Resort", "Resort", 155, 4.5),
                new Accommodation("Golden Mile Hotel", "Hotel", 125, 4.3)));

        data.put( "HLA", List.of(
                new Accommodation("Lanseria Country Lodge", "Lodge", 105, 4.2),
                new Accommodation("Cradle Boutique Hotel", "Hotel", 130, 4.4)));

        data.put( "LOS", List.of(
                new Accommodation("Lagos Island Hotel", "Hotel", 140, 4.2),
                new Accommodation("Victoria Island Suites", "Hotel", 165, 4.5)));

        data.put( "ABV", List.of(
                new Accommodation("Abuja Central Hotel", "Hotel", 125, 4.3),
                new Accommodation("Millennium Residence", "Apartment", 110, 4.2)));

        data.put( "PHC", List.of(
                new Accommodation("Port Harcourt Garden Hotel", "Hotel", 105, 4.2),
                new Accommodation("Riverside Suites", "Hotel", 90, 4.0)));

        data.put( "ENU", List.of(
                new Accommodation("Enugu Grand Hotel", "Hotel", 95, 4.2),
                new Accommodation("Coal City Suites", "Hotel", 80, 4.0)));

        data.put( "PEK", List.of(
                new Accommodation("Beijing Capital Hotel", "Hotel", 170, 4.5),
                new Accommodation("Forbidden City Suites", "Hotel", 210, 4.7)));

        data.put( "PVG", List.of(
                new Accommodation("Shanghai Pudong Hotel", "Hotel", 180, 4.5),
                new Accommodation("Bund Riverside Suites", "Hotel", 220, 4.7)));

        data.put( "CAN", List.of(
                new Accommodation("Guangzhou Baiyun Hotel", "Hotel", 130, 4.3),
                new Accommodation("Pearl River Suites", "Apartment", 115, 4.2)));

        data.put( "SZX", List.of(
                new Accommodation("Shenzhen Bay Hotel", "Hotel", 150, 4.5),
                new Accommodation("Futian Business Suites", "Hotel", 135, 4.3)));

        data.put( "DEL", List.of(
                new Accommodation("Delhi Airport Hotel", "Hotel", 115, 4.3),
                new Accommodation("Connaught Place Suites", "Hotel", 140, 4.5)));

        data.put( "BOM", List.of(
                new Accommodation("Mumbai Central Hotel", "Hotel", 145, 4.4),
                new Accommodation("Marine Drive Suites", "Apartment", 175, 4.6)));

        data.put( "BLR", List.of(
                new Accommodation("Bengaluru Tech Park Hotel", "Hotel", 125, 4.4),
                new Accommodation("Garden City Suites", "Hotel", 110, 4.2)));

        data.put( "HYD", List.of(
                new Accommodation("Hyderabad Airport Hotel", "Hotel", 110, 4.3),
                new Accommodation("Hitech City Suites", "Apartment", 120, 4.4)));

        data.put( "SYD", List.of(
                new Accommodation("Sydney Harbour Hotel", "Hotel", 240, 4.7),
                new Accommodation("Bondi Beach Suites", "Apartment", 220, 4.6)));

        data.put( "MEL", List.of(
                new Accommodation("Melbourne Central Hotel", "Hotel", 190, 4.6),
                new Accommodation("Yarra River Suites", "Apartment", 175, 4.4)));

        data.put( "BNE", List.of(
                new Accommodation("Brisbane Riverside Hotel", "Hotel", 165, 4.4),
                new Accommodation("South Bank Suites", "Apartment", 145, 4.3)));

        data.put( "ADL", List.of(
                new Accommodation("Adelaide Central Hotel", "Hotel", 145, 4.4),
                new Accommodation("Glenelg Beach Suites", "Apartment", 130, 4.3)));

        return data;
    }



    private  Map<String, List<Event>> getAllEvents() {
        Map<String, List<Event>> data = new LinkedHashMap<>();

        // USA
        data.put("LAS", List.of(
                new Event(
                        "Cirque du Soleil: O Show",
                        "Witness an aquatic masterpiece by Cirque du Soleil.",
                        MOCK_DATE.plusDays(1)),
                new Event(
                        "Red Rock Canyon Tour",
                        "Explore the stunning landscapes of Red Rock Canyon.",
                        MOCK_DATE.plusDays(1))
        ));

        data.put("ATL", List.of(new Event("Atlanta Food & Wine Experience",
                        "Discover local Southern cuisine and wines.",
                        MOCK_DATE.plusDays(1)),
                new Event("Georgia Aquarium Visit",
                        "Explore one of the world's largest aquariums.",
                        MOCK_DATE.plusDays(2))));

        data.put("JFK", List.of(new Event("Broadway Evening Show",
                        "Enjoy a live Broadway performance in Manhattan.",
                        MOCK_DATE.plusDays(1)),
                new Event("Central Park Walking Tour",
                        "Discover the landmarks and paths of Central Park.",
                        MOCK_DATE.plusDays(2))));

        data.put("SFO", List.of(new Event("Golden Gate Bay Cruise",
                        "Cruise the bay with views of the Golden Gate Bridge.",
                        MOCK_DATE.plusDays(1)),
                new Event("Alcatraz Island Tour",
                        "Visit the historic former federal penitentiary.",
                        MOCK_DATE.plusDays(2))));

        // Brazil
        data.put("GRU", List.of(
                new Event("Avenida Paulista Walk", "Stroll along São Paulo's iconic cultural and financial avenue.", MOCK_DATE.plusDays(1)),
                new Event("Ibirapuera Park Visit", "Relax in the vast green oasis featuring museums and modern architecture.", MOCK_DATE.plusDays(2))
        ));
        data.put("GIG", List.of(
                new Event("Christ the Redeemer Tour", "Take the train up Corcovado Mountain to see the wonder of Rio.", MOCK_DATE.plusDays(1)),
                new Event("Copacabana Beach Day", "Enjoy the vibrant beach culture and stunning seaside views.", MOCK_DATE.plusDays(2))
        ));
        data.put("BSB", List.of(
                new Event("Oscar Niemeyer Architecture Tour", "Explore Brasília's unique futuristic federal buildings and cathedral.", MOCK_DATE.plusDays(1)),
                new Event("Paranoá Lake Cruise", "Enjoy a scenic boat cruise around the city's massive artificial lake.", MOCK_DATE.plusDays(2))
        ));
        data.put("SSA", List.of(
                new Event("Pelourinho Historic Center", "Walk through the colorful, historic Afro-Brazilian heart of Salvador.", MOCK_DATE.plusDays(1)),
                new Event("Elevador Lacerda & Mercado", "Ride the iconic art deco elevator down to the traditional artisan market.", MOCK_DATE.plusDays(2))
        ));

    // France
        data.put("CDG", List.of(
                new Event("Louvre Museum Tour", "See the Mona Lisa and thousands of historic treasures in Paris.", MOCK_DATE.plusDays(1)),
                new Event("Eiffel Tower Summit", "Take in the breathtaking panoramic views of the City of Light.", MOCK_DATE.plusDays(2))
        ));
        data.put("NCE", List.of(
                new Event("Promenade des Anglais Stroll", "Walk along Nice's world-famous Mediterranean waterfront boardwalk.", MOCK_DATE.plusDays(1)),
                new Event("Castle Hill Panorama", "Climb the historic hill for sweeping views of the Baie des Anges.", MOCK_DATE.plusDays(2))
        ));
        data.put("MRS", List.of(
                new Event("Vieux-Port Seafood Dinner", "Savor authentic Bouillabaisse at Marseille's vibrant historic port.", MOCK_DATE.plusDays(1)),
                new Event("Calanques National Park Hike", "Explore the dramatic limestone cliffs and hidden turquoise bays.", MOCK_DATE.plusDays(2))
        ));
        data.put("BOD", List.of(
                new Event("La Cité du Vin Exhibition", "Immerse yourself in a high-tech museum dedicated to the history of wine.", MOCK_DATE.plusDays(1)),
                new Event("Place de la Bourse & Water Mirror", "Photograph Bordeaux's classic architecture reflected on the grand plaza.", MOCK_DATE.plusDays(2))
        ));

        // Germany
        data.put("FRA", List.of(
                new Event("Römerberg Square Tour", "Explore Frankfurt's rebuilt medieval old town and historic town hall.", MOCK_DATE.plusDays(1)),
                new Event("Main Tower Observation Deck", "Get a bird's-eye view of Germany's only major skyscraper skyline.", MOCK_DATE.plusDays(2))
        ));
        data.put("MUC", List.of(
                new Event("Marienplatz Glockenspiel Show", "Watch the famous mechanical clock perform in the center of Munich.", MOCK_DATE.plusDays(1)),
                new Event("Englischer Garten Surfing", "Watch urban river surfers ride the famous stationary Eisbach wave.", MOCK_DATE.plusDays(2))
        ));
        data.put("BER", List.of(
                new Event("Brandenburg Gate Walk", "Stand before Berlin's historic symbol of unity and peace.", MOCK_DATE.plusDays(1)),
                new Event("East Side Gallery Exhibition", "Walk along the longest remaining stretch of the historic Berlin Wall.", MOCK_DATE.plusDays(2))
        ));
        data.put("DUS", List.of(
                new Event("Altstadt Brewery Tour", "Sample traditional Altbier in Düsseldorf's legendary old town.", MOCK_DATE.plusDays(1)),
                new Event("Rheinturm Lookout", "Ascend the Rhine Tower for views spanning across the river valley.", MOCK_DATE.plusDays(2))
        ));

        // South Africa
        data.put("JNB", List.of(
                new Event("Apartheid Museum Journey", "Gain deep emotional insights into the history of modern South Africa.", MOCK_DATE.plusDays(1)),
                new Event("Soweto Heritage Tour", "Visit Vilakazi Street, the former home of Nelson Mandela.", MOCK_DATE.plusDays(2))
        ));
        data.put("CPT", List.of(
                new Event("Table Mountain Cableway", "Ride up the iconic flat-topped mountain for sweeping ocean views.", MOCK_DATE.plusDays(1)),
                new Event("Cape Peninsula Coastal Drive", "See the rugged Atlantic coast and visit the penguins at Boulders Beach.", MOCK_DATE.plusDays(2))
        ));
        data.put("DUR", List.of(
                new Event("Golden Mile Beachfront Walk", "Stroll Durban's warm, sunny Indian Ocean promenade.", MOCK_DATE.plusDays(1)),
                new Event("uShaka Marine World Safari", "Explore Africa's largest marine theme park and aquarium.", MOCK_DATE.plusDays(2))
        ));
        data.put("HLA", List.of(
                new Event("Cradle of Humankind Exploration", "Discover ancient hominid fossils at Sterkfontein Caves near Lanseria.", MOCK_DATE.plusDays(1)),
                new Event("Lion & Safari Park Drive", "See lions, cheetahs, and wild dogs in a protected safari habitat.", MOCK_DATE.plusDays(2))
        ));

        // Nigeria
        data.put("LOS", List.of(
                new Event("Lekki Conservation Centre", "Walk above the rain forest canopy on Africa's longest canopy walkway.", MOCK_DATE.plusDays(1)),
                new Event("Nike Art Gallery Tour", "Explore thousands of diverse pieces of contemporary Nigerian art.", MOCK_DATE.plusDays(2))
        ));
        data.put("ABV", List.of(
                new Event("Zuma Rock Excursion", "Visit the massive, majestic natural monolith just outside Abuja.", MOCK_DATE.plusDays(1)),
                new Event("Millennium Park Relax", "Stroll through Abuja's largest green park designed by Manfredi Nicoletti.", MOCK_DATE.plusDays(2))
        ));
        data.put("PHC", List.of(
                new Event("Port Harcourt Pleasure Park", "Enjoy boat rides, mini-golf, and a peaceful day out in nature.", MOCK_DATE.plusDays(1)),
                new Event("Cultural Centre Exhibition", "Discover rich Niger Delta historical artifacts and local dance drama.", MOCK_DATE.plusDays(2))
        ));
        data.put("ENU", List.of(
                new Event("Ngwo Pine Forest & Cave", "Trek through stunning pine trees to reach a hidden waterfall cave.", MOCK_DATE.plusDays(1)),
                new Event("Udi Hills Scenic Drive", "Take in beautiful high-altitude views of the historic coal city.", MOCK_DATE.plusDays(2))
        ));

        // China
        data.put("PEK", List.of(
                new Event("Great Wall of China Trek", "Hike the historic Mutianyu section of the ancient stone fortress.", MOCK_DATE.plusDays(1)),
                new Event("Forbidden City Tour", "Explore the vast imperial palace complex of the Ming and Qing dynasties.", MOCK_DATE.plusDays(2))
        ));
        data.put("PVG", List.of(
                new Event("The Bund Skyline Walk", "Admire colonial history across the river from futuristic mega-skyscrapers.", MOCK_DATE.plusDays(1)),
                new Event("Yu Garden & Bazaar Tour", "Explore traditional Ming Dynasty classical gardens and tea houses.", MOCK_DATE.plusDays(2))
        ));
        data.put("CAN", List.of(
                new Event("Canton Tower Ascent", "Scale one of the world's tallest TV towers for views over Guangzhou.", MOCK_DATE.plusDays(1)),
                new Event("Traditional Dim Sum Breakfast", "Experience the classic Cantonese culinary art of morning tea.", MOCK_DATE.plusDays(2))
        ));
        data.put("SZX", List.of(
                new Event("Splendid China Folk Village", "See miniature replicas of China's top landmarks and cultural exhibits.", MOCK_DATE.plusDays(1)),
                new Event("Ping An Finance Centre View", "Look out from the observation deck of Shenzhen's tallest skyscraper.", MOCK_DATE.plusDays(2))
        ));

        // India
        data.put("DEL", List.of(
                new Event("Red Fort & Old Delhi Rickshaw", "Ride through chaotic, historic markets and view the grand fortress.", MOCK_DATE.plusDays(1)),
                new Event("Qutub Minar Complex", "Marvel at the world's tallest brick minaret built in the 12th century.", MOCK_DATE.plusDays(2))
        ));
        data.put("BOM", List.of(
                new Event("Gateway of India Visit", "Stand by Mumbai's iconic waterfront arch facing the Arabian Sea.", MOCK_DATE.plusDays(1)),
                new Event("Marine Drive Sunset Cruise", "Watch the sparkling city lights along Mumbai's sweeping arc coast.", MOCK_DATE.plusDays(2))
        ));
        data.put("BLR", List.of(
                new Event("Lalbagh Botanical Garden", "Explore a stunning 240-acre park featuring a historic glass house.", MOCK_DATE.plusDays(1)),
                new Event("Bangalore Palace Tour", "Step inside a royal palace built to resemble Windsor Castle.", MOCK_DATE.plusDays(2))
        ));
        data.put("HYD", List.of(
                new Event("Charminar Monument Tour", "Visit Hyderabad's iconic 16th-century four-column mosque building.", MOCK_DATE.plusDays(1)),
                new Event("Golconda Fort Sound & Light", "Watch an evening show bringing the massive medieval fort to life.", MOCK_DATE.plusDays(2))
        ));

        // Australia
        data.put("SYD", List.of(
                new Event("Sydney Opera House Tour", "Step inside the sails of the world's most famous performing arts venue.", MOCK_DATE.plusDays(1)),
                new Event("Bondi to Coogee Coastal Walk", "Enjoy stunning ocean cliffs and golden sandy beaches.", MOCK_DATE.plusDays(2))
        ));
        data.put("MEL", List.of(
                new Event("Laneway Cafe & Graffiti Tour", "Explore Melbourne's famous hidden espresso bars and street art.", MOCK_DATE.plusDays(1)),
                new Event("Royal Botanic Gardens Stroll", "Relax in an expansive green landscape on the edge of the Yarra River.", MOCK_DATE.plusDays(2))
        ));
        data.put("BNE", List.of(
                new Event("South Bank Parklands Lagoon", "Swim at Australia's only inner-city, man-made inner beach.", MOCK_DATE.plusDays(1)),
                new Event("Lone Pine Koala Sanctuary", "Get close to native Australian wildlife and feed kangaroos.", MOCK_DATE.plusDays(2))
        ));
        data.put("ADL", List.of(
                new Event("Adelaide Central Market Feast", "Taste fresh, artisanal local produce in a bustling 150-year-old market.", MOCK_DATE.plusDays(1)))
        );

        return data;
    }

    //
    private Map<String, LocalRecommendations>  getAllLocalRecommendations() {
        Map<String, LocalRecommendations> data = new LinkedHashMap<>();
        
        data.put("LAS", new LocalRecommendations(
                        List.of("Joël Robuchon", "Bacchanal Buffet"),
                        List.of("The Las Vegas Strip", "Fremont Street Experience")));

        data.put("ATL", new LocalRecommendations(
                List.of("The Varsity", "Ponce City Market"),
                List.of("Georgia Aquarium", "Piedmont Park")));

        data.put("JFK", new LocalRecommendations(
                List.of("Katz's Delicatessen", "Peter Luger Steak House"),
                List.of("Central Park", "Times Square")));

        data.put("SFO", new LocalRecommendations(
                List.of("Tartine Bakery", "Foreign Cinema"),
                List.of("Golden Gate Bridge", "Fisherman's Wharf")));

        data.put("GRU", new LocalRecommendations(
                List.of("D.O.M.", "A Casa do Porco"),
                List.of("Ibirapuera Park", "Paulista Avenue")));

        data.put("GIG", new LocalRecommendations(
                List.of("Aprazível", "Confeitaria Colombo"),
                List.of("Copacabana Beach", "Sugarloaf Mountain")));

        data.put("BSB", new LocalRecommendations(
                List.of("Mangai", "Dom Francisco"),
                List.of("Cathedral of Brasília", "Praça dos Três Poderes")));

        data.put("SSA", new LocalRecommendations(
                List.of("Casa de Tereza", "Soho Restaurant"),
                List.of("Pelourinho", "Farol da Barra")));

        data.put("CDG", new LocalRecommendations(
                List.of("Le Comptoir du Relais", "L'As du Fallafel"),
                List.of("Eiffel Tower", "Louvre Museum")));

        data.put("NCE", new LocalRecommendations(
                List.of("La Merenda", "Le Plongeoir"),
                List.of("Promenade des Anglais", "Old Nice")));

        data.put("MRS", new LocalRecommendations(
                List.of("Chez Fonfon", "Le Petit Nice"),
                List.of("Vieux-Port", "Notre-Dame de la Garde")));

        data.put("BOD", new LocalRecommendations(
                List.of("La Tupina", "Le Chien de Pavlov"),
                List.of("Place de la Bourse", "Cité du Vin")));

        data.put("FRA", new LocalRecommendations(
                List.of("Apfelwein Wagner", "Kleinmarkthalle"),
                List.of("Römerberg", "Main Tower")));

        data.put("MUC", new LocalRecommendations(
                List.of("Hofbräuhaus", "Viktualienmarkt"),
                List.of("Marienplatz", "English Garden")));

        data.put("BER", new LocalRecommendations(
                List.of("Curry 36", "Markthalle Neun"),
                List.of("Brandenburg Gate", "Museum Island")));

        data.put("DUS", new LocalRecommendations(
                List.of("Im Schiffchen", "Uerige"),
                List.of("Rhine Promenade", "Königsallee")));

        data.put("JNB", new LocalRecommendations(
                List.of("Marble Restaurant", "Maboneng Market"),
                List.of("Apartheid Museum", "Constitution Hill")));

        data.put("CPT", new LocalRecommendations(
                List.of("The Pot Luck Club", "Kloof Street House"),
                List.of("Table Mountain", "V&A Waterfront")));

        data.put("DUR", new LocalRecommendations(
                List.of("Butcher Boys", "Cargo Hold"),
                List.of("uShaka Marine World", "Golden Mile")));

        data.put("HLA", new LocalRecommendations(
                List.of("Tug Restaurant", "Roots"),
                List.of("Cradle of Humankind", "Lesedi Cultural Village")));

        data.put("LOS", new LocalRecommendations(
                List.of("Yellow Chilli", "Terra Kulture"),
                List.of("Lekki Conservation Centre", "Nike Art Gallery")));

        data.put("ABV", new LocalRecommendations(
                List.of("BluCabana", "Nkoyo"),
                List.of("Millennium Park", "Aso Rock")));

        data.put("PHC", new LocalRecommendations(
                List.of("Genesis Restaurant", "The Garden City Restaurant"),
                List.of("Isaac Boro Park", "Port Harcourt Tourist Beach")));

        data.put("ENU", new LocalRecommendations(
                List.of("Roots Restaurant", "Nike Lake Resort Restaurant"),
                List.of("Ngwo Pine Forest", "Awhum Waterfall")));

        data.put("PEK", new LocalRecommendations(
                List.of("Da Dong", "Quanjude Roast Duck"),
                List.of("Forbidden City", "Temple of Heaven")));

        data.put("PVG", new LocalRecommendations(
                List.of("Din Tai Fung", "Jesse Restaurant"),
                List.of("The Bund", "Yu Garden")));

        data.put("CAN", new LocalRecommendations(
                List.of("Guangzhou Restaurant", "Bingsheng Mansion"),
                List.of("Canton Tower", "Chen Clan Ancestral Hall")));

        data.put("SZX", new LocalRecommendations(
                List.of("Laurel Restaurant", "Xiangmiyuan"),
                List.of("Window of the World", "Shenzhen Bay Park")));

        data.put("DEL", new LocalRecommendations(
                List.of("Indian Accent", "Bukhara"),
                List.of("India Gate", "Qutub Minar")));

        data.put("BOM", new LocalRecommendations(
                List.of("Masque", "Trishna"),
                List.of("Gateway of India", "Marine Drive")));

        data.put("BLR", new LocalRecommendations(
                List.of("Karavalli", "Toit"),
                List.of("Lalbagh Botanical Garden", "Cubbon Park")));

        data.put("HYD", new LocalRecommendations(
                List.of("Jewel of Nizam", "Shah Ghouse"),
                List.of("Charminar", "Golconda Fort")));

        data.put("SYD", new LocalRecommendations(
                List.of("Quay", "Bennelong"),
                List.of("Sydney Opera House", "Bondi Beach")));

        data.put("MEL", new LocalRecommendations(
                List.of("Attica", "Chin Chin"),
                List.of("Federation Square", "Royal Botanic Gardens")));

        data.put("BNE", new LocalRecommendations(
                List.of("Eagle Street Pier", "Gerard's Bar"),
                List.of("South Bank", "Lone Pine Koala Sanctuary")));

        data.put("ADL", new LocalRecommendations(
                List.of("Orana", "Africola"),
                List.of("Adelaide Central Market", "Glenelg Beach")));

        return data;
    }


    private Map<String, Transportation> getAllTransportation() {
        Map<String, Transportation> data = new LinkedHashMap<>();

        // USA
        data.put("LAS", new Transportation(
                List.of(new CarRental("Avis", 75), new CarRental("Hertz", 82)),
                List.of(new PublicTransportation("RTC Transit", "5"), new PublicTransportation("Airport Shuttle", "15"))
        ));
        data.put("ATL", new Transportation(
                List.of(new CarRental("Enterprise", 65), new CarRental("Sixt", 74)),
                List.of(new PublicTransportation("MARTA Train", "2.50"), new PublicTransportation("Shared Shuttle", "20"))
        ));
        data.put("JFK", new Transportation(
                List.of(new CarRental("Budget", 90), new CarRental("Alamo", 95)),
                List.of(new PublicTransportation("AirTrain + Subway", "11.25"), new PublicTransportation("Express Bus", "19"))
        ));
        data.put("SFO", new Transportation(
                List.of(new CarRental("National", 85), new CarRental("Thrifty", 70)),
                List.of(new PublicTransportation("BART Train", "10.50"), new PublicTransportation("SamTrans Bus", "2.25"))
        ));

    // Brazil
        data.put("GRU", new Transportation(
                List.of(new CarRental("Localiza", 45), new CarRental("Movida", 42)),
                List.of(new PublicTransportation("CPTM Train (Line 13)", "5"), new PublicTransportation("Airport Bus Service", "45"))
        ));
        data.put("GIG", new Transportation(
                List.of(new CarRental("Unidas", 48), new CarRental("Localiza", 52)),
                List.of(new PublicTransportation("BRT Express Bus", "4.30"), new PublicTransportation("Premium Real Bus", "16"))
        ));
        data.put("BSB", new Transportation(
                List.of(new CarRental("Movida", 40), new CarRental("Foco", 35)),
                List.of(new PublicTransportation("Executive Bus (Line 113)", "12"), new PublicTransportation("Urban Bus", "5.50"))
        ));
        data.put("SSA", new Transportation(
                List.of(new CarRental("Localiza", 43), new CarRental("Unidas", 41)),
                List.of(new PublicTransportation("Metro Shuttle + Subway", "4.10"), new PublicTransportation("Urban Bus", "4.90"))
        ));

        // France
        data.put("CDG", new Transportation(
                List.of(new CarRental("Europcar", 80), new CarRental("Sixt", 88)),
                List.of(new PublicTransportation("RER B Train", "11.80"), new PublicTransportation("RoissyBus", "16.60"))
        ));
        data.put("NCE", new Transportation(
                List.of(new CarRental("Hertz", 70), new CarRental("Enterprise", 65)),
                List.of(new PublicTransportation("Nice Tramway (Line 2)", "1.70"), new PublicTransportation("TER Regional Train", "3.50"))
        ));
        data.put("MRS", new Transportation(
                List.of(new CarRental("Sixt", 75), new CarRental("Avis", 72)),
                List.of(new PublicTransportation("Airport Shuttle Bus", "10"), new PublicTransportation("TER Train (Vitrolles)", "5.20"))
        ));
        data.put("BOD", new Transportation(
                List.of(new CarRental("Goldcar", 55), new CarRental("Europcar", 68)),
                List.of(new PublicTransportation("Tramway Line A", "1.80"), new PublicTransportation("30'Direct Shuttle", "8"))
        ));

        // Germany
        data.put("FRA", new Transportation(
                List.of(new CarRental("Sixt", 85), new CarRental("Hertz", 78)),
                List.of(new PublicTransportation("S-Bahn (S8/S9)", "5.80"), new PublicTransportation("Lufthansa Express Bus", "12"))
        ));
        data.put("MUC", new Transportation(
                List.of(new CarRental("Europcar", 90), new CarRental("Enterprise", 82)),
                List.of(new PublicTransportation("S-Bahn (S1/S8)", "13.60"), new PublicTransportation("Lufthansa Express Bus", "11"))
        ));
        data.put("BER", new Transportation(
                List.of(new CarRental("Avis", 70), new CarRental("Sixt", 79)),
                List.of(new PublicTransportation("Airport Express (FEX)", "4.40"), new PublicTransportation("S-Bahn (S9)", "4.40"))
        ));
        data.put("DUS", new Transportation(
                List.of(new CarRental("Buchbinder", 60), new CarRental("Hertz", 72)),
                List.of(new PublicTransportation("SkyTrain + RE Train", "3.30"), new PublicTransportation("Urban Bus 721", "3.30"))
        ));

        // South Africa
        data.put("JNB", new Transportation(
                List.of(new CarRental("Bidvest", 35), new CarRental("Tempest", 32)),
                List.of(new PublicTransportation("Gautrain", "220"), new PublicTransportation("Rea Vaya Bus", "25"))
        ));
        data.put("CPT", new Transportation(
                List.of(new CarRental("First Car Rental", 38), new CarRental("Hertz", 45)),
                List.of(new PublicTransportation("MyCiTi Bus (Route A01)", "100"), new PublicTransportation("Private Shuttle", "250"))
        ));
        data.put("DUR", new Transportation(
                List.of(new CarRental("Avis", 40), new CarRental("Bidvest", 37)),
                List.of(new PublicTransportation("Airport Shuttle Bus", "80"), new PublicTransportation("Local Coach", "50"))
        ));
        data.put("HLA", new Transportation(
                List.of(new CarRental("Europcar", 36), new CarRental("Tempest", 33)),
                List.of(new PublicTransportation("Lanseria Airport Shuttle", "120"), new PublicTransportation("Private Transfer", "300"))
        ));

        // Nigeria
        data.put("LOS", new Transportation(
                List.of(new CarRental("Sixt Nigeria", 110), new CarRental("Avis Nigeria", 125)),
                List.of(new PublicTransportation("LAGBUS / BRT", "1200"), new PublicTransportation("Airport Car Hire", "15000"))
        ));
       
        data.put("ABV", new Transportation(
                List.of(new CarRental("Hertz Nigeria", 115), new CarRental("Sixt Nigeria", 120)),
                List.of(new PublicTransportation("Abuja Metro Rail", "1000"), new PublicTransportation("Official Airport Taxi", "10000"))
        ));
        data.put("PHC", new Transportation(
                List.of(new CarRental("Avis Nigeria", 130), new CarRental("Local Executive Car", 140)),
                List.of(new PublicTransportation("Regional Shuttle", "2500"), new PublicTransportation("City Taxi", "8000"))
        ));
        data.put("ENU", new Transportation(
                List.of(new CarRental("Local Executive Car", 120), new CarRental("Chauffeur Services", 135)),
                List.of(new PublicTransportation("Intra-City Bus", "800"), new PublicTransportation("Registered Airport Cab", "6000"))
        ));

        // China
        data.put("PEK", new Transportation(
                List.of(new CarRental("Avis China", 65), new CarRental("Zuoche", 58)),
                List.of(new PublicTransportation("Capital Airport Express", "25"), new PublicTransportation("Airport Shuttle Bus", "30"))
        ));
        data.put("PVG", new Transportation(
                List.of(new CarRental("Hertz China", 68), new CarRental("Zuoche", 60)),
                List.of(new PublicTransportation("Maglev Train", "50"), new PublicTransportation("Metro Line 2", "7"))
        ));
        data.put("CAN", new Transportation(
                List.of(new CarRental("Zuoche", 55), new CarRental("eHi Car Services", 52)),
                List.of(new PublicTransportation("Metro Line 3", "8"), new PublicTransportation("Airport Express Bus", "25"))
        ));
        data.put("SZX", new Transportation(
                List.of(new CarRental("eHi Car Services", 57), new CarRental("Zuoche", 54)),
                List.of(new PublicTransportation("Metro Line 11", "7"), new PublicTransportation("Airport Shuttle Bus", "20"))
        ));

        // India
        data.put("DEL", new Transportation(
                List.of(new CarRental("Carzonrent", 50), new CarRental("Avis India", 55)),
                List.of(new PublicTransportation("Delhi Metro Orange Line", "60"), new PublicTransportation("DTC Airport Bus", "50"))
        ));
        data.put("BOM", new Transportation(
                List.of(new CarRental("Avis India", 58), new CarRental("Carzonrent", 52)),
                List.of(new PublicTransportation("Mumbai Metro Line 3", "40"), new PublicTransportation("BEST AC Bus", "60"))
        ));
        data.put("BLR", new Transportation(
                List.of(new CarRental("Zoomcar", 42), new CarRental("Myles", 45)),
                List.of(new PublicTransportation("Vayu Vajra AC Bus", "250"), new PublicTransportation("KSRTC Shuttle", "150"))
        ));
        data.put("HYD", new Transportation(
                List.of(new CarRental("Zoomcar", 40), new CarRental("Avis India", 52)),
                List.of(new PublicTransportation("Pushpak Airport Liner", "260"), new PublicTransportation("TSRTC Bus", "100"))
        ));

        // Australia
        data.put("SYD", new Transportation(
                List.of(new CarRental("Thrifty", 75), new CarRental("Europcar", 82)),
                List.of(new PublicTransportation("Airport Link Train", "19.50"), new PublicTransportation("Public Bus 420", "4.20"))
        ));
        data.put("MEL", new Transportation(
                List.of(new CarRental("Hertz", 78), new CarRental("Bargain Car Rentals", 64)),
                List.of(new PublicTransportation("SkyBus Express", "22"), new PublicTransportation("Public Bus 901", "4.60"))
        ));
        data.put("BNE", new Transportation(
                List.of(new CarRental("East Coast Car Rentals", 60), new CarRental("Enterprise", 72)),
                List.of(new PublicTransportation("Airtrain", "19.50"), new PublicTransportation("Con-X-ion Shuttle", "25"))
        ));
        data.put("ADL", new Transportation(
                List.of(new CarRental("Avis", 68), new CarRental("Budget", 65)),
                List.of(new PublicTransportation("JetExpress Bus J1", "4.05"), new PublicTransportation("Airport Shuttle", "15"))
        ));
        return data;
    }

    private Map<String, Weather> getAllWeather() {
        Map<String, Weather> data = new LinkedHashMap<>();

       data.put("LAS", new Weather(30, "Sunny"));
       data.put("ATL", new Weather(24, "Partly Cloudy"));
       data.put("JFK", new Weather(18, "Clear"));
       data.put("SFO", new Weather(17, "Foggy"));

       data.put("GRU", new Weather(23, "Partly Cloudy"));
       data.put("GIG", new Weather(26, "Sunny"));
       data.put("BSB", new Weather(27, "Sunny"));
       data.put("SSA", new Weather(28, "Sunny"));

       data.put("CDG", new Weather(15, "Cloudy"));
       data.put("NCE", new Weather(20, "Sunny"));
       data.put("MRS", new Weather(19, "Clear"));
       data.put("BOD", new Weather(17, "Cloudy"));

       data.put("FRA", new Weather(14, "Cloudy"));
       data.put("MUC", new Weather(12, "Partly Cloudy"));
       data.put("BER", new Weather(13, "Cloudy"));
       data.put("DUS", new Weather(14, "Rainy"));

       data.put("JNB", new Weather(23, "Sunny"));
       data.put("CPT", new Weather(21, "Clear"));
       data.put("DUR", new Weather(25, "Sunny"));
       data.put("HLA", new Weather(22, "Sunny"));

       data.put("LOS", new Weather(29, "Humid"));
       data.put("ABV", new Weather(27, "Sunny"));
       data.put("PHC", new Weather(28, "Partly Cloudy"));
       data.put("ENU", new Weather(26, "Sunny"));

       data.put("PEK", new Weather(16, "Clear"));
       data.put("PVG", new Weather(21, "Cloudy"));
       data.put("CAN", new Weather(28, "Sunny"));
       data.put("SZX", new Weather(27, "Partly Cloudy"));

       data.put("DEL", new Weather(30, "Sunny"));
       data.put("BOM", new Weather(29, "Humid"));
       data.put("BLR", new Weather(25, "Partly Cloudy"));
       data.put("HYD", new Weather(28, "Sunny"));

       data.put("SYD", new Weather(22, "Sunny"));
       data.put("MEL", new Weather(17, "Partly Cloudy"));
       data.put("BNE", new Weather(25, "Sunny"));
       data.put("ADL", new Weather(20, "Clear"));

        return data;
    }
}
