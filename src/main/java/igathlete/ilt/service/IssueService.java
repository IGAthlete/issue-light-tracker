package igathlete.ilt.service;

import igathlete.ilt.mapper.IssueMapper;
import igathlete.ilt.model.Issue;
import igathlete.ilt.model.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class IssueService {
    private final IssueMapper issueMapper;

    public IssueService(IssueMapper issueMapper) {
        this.issueMapper = issueMapper;
    }

    public List<Issue> findAll() {
        return issueMapper.findAll();
    }

    public Issue findById(Long id) {
        return issueMapper.findById(id);
    }

    public void insert(Issue issue) {
        issueMapper.insert(issue);
    }

    public void update(Issue issue, Long id) {
        issueMapper.update(issue, id);
    }

    public void delete(Long id) {
        issueMapper.delete(id);
    }

    public List<Issue> search(Filter filter) {
        log.info("Search by filter {}", filter);
        return issueMapper.search(filter);
    }
}
