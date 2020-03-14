package com.cps.views.contact;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.cps.R;
import com.cps.models.requests.SendContact;

import static com.cps.helpers.Constant.STATUS_CODE_SUCCESS;

public class ContactUsViewModel extends ViewModel {

    ContactUsRepository repository;

    public ContactUsViewModel() {
        repository = new ContactUsRepository();
    }

    /*public void sendContact(View v , SendContact contact){
        Context context = v.getContext();
        if(validation(contact)) {
            send_contact(contact,context);
        }else{
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }*/

    public LiveData<Integer> send_contact(SendContact contact ){
        /*LiveData<Integer> t = repository.requestdata(contact);
        t.observe((ContactUs) context, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                int x = integer;
                if ( x == STATUS_CODE_SUCCESS){
                    Toast.makeText(context, R.string.success, Toast.LENGTH_SHORT).show();
                    ((ContactUs) context).finish();
                }else {
                    Toast.makeText(context, R.string.error, Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        return repository.requestdata(contact);
    }
}
