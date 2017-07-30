package com.chog0.weatherappyandexschool.resources;

public class MockData {

    public static final String MOCK_SUGGEST_TEXT = "mos";
    public static final String MOCK_PLACE_ID = "ChIJybDUc_xKtUYRTM9XV8zWRD0";

    public static final String MOCK_WEATHER_DATA =
            "{\n" +
                    "  \"coord\": {\n" +
                    "    \"lon\": 44.5,\n" +
                    "    \"lat\": 40.18\n" +
                    "  },\n" +
                    "  \"weather\": [\n" +
                    "    {\n" +
                    "      \"id\": 801,\n" +
                    "      \"main\": \"Clouds\",\n" +
                    "      \"description\": \"few clouds\",\n" +
                    "      \"icon\": \"02d\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"base\": \"stations\",\n" +
                    "  \"main\": {\n" +
                    "    \"temp\": 311.15,\n" +
                    "    \"pressure\": 1008,\n" +
                    "    \"humidity\": 13,\n" +
                    "    \"temp_min\": 311.15,\n" +
                    "    \"temp_max\": 311.15\n" +
                    "  },\n" +
                    "  \"visibility\": 10000,\n" +
                    "  \"wind\": {\n" +
                    "    \"speed\": 3.6,\n" +
                    "    \"deg\": 130\n" +
                    "  },\n" +
                    "  \"clouds\": {\n" +
                    "    \"all\": 24\n" +
                    "  },\n" +
                    "  \"dt\": 1501239600,\n" +
                    "  \"sys\": {\n" +
                    "    \"type\": 1,\n" +
                    "    \"id\": 7226,\n" +
                    "    \"message\": 0.0021,\n" +
                    "    \"country\": \"AM\",\n" +
                    "    \"sunrise\": 1501206999,\n" +
                    "    \"sunset\": 1501258786\n" +
                    "  },\n" +
                    "  \"id\": 616051,\n" +
                    "  \"name\": \"Yerevan\",\n" +
                    "  \"cod\": 200\n" +
                    "}";

