package com.shuonai.gm.service;

import com.shuonai.gm.domain.Project;
import org.springframework.stereotype.Service;

@Service
public interface IProjectService {
    public int insertProject(Project project);

    public int updateProject(Project project);

    public int deleteProject(int id);

    public Project getProject(int id);
}