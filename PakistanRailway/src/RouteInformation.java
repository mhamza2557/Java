public class RouteInformation {

    //Railway Route Information For ( Pak Business Express & Allama Iqbal Express )
    public void routeGet(String fromStation, String toStation, String trainName) {
        if (!fromStation.equals(toStation)) {
            if (fromStation.equals("Karachi") && toStation.equals("Lahore") && trainName.equals("BusinessExpress")) {
                //Pak Business Express (Karachi → Lahore)
                pakBusinessExpressUp();
            } else if (fromStation.equals("Lahore") && toStation.equals("Karachi") && trainName.equals("BusinessExpress")) {
                //Pak Business Express (Lahore → Karachi)
                pakBusinessExpressDown();
            } else if (fromStation.equals("Karachi") && toStation.equals("Sialkot") && trainName.equals("AllamaIqbalExpress")) {
                allamaIqbalExpressUp();
            } else if (fromStation.equals("Sialkot") && toStation.equals("Karachi") && trainName.equals("AllamaIqbalExpress")) {
                allamaIqbalExpressDown();
            }
        }
    }

    //Pak Business Express (Karachi → Lahore)
    //Private Method Don't called in the Main Class
    private void pakBusinessExpressUp() {
        String[] stationList = {"1. Karachi Cantt"
                , "2. Hyderabad Jn"
                , "3. Nawabshah Jn"
                , "4. Rohri Jn"
                , "5. Rahim Yar Khan"
                , "6. Bahawalpur"
                , "7. Khanewal Jn"
                , "8. Sahiwal"
                , "9. Raiwind Jn"
                , "10. Lahore Jn"
        };

        for (String stnList : stationList) {
            System.out.println(stnList);
        }
    }

    //Pak Business Express (Lahore → Karachi)
    //Private Method Don't called in the Main Class
    private void pakBusinessExpressDown() {
        String[] stationList = {"1. Lahore Jn"
                , "2. Raiwind Jn"
                , "3. Sahiwal"
                , "4. Khanewal Jn"
                , "5. Bahawalpur"
                , "6. Rahim Yar Khan"
                , "7. Rohri Jn"
                , "8. Nawabshah Jn"
                , "9. Hyderabad Jn"
                , "10. Karachi Cantt"
        };

        for (String stnList : stationList) {
            System.out.println(stnList);
        }
    }

    //Pak Business Express (Karachi → Sialkot)
    //Private Method Don't called in the Main Class
    private void allamaIqbalExpressUp () {
        String[] stationList = {"1. Karachi Cant"
                , "2. Drig Road"
                , "3. Landhi JN"
                , "4. Kotri Jn"
                , "5. Hyderabad Jn"
                , "6. Tando Adam Jn"
                , "7. Nawabshah Jn"
                , "8. Mahrabpur Jn"
                , "9. Rohri Jn"
                , "10. Ghotki"
                , "11. Sadikabad"
                , "12. Rahim Yar Khan"
                , "13. Khanpur Jn"
                , "14. Bahawalpur"
                , "15. Dunyapur"
                , "16. Jahania"
                , "17. Khanewal Jn"
                , "18. Chichawatni"
                , "19. Sahiwal"
                , "20. Okara"
                , "21. Pattoki"
                , "22. Kot Radha Kishn"
                , "23. Raiwind Jn"
                , "24. Kot Lakhpat"
                , "25. Lahore Jn"
                , "26. Shahdara Bagh Jn"
                , "27. Narang"
                , "28. Baddomalhi"
                , "29. Narowal Jn"
                , "30. Kila Sobha Singh"
                , "31. Chawinda"
                , "32. Sialkot Jn"
        };

        for (String stnList : stationList) {
            System.out.println(stnList);
        }
    }

    //Pak Business Express (Sialkot → Karachi)
    //Private Method Don't called in the Main Class
    private void allamaIqbalExpressDown () {
        String[] stationList = {"1. Sialkot Jn."
                , "2. Chawinda"
                , "3. Pasrur"
                , "4. Kila Sobha Singh"
                , "5. Narowal Jn."
                , "6. Baddomalhi"
                , "7. Narang"
                , "8. Shahdara Bagh Jn."
                , "9. Lahore Jn."
                , "10. Kot Lakhpat"
                , "11. Raiwind Jn."
                , "12. Kot Radha Kishen"
                , "13. Pattoki"
                , "14. Okara"
                , "15. Sahiwal"
                , "16. Chichawatni"
                , "17. Khanewal Jn"
                , "18. Jahania"
                , "19. Dunyapur"
                , "20. Bahawalpur"
                , "21. Khanpur Jn."
                , "22. Rahim Yar Khan"
                , "23. Sadikabad"
                , "24. Ghotki"
                , "25. Rohri Jn."
                , "26. Mahrabpur"
                , "27. Nawabshah Jn."
                , "28. Tando Adam"
                , "29. Hyderabad Jn"
                , "30. Landhi Jn."
                , "31. Drigh Road"
                , "32.Karachi Cantt"
        };

        for (String stnList : stationList) {
            System.out.println(stnList);
        }
    }
}
