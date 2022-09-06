package com.senasoft.participacionciudadana.service.sondeoadmin;

import com.senasoft.participacionciudadana.service.sondeoadmin.request.SondeoAdminRequest;
import com.senasoft.participacionciudadana.service.sondeoadmin.response.SondeoAdminResponse;

import java.util.List;

public interface SondeoAdminService {
    void create(SondeoAdminRequest sondeoAdminRequest);
    List<SondeoAdminResponse> getAll();
    SondeoAdminResponse getById(Long id);
}
