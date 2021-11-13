package com.poo.backend.search;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByFuzzy implements Search {
    @Override
    public List<Integer> doSearch(List<String> keywords, List<String> data) {
        List<ExtractedResult> fuzzyResults = new ArrayList<>();

        keywords.forEach(keyword -> {
            List<ExtractedResult> matches = FuzzySearch.extractAll(keyword, data);
            matches = matches.stream().filter(match -> match.getScore() >= this.getTolerance()).collect(Collectors.toList());
            fuzzyResults.addAll(matches);
        });

        return fuzzyResults.stream().map(ExtractedResult::getIndex).collect(Collectors.toList());
    }

    private Integer getTolerance() {
        return 80;
    }
}
