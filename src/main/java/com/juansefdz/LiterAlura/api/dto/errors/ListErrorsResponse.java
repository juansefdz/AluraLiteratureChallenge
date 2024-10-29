package com.juansefdz.LiterAlura.api.dto.errors;

import java.util.List;
import java.util.Map;

public class ListErrorsResponse extends BaseErrorResponse{
    private List<Map<String, String>> errors;
}
