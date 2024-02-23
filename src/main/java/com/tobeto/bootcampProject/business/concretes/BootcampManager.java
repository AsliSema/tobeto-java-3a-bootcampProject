package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BootcampService;
import com.tobeto.bootcampProject.business.requests.create.bootcamp.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.update.bootcamp.UpdateBootcampRequest;
import com.tobeto.bootcampProject.business.responses.create.bootcamp.CreateBootcampResponse;
import com.tobeto.bootcampProject.business.responses.delete.bootcamp.DeleteBootcampResponse;
import com.tobeto.bootcampProject.business.responses.get.bootcamp.GetAllBootcampsResponse;
import com.tobeto.bootcampProject.business.responses.get.bootcamp.GetBootcampByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.bootcamp.UpdateBootcampResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.BootcampRepository;
import com.tobeto.bootcampProject.entities.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {

    private BootcampRepository bootcampRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateBootcampResponse> createBootcamp(CreateBootcampRequest request) {
        Bootcamp bootcamp = mapperService.forRequest().map(request, Bootcamp.class);
        bootcamp.setCreatedDate(LocalDateTime.now());
        bootcampRepository.save(bootcamp);

        CreateBootcampResponse response = mapperService.forResponse().map(bootcamp, CreateBootcampResponse.class);
        return new SuccessDataResult<CreateBootcampResponse>(response, "Bootcamp Created");
    }

    @Override
    public DataResult<GetAllBootcampsResponse> getAllBootcamps() {

        List <Bootcamp> bootcamps = bootcampRepository.findAll();

        List<GetAllBootcampsResponse> response = bootcamps.stream().map(bootcamp -> mapperService.
                forResponse().map(bootcamp, GetAllBootcampsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampsResponse>>(response, "All Bootcamps Listed");
    }

    @Override
    public DataResult<GetBootcampByIdResponse> getbootcamp(int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id).orElseThrow();
        GetBootcampByIdResponse response = mapperService.forResponse().map(bootcamp, GetBootcampByIdResponse.class);
        return new SuccessDataResult<GetBootcampByIdResponse>(response, "Bootcamp Listed");
    }

    @Override
    public DataResult<UpdateBootcampResponse> updateBootcamp(UpdateBootcampRequest request) {
        Bootcamp bootcamp = mapperService.forRequest().map(request, Bootcamp.class);
        Bootcamp updatedBootcamp = bootcampRepository.save(bootcamp);

        UpdateBootcampResponse response = mapperService.forResponse().map(updatedBootcamp, UpdateBootcampResponse.class);

        return new SuccessDataResult<UpdateBootcampResponse>(response, "Bootcamp Updated");

    }

    @Override
    public Result deleteBootcamp(int id) {
        bootcampRepository.deleteById(id);
        return new SuccessResult("Bootcamp Deleted");
    }
}

