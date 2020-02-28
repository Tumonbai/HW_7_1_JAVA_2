package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("бой",
                new String[]{"битва",
                        "сражение", "вайна", "сеча"});
        dictionary.put("красный",
                new String[]{"пурпурный", "рубиновый",
                        "багровый"});
        dictionary.put("бурья",
                new String[]{"ураган", "шторм",
                        "тайфун", "циклон"});

        HashMap<String, String[]> bigDictionary = new HashMap<>();
        Set<String> keys = dictionary.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            String[] values = dictionary.get(key);
            bigDictionary.put(key, values);
            for (int i = 0; i < values.length; i++) {
                String newKey = values[i];
                ArrayList<String> newValues = new ArrayList<>(values.length);
                newValues.addAll(Arrays.asList(values));
                newValues.remove(newKey);
                newValues.add(key);
                String[] values2 = new String[newValues.size()];
                values2 = newValues.toArray(values2);
                bigDictionary.put(newKey, values2);

            }
        }

        System.out.println("Enter your word:  ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String[] synonyms = bigDictionary.get(word);
        for (String e : synonyms) {
            System.out.println(e);
        }

    }
}