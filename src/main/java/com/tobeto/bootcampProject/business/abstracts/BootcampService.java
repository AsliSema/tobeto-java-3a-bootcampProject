package com.tobeto.bootcampProject.business.abstracts;

import com.tobeto.bootcampProject.business.requests.create.bootcamp.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.update.bootcamp.UpdateBootcampRequest;
import com.tobeto.bootcampProject.business.responses.create.bootcamp.CreateBootcampResponse;
import com.tobeto.bootcampProject.business.responses.get.bootcamp.GetAllBootcampsResponse;
import com.tobeto.bootcampProject.business.responses.get.bootcamp.GetBootcampByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.bootcamp.UpdateBootcampResponse;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;

public interface BootcampService {
    DataResult<CreateBootcampResponse> createBootcamp(CreateBootcampRequest request);
    DataResult<GetAllBootcampsResponse> getAllBootcamps();

    DataResult<GetBootcampByIdResponse> getbootcamp(int id);
    DataResult<UpdateBootcampResponse> updateBootcamp(UpdateBootcampRequest request);

    Result deleteBootcamp(int id);
}
