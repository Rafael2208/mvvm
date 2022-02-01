package com.example.mvvm2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    // escutar falso ou verdadeiro
    private MutableLiveData<Boolean> mLogin = new MutableLiveData<>();
    public LiveData<Boolean> login = mLogin;


    public void doLogin (String email){
        //this.mLogin.setValue(!email.equals(""));


        if(email.equals("")){
            this.mLogin.setValue(false);
        }else{
            this.mLogin.setValue(true);
        }


    }
}
