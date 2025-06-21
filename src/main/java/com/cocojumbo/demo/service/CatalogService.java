package com.cocojumbo.demo.service;

import com.cocojumbo.demo.mapper.CatalogMapper;
import com.cocojumbo.demo.model.Catalog;
import com.cocojumbo.demo.model.Filter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    private final CatalogMapper catalogMapper;

    public CatalogService(CatalogMapper catalogMapper) {
        this.catalogMapper = catalogMapper;
    }

    public List<Catalog> findAll() {
        return catalogMapper.findAll();
    }

    public Catalog findById(Long id) {
        return catalogMapper.findById(id);
    }

    public void insert(Catalog catalog) {
        catalogMapper.insert(catalog);
    }

    public void update(Catalog catalog, Long id) {
        catalogMapper.update(catalog, id);
    }

    public void delete(Long id) {
        catalogMapper.delete(id);
    }

    public List<Catalog> search(Filter filter) {
        return catalogMapper.search(filter);
    }

}
