package com.tobeto.bootcampProject.business.responses.delete.applicationState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteApplicationStateResponse {
    private int id;
    private String name;
}
