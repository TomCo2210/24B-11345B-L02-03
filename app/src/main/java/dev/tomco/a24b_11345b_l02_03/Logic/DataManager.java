package dev.tomco.a24b_11345b_l02_03.Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.tomco.a24b_11345b_l02_03.Model.Country;
import dev.tomco.a24b_11345b_l02_03.R;

public class DataManager {

    private static String[] names = new String[]{
            "Mauritius",
            "Nicaragua",
            "Zimbabwe",
            "Italy",
            "Lebanon",
            "Syria",
            "Honduras",
            "Zambia",
            "Andorra",
            "Eritrea",
            "Iceland",
            "Barbados",
            "Pakistan",
            "Afghanistan",
            "Israel",
            "Croatia",
            "Trinidad And Tobago",
            "Poland",
            "Australia",
            "Mongolia",
    };
    private static int[] flagImages = new int[]{
            R.drawable._001_mauritius,
            R.drawable._007_nicaragua,
            R.drawable._011_zimbabwe,
            R.drawable._013_italy,
            R.drawable._018_lebanon,
            R.drawable._022_syria,
            R.drawable._024_honduras,
            R.drawable._032_zambia,
            R.drawable._045_andorra,
            R.drawable._065_eritrea,
            R.drawable._080_iceland,
            R.drawable._084_barbados,
            R.drawable._100_pakistan,
            R.drawable._111_afghanistan,
            R.drawable._155_israel,
            R.drawable._164_croatia,
            R.drawable._181_trinidad_and_tobago,
            R.drawable._211_poland,
            R.drawable._234_australia,
            R.drawable._258_mongolia,
    };
    private static boolean[] canEnter = new boolean[]{
            true,
            true,
            true,
            true,
            false,
            false,
            true,
            true,
            true,
            true,
            true,
            true,
            false,
            false,
            true,
            true,
            true,
            true,
            true,
            true,
    };

    public static List<Country> getCountries() {
        ArrayList<Country> countries = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            countries.add(
                    new Country()
                            .setName(names[i])
                            .setFlagImage(flagImages[i])
                            .setCanEnter(canEnter[i])
            );
        }
        Collections.shuffle(countries);
        return countries;
    }
}
