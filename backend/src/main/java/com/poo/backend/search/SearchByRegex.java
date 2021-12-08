package com.poo.backend.search;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchByRegex implements Search {
    @Override
    public List<Integer> doSearch(List<String> keywords, List<String> data) {
        List<Integer> results = new ArrayList<>();
        keywords.forEach(regex -> {
            Pattern pattern = Pattern.compile(formatRegex(regex), Pattern.CASE_INSENSITIVE);
            IntStream indexes = IntStream.range(0, data.size());
            List<Integer> matches = indexes.mapToObj((index) -> {
                String discipline = data.get(index);
                Matcher result = pattern.matcher(discipline);
                return result.find() ? index : -1;
            }).filter(index -> index != -1).collect(Collectors.toList());

            results.addAll(matches);
        });

        return results;
    }

    public static boolean isARegexKeyword(String keyword) {
        return !keyword.isEmpty() && keyword.charAt(0) == '/' && keyword.charAt(keyword.length() - 1) == '/';
    }

    private String formatRegex(String regex) {
        return regex.replaceAll("/", "");
    }
}
