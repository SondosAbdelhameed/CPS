package com.cps.views.admission;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cps.R;
import com.cps.databinding.FragmentAdmissionP4Binding;
import com.cps.models.requests.SendAdmission;
import com.cps.models.requests.SendAdmissionMedia;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AdmissionPage4 extends Fragment {

    FragmentAdmissionP4Binding binding;
    SendAdmission admission;
    SendAdmissionMedia admissionMedia;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admission_p4, container, false);
        admission = (SendAdmission) getArguments().getSerializable("admission");
        admissionMedia = (SendAdmissionMedia) getArguments().getSerializable("admissionMedia");
        binding.setAdmission(admission);
        Toast.makeText(getContext(), admission.getStuNationalId(), Toast.LENGTH_SHORT).show();

        binding.imgStuPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(601);
            }
        });
        binding.imgStuBirthCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(602);
            }
        });
        binding.imgFatherId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(603);
            }
        });
        binding.imgMotherId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(604);
            }
        });
        binding.imgFatherQualify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(605);
            }
        });
        binding.imgMotherQualify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery(606);
            }
        });
        return binding.getRoot();
    }

    public static AdmissionPage4 newInstance(SendAdmission admission , SendAdmissionMedia admissionMedia) {

        AdmissionPage4 f = new AdmissionPage4();
        Bundle b = new Bundle();
        b.putSerializable("admission", admission);
        b.putSerializable("admissionMedia", admissionMedia);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(getActivity(), "Canceled", Toast.LENGTH_SHORT).show();
        } else if (resultCode == Activity.RESULT_OK)  {
            if (data != null) {
                getImage(requestCode,data);
                Toast.makeText(getContext(), "Code  "+requestCode, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isValidate() {

        /**
         * if return false show the error message for each fragment
         * */
        return false;
    }

    void openGallery(int code){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),code);
    }

    void getImage(int code , Intent data){

        Toast.makeText(getContext(), "Code  "+code, Toast.LENGTH_SHORT).show();
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
            bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            String base = toBase64(bitmap);
            if (code == 601){
                admission.setStuPhoto("true");
                admissionMedia.setStuPhoto(base);
                binding.imgStuPhoto.setBackground(bitmapDrawable);
            }else if (code == 602){
                admission.setStuBirthPhoto("true");
                admissionMedia.setStuBirthPhoto(base);
                binding.imgStuBirthCertificate.setBackground(bitmapDrawable);
            }else if (code == 603){
                admission.setStuFaIdPhoto("true");
                admissionMedia.setStuFaIdPhoto(base);
                binding.imgFatherId.setBackground(bitmapDrawable);
            }else if (code == 604){
                admission.setStuMoIdPhoto("true");
                admissionMedia.setStuMoIdPhoto(base);
                binding.imgMotherId.setBackground(bitmapDrawable);
            }else if (code == 605){
                admission.setStuFaQualPhoto("true");
                admissionMedia.setStuFaQualPhoto(base);
                binding.imgFatherQualify.setBackground(bitmapDrawable);
            }else if (code == 606){
                admission.setStuMoQualPhoto("true");
                admissionMedia.setStuMoQualPhoto(base);
                binding.imgMotherQualify.setBackground(bitmapDrawable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String toBase64(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();

        String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encodedImage;
    }
}
