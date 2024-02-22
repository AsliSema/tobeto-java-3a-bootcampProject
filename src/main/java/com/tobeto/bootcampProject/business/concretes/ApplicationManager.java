package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.ApplicationService;
import com.tobeto.bootcampProject.business.requests.create.application.CreateApplicationRequest;
import com.tobeto.bootcampProject.business.requests.update.application.UpdateApplicationRequest;
import com.tobeto.bootcampProject.business.responses.create.applications.CreateApplicationResponse;
import com.tobeto.bootcampProject.business.responses.delete.application.DeleteApplicationResponse;
import com.tobeto.bootcampProject.business.responses.get.application.GetAllApplicationsResponse;
import com.tobeto.bootcampProject.business.responses.get.application.GetApplicationByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.application.UpdateApplicationResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.ApplicationRepository;
import com.tobeto.bootcampProject.entities.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {

    private ApplicationRepository applicationRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<CreateApplicationResponse> createApplication(CreateApplicationRequest request) {
        Application application = mapperService.forRequest().map(request, Application.class);
        System.out.println(application);
        application.setCreatedDate(LocalDateTime.now());
        applicationRepository.save(application);

        CreateApplicationResponse response = mapperService.forResponse().map(application, CreateApplicationResponse.class);

        return new SuccessDataResult<CreateApplicationResponse>(response, "Application Created");
    }

    @Override
    public DataResult<List<GetAllApplicationsResponse>> getAllApplications() {
        List <Application> applications = applicationRepository.findAll();
        List <GetAllApplicationsResponse> response = applications.stream().map(application -> mapperService.
                forResponse().map(application, GetAllApplicationsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicationsResponse>>(response, "All Applications Listed");
    }

    @Override
    public DataResult<GetApplicationByIdResponse> getApplication(int id) {

        Application application = applicationRepository.findById(id).orElseThrow();
        GetApplicationByIdResponse response = mapperService.forResponse().map(application, GetApplicationByIdResponse.class);
        return new SuccessDataResult<GetApplicationByIdResponse>(response, "Application Listed");
    }

    @Override
    public DataResult<UpdateApplicationResponse> updateApplication(UpdateApplicationRequest request) {
        Application application = mapperService.forRequest().map(request, Application.class);
        Application updatedApplication = applicationRepository.save(application);

        UpdateApplicationResponse response = mapperService.forResponse().map(updatedApplication, UpdateApplicationResponse.class);

        return new SuccessDataResult<UpdateApplicationResponse>(response, "Application Updated");
    }


    @Override
    public DataResult<DeleteApplicationResponse> deleteApplication(int id) {
        applicationRepository.deleteById(id);
        return new SuccessDataResult<DeleteApplicationResponse>("Application Deleted");
    }
}


