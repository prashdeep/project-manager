package com.github.mkopylec.projectmanager.domain.team;

import org.springframework.data.annotation.Id;

import static com.github.mkopylec.projectmanager.domain.exceptions.ErrorCode.EMPTY_TEAM_NAME;
import static com.github.mkopylec.projectmanager.domain.exceptions.PreCondition.when;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class Team {

    @Id
    private String name;
    private int currentlyImplementedProjects;

    Team(String name, int currentlyImplementedProjects) {
        when(isBlank(name))
                .thenInvalidEntity(EMPTY_TEAM_NAME, "Error creating team");
        this.name = name;
        this.currentlyImplementedProjects = currentlyImplementedProjects;
    }

    public String getName() {
        return name;
    }
}