package com.cps.views.admission;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.requests.SendAdmission;
import com.cps.models.requests.SendAdmissionMedia;


public class AdmissionViewModel extends ViewModel {

    AdmissionRepository repository;

    public AdmissionViewModel() {
        repository = new AdmissionRepository();
    }

    public LiveData<Integer> send_admission(SendAdmission admission ){
        return repository.requestadmissiondata(admission);
    }

    public LiveData<Integer> send_admission_media(SendAdmissionMedia admission ){
        return repository.requestadmissionmedia(admission);
    }
}