    public static final String MOCK_PLACES_SUGGEST_DATA = "{\n" +
            "   \"predictions\" : [\n" +
            "      {\n" +
            "         \"description\" : \"Moscow, Russia\",\n" +
            "         \"id\" : \"1a0f08fcbc047354782f00ab52e66fb56d1aadf7\",\n" +
            "         \"matched_substrings\" : [\n" +
            "            {\n" +
            "               \"length\" : 3,\n" +
            "               \"offset\" : 0\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJybDUc_xKtUYRTM9XV8zWRD0\",\n" +
            "         \"reference\" : \"CjQmAAAAZy79t8JGhncHp_bMsBFkm1cdGg1EpyiIzf0zLFKSzSw5hczlxNki38f5Vi62-YxNEhAbkcGE2PatwXWxK5NyVW3nGhSIqLbSDBlIPIvFCLZW0hXVPQs-3Q\",\n" +
            "         \"structured_formatting\" : {\n" +
            "            \"main_text\" : \"Moscow\",\n" +
            "            \"main_text_matched_substrings\" : [\n" +
            "               {\n" +
            "                  \"length\" : 3,\n" +
            "                  \"offset\" : 0\n" +
            "               }\n" +
            "            ],\n" +
            "            \"secondary_text\" : \"Russia\"\n" +
            "         },\n" +
            "         \"terms\" : [\n" +
            "            {\n" +
            "               \"offset\" : 0,\n" +
            "               \"value\" : \"Moscow\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"offset\" : 8,\n" +
            "               \"value\" : \"Russia\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"types\" : [ \"locality\", \"political\", \"geocode\" ]\n" +
            "      },\n" +
            "      {\n" +
            "         \"description\" : \"Móstoles, Spain\",\n" +
            "         \"id\" : \"7277956a0ecb371ab26b2c7249b74dfab45f125e\",\n" +
            "         \"matched_substrings\" : [\n" +
            "            {\n" +
            "               \"length\" : 3,\n" +
            "               \"offset\" : 0\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJN8KDzdWNQQ0RkhLXONCLKRw\",\n" +
            "         \"reference\" : \"CjQoAAAAwfDJHJCqVqeqwJRUentntj4TXhdwvo85R7rAb9Xe-_hQSqb3LcoySUYwC4MYtfS3EhA9MvT5m70gSb74YdQUM-VnGhQk-9eezHQZQWuUG7H-kbHZNb58Jw\",\n" +
            "         \"structured_formatting\" : {\n" +
            "            \"main_text\" : \"Móstoles\",\n" +
            "            \"main_text_matched_substrings\" : [\n" +
            "               {\n" +
            "                  \"length\" : 3,\n" +
            "                  \"offset\" : 0\n" +
            "               }\n" +
            "            ],\n" +
            "            \"secondary_text\" : \"Spain\"\n" +
            "         },\n" +
            "         \"terms\" : [\n" +
            "            {\n" +
            "               \"offset\" : 0,\n" +
            "               \"value\" : \"Móstoles\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"offset\" : 10,\n" +
            "               \"value\" : \"Spain\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"types\" : [ \"locality\", \"political\", \"geocode\" ]\n" +
            "      },\n" +
            "      {\n" +
            "         \"description\" : \"Mosman, New South Wales, Australia\",\n" +
            "         \"id\" : \"a4598119b3d8d58e3624f83d2387442f905d9aae\",\n" +
            "         \"matched_substrings\" : [\n" +
            "            {\n" +
            "               \"length\" : 3,\n" +
            "               \"offset\" : 0\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJo_-SrTusEmsREMIyFmh9AQU\",\n" +
            "         \"reference\" : \"CkQ6AAAALcrKzzUO_VR8iO88yt3Y7ln9-dDacKB8_uzxiq910ujZyXeasKJOWeQ5njbqMQL5cMWySwlsj__2Io7AjN1owBIQeGTSA79sqyDqMqmFYLW7GxoUTx8nkJs5xy5ghxLn8StXSvrwEgI\",\n" +
            "         \"structured_formatting\" : {\n" +
            "            \"main_text\" : \"Mosman\",\n" +
            "            \"main_text_matched_substrings\" : [\n" +
            "               {\n" +
            "                  \"length\" : 3,\n" +
            "                  \"offset\" : 0\n" +
            "               }\n" +
            "            ],\n" +
            "            \"secondary_text\" : \"New South Wales, Australia\"\n" +
            "         },\n" +
            "         \"terms\" : [\n" +
            "            {\n" +
            "               \"offset\" : 0,\n" +
            "               \"value\" : \"Mosman\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"offset\" : 8,\n" +
            "               \"value\" : \"New South Wales\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"offset\" : 25,\n" +
            "               \"value\" : \"Australia\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"types\" : [ \"locality\", \"political\", \"geocode\" ]\n" +
            "      },\n" +
            "      {\n" +
            "         \"description\" : \"Mostar, Federation of Bosnia and Herzegovina, Bosnia and Herzegovina\",\n" +
            "         \"id\" : \"07dc47071701780220b81e0e43c7d8a1418cba04\",\n" +
            "         \"matched_substrings\" : [\n" +
            "            {\n" +
            "               \"length\" : 3,\n" +
            "               \"offset\" : 0\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJqUBjO6RDSxMRWnzj1LIyTwE\",\n" +
            "         \"reference\" : \"CmRcAAAA6I3k_t-VK66a1eFawXqMRACzGUx0mCTXWslCfYXPrEepiLlZVrqAtww9gPq2qnwGbCwF3sdfmaUljlE1vpi5hug52fEWDH9GIvYf0jSpqJEYsaBxAPGHZLkdxvJWj_GIEhAJa2lUFAt0fcxbcQMHmE_AGhSbUCTFVowKxtYxBNeqHWd63FPmmg\",\n" +
            "         \"structured_formatting\" : {\n" +
            "            \"main_text\" : \"Mostar\",\n" +
            "            \"main_text_matched_substrings\" : [\n" +
            "               {\n" +
            "                  \"length\" : 3,\n" +
            "                  \"offset\" : 0\n" +
            "               }\n" +
            "            ],\n" +
            "            \"secondary_text\" : \"Federation of Bosnia and Herzegovina, Bosnia and Herzegovina\"\n" +
            "         },\n" +
            "         \"terms\" : [\n" +
            "            {\n" +
            "               \"offset\" : 0,\n" +
            "               \"value\" : \"Mostar\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"offset\" : 8,\n" +
            "               \"value\" : \"Federation of Bosnia and Herzegovina\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"offset\" : 46,\n" +
            "               \"value\" : \"Bosnia and Herzegovina\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"types\" : [ \"locality\", \"political\", \"geocode\" ]\n" +
            "      },\n" +
            "      {\n" +
            "         \"description\" : \"Moses Lake, WA, United States\",\n" +
            "         \"id\" : \"2f4e0fd51b9ca0e5d3a506f013283de8db1cec54\",\n" +
            "         \"matched_substrings\" : [\n" +
            "            {\n" +
            "               \"length\" : 3,\n" +
            "               \"offset\" : 0\n" +
            "            }\n" +
            "         ],\n" +
            "         \"place_id\" : \"ChIJ27vfjjU_mVQRJCDl7OXrUD8\",\n" +
            "         \"reference\" : \"CkQ1AAAARdRYb9cPMqO6va1ooALMiEm-ge7dKq4hSEixBxvn4xzRZMgGf4hT-BMx2lul2FCZo-gmqtcQ9cQgIbZvgU9FCxIQaseB6FDZ0jZsCowujbVzQxoUMSbYTb4vaj4nzJ9W68zsGrttJbQ\",\n" +
            "         \"structured_formatting\" : {\n" +
            "            \"main_text\" : \"Moses Lake\",\n" +
            "            \"main_text_matched_substrings\" : [\n" +
            "               {\n" +
            "                  \"length\" : 3,\n" +
            "                  \"offset\" : 0\n" +
            "               }\n" +
            "            ],\n" +
            "            \"secondary_text\" : \"WA, United States\"\n" +
            "         },\n" +
            "         \"terms\" : [\n" +
            "            {\n" +
            "               \"offset\" : 0,\n" +
            "               \"value\" : \"Moses Lake\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"offset\" : 12,\n" +
            "               \"value\" : \"WA\"\n" +
            "            },\n" +
            "            {\n" +
            "               \"offset\" : 16,\n" +
            "               \"value\" : \"United States\"\n" +
            "            }\n" +
            "         ],\n" +
            "         \"types\" : [ \"locality\", \"political\", \"geocode\" ]\n" +
            "      }\n" +
            "   ],\n" +
            "   \"status\" : \"OK\"\n" +
            "}";

