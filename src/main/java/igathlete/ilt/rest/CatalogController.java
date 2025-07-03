package igathlete.ilt.rest;

import igathlete.ilt.model.Catalog;
import igathlete.ilt.model.Filter;
import igathlete.ilt.service.CatalogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
@Tag(name = "Catalogs", description = "Operations related to Catalogs")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public List<Catalog> getAll() {
        return catalogService.findAll();
   }

    @GetMapping("/{id}")
    public Catalog getById(@PathVariable Long id) {
        return catalogService.findById(id);
    }

    @PostMapping
    public Catalog create(@RequestBody Catalog catalog) {
        catalogService.insert(catalog);
        return catalog;
    }

    @PutMapping("/{id}")
    public Catalog update(@PathVariable Long id, @RequestBody Catalog catalog) {
        catalogService.update(catalog, id);
        return catalog;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        catalogService.delete(id);
    }

    @Operation(summary = "Search catalogs by filter")
    @PostMapping("/search")
    public List<Catalog> search(@RequestBody Filter filter) {
        return catalogService.search(filter);
    }
}