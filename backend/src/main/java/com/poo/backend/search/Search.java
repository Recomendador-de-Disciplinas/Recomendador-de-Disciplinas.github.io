package com.poo.backend.search;

import java.util.List;

public interface Search {
    List<Integer> doSearch(List<String> keywords, List<String> data);
}
