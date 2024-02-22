package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BootcampStateService;
import com.tobeto.bootcampProject.business.requests.create.bootcampState.CreateBootcampStateRequest;
import com.tobeto.bootcampProject.business.requests.update.bootcampState.UpdateBootcampStateRequest;
import com.tobeto.bootcampProject.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.tobeto.bootcampProject.business.responses.delete.bootcampState.DeleteBootcampStateResponse;
import com.tobeto.bootcampProject.business.responses.get.bootcampState.GetAllBootcampStatesResponse;
import com.tobeto.bootcampProject.business.responses.get.bootcampState.GetBootcampStateById;
import com.tobeto.bootcampProject.business.responses.update.bootcampState.UpdateBootcampStateResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.BootcampStateRepository;
import com.tobeto.bootcampProject.entities.BootcampState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampStateManager implements BootcampStateService {

    private BootcampStateRepository bootcampStateRepository;
    private ModelMapperService mapperService;
    @Override
    public DataResult<CreateBootcampStateResponse> createBootcampState(CreateBootcampStateRequest request) {
        BootcampState bootcampState = mapperService.forRequest().map(request, BootcampState.class);
        System.out.println(bootcampState);
        bootcampState.setCreatedDate(LocalDateTime.now());
        bootcampStateRepository.save(bootcampState);

        CreateBootcampStateResponse response = mapperService.forResponse().map(bootcampState, CreateBootcampStateResponse.class);

        return new SuccessDataResult<CreateBootcampStateResponse>(response, "Bootcamp State Created");
    }

    @Override
    public DataResult<List<GetAllBootcampStatesResponse>> getAllBootcampStates() {
        List <BootcampState> bootcampStates = bootcampStateRepository.findAll();
        List <GetAllBootcampStatesResponse> response = bootcampStates.stream().map(bootcampState -> mapperService.
                forResponse().map(bootcampState, GetAllBootcampStatesResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampStatesResponse>>(response, "All Bootcamp States Listed");

    }

    @Override
    public DataResult<GetBootcampStateById> getBootcampState(int id) {
        BootcampState bootcampState = bootcampStateRepository.findById(id).orElseThrow();

        GetBootcampStateById response = mapperService.forResponse().map(bootcampState, GetBootcampStateById.class);
        return new SuccessDataResult<GetBootcampStateById>(response, "Bootcamp State Listed");

    }

    @Override
    public DataResult<UpdateBootcampStateResponse> updateBootcampState(UpdateBootcampStateRequest request) {
        BootcampState bootcampState = mapperService.forRequest().map(request, BootcampState.class);
        BootcampState updatedBootcampState = bootcampStateRepository.save(bootcampState);

        UpdateBootcampStateResponse response = mapperService.forResponse().map(updatedBootcampState, UpdateBootcampStateResponse.class);

        return new SuccessDataResult<UpdateBootcampStateResponse>(response, "Bootcamp State Updated");

    }

    @Override
    public DataResult<DeleteBootcampStateResponse> deleteBootcampState(int id) {
        bootcampStateRepository.deleteById(id);
        return new SuccessDataResult<DeleteBootcampStateResponse>("Bootcamp State Deleted");
    }
}
