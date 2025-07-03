package igathlete.ilt.mapper;

import igathlete.ilt.model.Issue;
import igathlete.ilt.model.Filter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IssueMapper {
    List<Issue> findAll();
    Issue findById(Long id);
    void insert(Issue issue);
    void update(Issue issue, Long id);
    void delete(Long id);
    List<Issue> search(@Param("filter") Filter filter);
}