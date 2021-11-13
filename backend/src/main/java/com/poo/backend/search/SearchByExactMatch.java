package com.poo.backend.search;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchByExactMatch implements Search {
    @Override
    public List<Integer> doSearch(List<String> keywords, List<String> data) {
        List<Integer> results = new ArrayList<>();
        keywords.forEach(keyword -> {
            String lowerCaseKeyword = unaccent(keyword).toLowerCase();

            IntStream indexes = IntStream.range(0, data.size());
            List<Integer> matches = indexes.mapToObj((index) -> {
                String discipline = data.get(index);
                return unaccent(discipline).toLowerCase().contains(lowerCaseKeyword) ? index : -1;
            }).filter(index -> index != -1).collect(Collectors.toList());

            results.addAll(matches);
        });

        return results;
    }

    private String unaccent(String src) {
        return Normalizer.normalize(src, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
