package igathlete.ilt.mapper;

import igathlete.ilt.model.Catalog;
import igathlete.ilt.model.Filter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CatalogMapper {
    List<Catalog> findAll();
    Catalog findById(Long id);
    void insert(Catalog catalog);
    void update(Catalog catalog, Long id);
    void delete(Long id);
    List<Catalog> search(@Param("filter") Filter filter);
}