package igathlete.ilt.rest;

import igathlete.ilt.model.Issue;
import igathlete.ilt.model.Filter;
import igathlete.ilt.service.IssueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
@Tag(name = "Issues", description = "Operations related to Issues")
public class IssueController {

    private final IssueService catalogService;

    public IssueController(IssueService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public List<Issue> getAll() {
        return catalogService.findAll();
    }

    @GetMapping("/{id}")
    public Issue getById(@PathVariable Long id) {
        return catalogService.findById(id);
    }

    @PostMapping
    public Issue create(@RequestBody Issue issue) {
        catalogService.insert(issue);
        return issue;
    }

    @PutMapping("/{id}")
    public Issue update(@PathVariable Long id, @RequestBody Issue issue) {
        catalogService.update(issue, id);
        return issue;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        catalogService.delete(id);
    }

    @Operation(summary = "Search issues by filter")
    @PostMapping("/search")
    public List<Issue> search(@RequestBody Filter filter) {
        return catalogService.search(filter);
    }
}
