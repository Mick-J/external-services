package com.mick.externalservices.utils;

public enum AirportCode {

    // USA
    LAS("Las Vegas"),
    ATL("Atlanta"),
    JFK("New York City"),
    SFO("San Francisco"),

    // Brazil
    GRU("São Paulo / Guarulhos"),
    GIG("Rio de Janeiro / Galeão"),
    BSB("Brasília"),
    SSA("Salvador"),

    // France
    CDG("Paris / Charles de Gaulle"),
    NCE("Nice Côte d'Azur"),
    MRS("Marseille Provence"),
    BOD("Bordeaux–Mérignac"),

    // Germany
    FRA("Frankfurt"),
    MUC("Munich"),
    BER("Berlin Brandenburg"),
    DUS("Düsseldorf"),

    // South Africa
    JNB("Johannesburg / O.R. Tambo"),
    CPT("Cape Town"),
    DUR("Durban / King Shaka"),
    HLA("Johannesburg / Lanseria"),

    // Nigeria
    LOS("Lagos / Murtala Muhammed"),
    ABV("Abuja / Nnamdi Azikiwe"),
    PHC("Port Harcourt"),
    ENU("Enugu / Akanu Ibiam"),

    // China
    PEK("Beijing Capital"),
    PVG("Shanghai Pudong"),
    CAN("Guangzhou Baiyun"),
    SZX("Shenzhen Bao'an"),

    // India
    DEL("Delhi / Indira Gandhi"),
    BOM("Mumbai / Chhatrapati Shivaji Maharaj"),
    BLR("Bengaluru / Kempegowda"),
    HYD("Hyderabad / Rajiv Gandhi"),

    // Australia
    SYD("Sydney"),
    MEL("Melbourne"),
    BNE("Brisbane"),
    ADL("Adelaide");

    private final String name;

    AirportCode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}