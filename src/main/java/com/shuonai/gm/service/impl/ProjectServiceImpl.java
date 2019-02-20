package com.shuonai.gm.service.impl;

import com.shuonai.gm.domain.Project;
import com.shuonai.gm.mapper.ProjectMapper;
import com.shuonai.gm.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements IProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public int insertProject(Project project) {
        return projectMapper.insertProject(project);
    }

    @Override
    public int updateProject(Project project) {
        return projectMapper.updateProject(project);
    }

    @Override
    public int deleteProject(int id) {
        return projectMapper.deleteProject(id);
    }

    @Override
    public Project getProject(int id) {
        return projectMapper.getProject(id);
    }
}