    public static final String MOCK_PLACES_DETAILS_DATA = "{\n" +
            "   \"html_attributions\" : [],\n" +
            "   \"result\" : {\n" +
            "      \"address_components\" : [\n" +
            "         {\n" +
            "            \"long_name\" : \"Moscow\",\n" +
            "            \"short_name\" : \"Moscow\",\n" +
            "            \"types\" : [ \"locality\", \"political\" ]\n" +
            "         },\n" +
            "         {\n" +
            "            \"long_name\" : \"Moskva\",\n" +
            "            \"short_name\" : \"Moskva\",\n" +
            "            \"types\" : [ \"administrative_area_level_2\", \"political\" ]\n" +
            "         },\n" +
            "         {\n" +
            "            \"long_name\" : \"Russia\",\n" +
            "            \"short_name\" : \"RU\",\n" +
            "            \"types\" : [ \"country\", \"political\" ]\n" +
            "         }\n" +
            "      ],\n" +
            "      \"adr_address\" : \"\\u003cspan class=\\\"locality\\\"\\u003eMoscow\\u003c/span\\u003e, \\u003cspan class=\\\"country-name\\\"\\u003eRussia\\u003c/span\\u003e\",\n" +
            "      \"formatted_address\" : \"Moscow, Russia\",\n" +
            "      \"geometry\" : {\n" +
            "         \"location\" : {\n" +
            "            \"lat\" : 55.755826,\n" +
            "            \"lng\" : 37.6173\n" +
            "         },\n" +
            "         \"viewport\" : {\n" +
            "            \"northeast\" : {\n" +
            "               \"lat\" : 56.009657,\n" +
            "               \"lng\" : 37.9456611\n" +
            "            },\n" +
            "            \"southwest\" : {\n" +
            "               \"lat\" : 55.48992699999999,\n" +
            "               \"lng\" : 37.3193289\n" +
            "            }\n" +
            "         }\n" +
            "      },\n" +
            "      \"icon\" : \"https://maps.gstatic.com/mapfiles/place_api/icons/geocode-71.png\",\n" +
            "      \"id\" : \"1a0f08fcbc047354782f00ab52e66fb56d1aadf7\",\n" +
            "      \"name\" : \"Moscow\",\n" +
            "      \"photos\" : [\n" +
            "         {\n" +
            "            \"height\" : 3869,\n" +
            "            \"html_attributions\" : [\n" +
            "               \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/103291604560917117840/photos\\\"\\u003e鍾懷亞\\u003c/a\\u003e\"\n" +
            "            ],\n" +
            "            \"photo_reference\" : \"CmRaAAAAuhlJWVJgJXF9BKb2nxm_ykrfHT4hlmOq3I1_IjvM5TyuOOmtv95Mszu2uu7yBlqoeGAYsp_yfSGvOEbPCCEGruv3NxIKJFyU94RpmUv6z3p--jeSEKCIHea8KPwIHmKUEhC289sIhn6d_FO4ER3nZoYsGhSEbF3sq8PaqONh7UhNGzYnXmFEjw\",\n" +
            "            \"width\" : 5803\n" +
            "         },\n" +
            "         {\n" +
            "            \"height\" : 2160,\n" +
            "            \"html_attributions\" : [\n" +
            "               \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/104489255406387162989/photos\\\"\\u003eСергей Шмаков\\u003c/a\\u003e\"\n" +
            "            ],\n" +
            "            \"photo_reference\" : \"CmRaAAAAMPQnqWkiS_-fATx5zol2cWC2YTshZrET6QHHUUv5ITIUfYVtjsk6N3mYWlmeSD-yEZa3cfInhLcuL_7wGAoYgm5EeYKOI6650F0zsSgvx5snbX7Tt4O5asSTxtGBFc_2EhD60zS357hK43cCSu3ThsZUGhTz67wh17XGt5iy6-TAJ7dl5tmkmA\",\n" +
            "            \"width\" : 3840\n" +
            "         },\n" +
            "         {\n" +
            "            \"height\" : 1333,\n" +
            "            \"html_attributions\" : [\n" +
            "               \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/107956383758290156645/photos\\\"\\u003eФлотилия &quot;Рэдиссон Ройал, Москва&quot;\\u003c/a\\u003e\"\n" +
            "            ],\n" +
            "            \"photo_reference\" : \"CmRaAAAAF8F3oBg7xX28ETsMzqR_7WmRaKSIcB71OrzYMSjTfKv4jI929VDoeDs5us-zIiLCOCRalIkBPSrYprsu-XvhAefg0iOHDZjzHUVVHTugX6BZBnJvkj3PKOQcRjTIazcVEhB079uQFYv0sW7DCmJ3NFC3GhQ0vb4O2UBsSZkm2zfSaz1J2B3seg\",\n" +
            "            \"width\" : 2000\n" +
            "         },\n" +
            "         {\n" +
            "            \"height\" : 2160,\n" +
            "            \"html_attributions\" : [\n" +
            "               \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/114911699120710775872/photos\\\"\\u003ePeriscopeLiveCorr\\u003c/a\\u003e\"\n" +
            "            ],\n" +
            "            \"photo_reference\" : \"CmRaAAAA-YlX4yjXs4Q64pcWD9793vp1prJ7Y042sK3WY16Tp3Ceb7bIcfXwBM-tFsjO3BKBnAWTCc5RLCR848Ep5dtsOQwJfnM3VOMQ1Ps1hTPj4YUO0TVh-k0mdP8EhCuLYXqVEhDcLNzsfYx8DW7-b4SbOJKGGhTmHpU4K-eZHg31IqDhH68z3akMgw\",\n" +
            "            \"width\" : 3840\n" +
            "         },\n" +
            "         {\n" +
            "            \"height\" : 2988,\n" +
            "            \"html_attributions\" : [\n" +
            "               \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/105260961063985950130/photos\\\"\\u003eEkaterina Rodkina\\u003c/a\\u003e\"\n" +
            "            ],\n" +
            "            \"photo_reference\" : \"CmRaAAAAY8DA4aGE_KFiuhEcqHbussi214weI0z4cv23o2aH0jrOfiMGAb-j6N93y8USUdLcEy7klT5SXz8jwzn8TBqujBWubrw2GNSLJU_brmsjJkey1lrBqs09aCxU0ErSq_8GEhBzxEQRSbyUPM4yiUcFXpZWGhS1aIQq3aBShRCDMXawuPxyrK8o5g\",\n" +
            "            \"width\" : 5312\n" +
            "         },\n" +
            "         {\n" +
            "            \"height\" : 1836,\n" +
            "            \"html_attributions\" : [\n" +
            "               \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/117387643646577133592/photos\\\"\\u003eАлла Цветкова\\u003c/a\\u003e\"\n" +
            "            ],\n" +
            "            \"photo_reference\" : \"CmRaAAAA-3OHqaBZh012NzoNX8PFP9X8LzlMlzyJcy-NRKLBgmNPFQ3IgRZCl_OqjjeBMOY18onjBamrbFBuki60Xh5SUgVbHrgO2EM07b8ZTwkfbi0bBJqx1948Jk1zvXkfeMZIEhC6o1BH7YrFKAqFLdnhJZe4GhTk9i3gJXwLJ5GkiOB6fSbBJLc5CQ\",\n" +
            "            \"width\" : 3264\n" +
            "         },\n" +
            "         {\n" +
            "            \"height\" : 1536,\n" +
            "            \"html_attributions\" : [\n" +
            "               \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/109441349542816639937/photos\\\"\\u003eMack The Knife\\u003c/a\\u003e\"\n" +
            "            ],\n" +
            "            \"photo_reference\" : \"CmRaAAAAhjucObPnHqVmO-56OJg_L4wJsW5ntW1f1g9YARS8Zu4XCZXqrOnSiUcaT10utQN4NXcGL-HPhs49LTzsU8DKR_9L7jYJZewqtKACbc-rIiovvuGagpQVrpIRXlf9JE0REhD2ePwVhlhTK0qz6gEt3sQoGhQbuiUH_BvKq4pP9ai00iFUXgUjaw\",\n" +
            "            \"width\" : 2048\n" +
            "         },\n" +
            "         {\n" +
            "            \"height\" : 1333,\n" +
            "            \"html_attributions\" : [\n" +
            "               \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/107956383758290156645/photos\\\"\\u003eФлотилия &quot;Рэдиссон Ройал, Москва&quot;\\u003c/a\\u003e\"\n" +
            "            ],\n" +
            "            \"photo_reference\" : \"CmRaAAAAhW3LNjIxGIam2_O5x2YG-moDiaFXl9yPpoYNQCdhsOXnSo1LPWI1ByErtTtOgtRp_B7OOj924CMdeFamXV2Yca4J1bnZBTdIUzKIk_wKbz-NlMccCaiy4Nmkek3LuYEJEhAUSBPFvNsGU_XNx_sFyZE3GhT6bdoU3zB_pctuSENctiHKZ0eJag\",\n" +
            "            \"width\" : 2000\n" +
            "         },\n" +
            "         {\n" +
            "            \"height\" : 1440,\n" +
            "            \"html_attributions\" : [\n" +
            "               \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/104293230979374021827/photos\\\"\\u003eКристина Овечкина\\u003c/a\\u003e\"\n" +
            "            ],\n" +
            "            \"photo_reference\" : \"CmRaAAAAxswf8Tvm_geWIpVRDvo-cJUaUqi10lx8n6BMNG4f-Wf_dp5AyY6S-k9KnTDnB6d9EnpElkgJf9bIG_lpQG3P4hypHQo-6TTDbBgJ-pHCk8Pd6EyD1HEADk61VE0HAs4nEhAbgAvpPQ5ww46Ys3ekLJ2kGhRroZM2TRxWi-ugpC6I-fapzx-Nbg\",\n" +
            "            \"width\" : 2560\n" +
            "         },\n" +
            "         {\n" +
            "            \"height\" : 1365,\n" +
            "            \"html_attributions\" : [\n" +
            "               \"\\u003ca href=\\\"https://maps.google.com/maps/contrib/116744817591115149507/photos\\\"\\u003eRizvan Gereykhanov\\u003c/a\\u003e\"\n" +
            "            ],\n" +
            "            \"photo_reference\" : \"CmRaAAAAHb7wMNquOuPYD-FF5ARj-q7zGWrDEY2SFyvKgavl5YKCxP3INgQ6_KG-Rn9oErehJNmKWYnUwGjdiZtBcIEWZm1TDhxDNieWmwau_LD_1h0kNc8GQIRa6TEBaAfefGqIEhCW8qeEjvUdaOP4qTs8FrWlGhSs_88V6J-3OCQpelRiRU4DIdliUg\",\n" +
            "            \"width\" : 2048\n" +
            "         }\n" +
            "      ],\n" +
            "      \"place_id\" : \"ChIJybDUc_xKtUYRTM9XV8zWRD0\",\n" +
            "      \"reference\" : \"CmRbAAAA5yV0ru4Ca8Vx_yuMAIfBh09Ybrz30ZRzVGiCAa4s90YnwqaeqQGy6m5_T5hW5hVrMf2z11wgGlxI8XbGMTSE8Vb0oJNZX8l3hEZXTiT5pEj_TPSy-5O3441DMHFdHXHIEhCxErGBsleBueyanAkCNQpPGhQnGZLwcghE9y8717uH29lG-IQNoA\",\n" +
            "      \"scope\" : \"GOOGLE\",\n" +
            "      \"types\" : [ \"locality\", \"political\" ],\n" +
            "      \"url\" : \"https://maps.google.com/?q=Moscow,+Russia&ftid=0x46b54afc73d4b0c9:0x3d44d6cc5757cf4c\",\n" +
            "      \"utc_offset\" : 180,\n" +
            "      \"vicinity\" : \"Moscow\"\n" +
            "   },\n" +
            "   \"status\" : \"OK\"\n" +
            "}";
}
