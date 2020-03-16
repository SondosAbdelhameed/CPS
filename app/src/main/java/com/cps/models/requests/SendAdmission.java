package com.cps.models.requests;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SendAdmission implements Serializable {

	@SerializedName("stu_fa_qual_photo")
	private String stuFaQualPhoto;

	@SerializedName("stu_parents_status")
	private String stuParentsStatus;

	@SerializedName("stu_faname")
	private String stuFaname;

	@SerializedName("stu_level")
	private String stuLevel;

	@SerializedName("stu_mother_email")
	private String stuMotherEmail;

	@SerializedName("stu_fa_gua_phone1")
	private String stuFaGuaPhone1;

	@SerializedName("stu_bus")
	private String stuBus;

	@SerializedName("stu_fa_gua_phone2")
	private String stuFaGuaPhone2;

	@SerializedName("stu_fname")
	private String stuFname;

	@SerializedName("stu_guardian")
	private String stuGuardian;

	@SerializedName("stu_mother_occup")
	private String stuMotherOccup;

	@SerializedName("stu_medical_info")
	private String stuMedicalInfo;

	@SerializedName("stu_photo")
	private String stuPhoto;

	@SerializedName("stu_nationality")
	private String stuNationality;

	@SerializedName("stu_address")
	private String stuAddress;

	@SerializedName("stu_emerg_name")
	private String stuEmergName;

	@SerializedName("stu_national_id")
	private String stuNationalId;

	@SerializedName("bro_sis_name")
	private String broSisName;

	@SerializedName("stu_fa_gua_email")
	private String stuFaGuaEmail;

	@SerializedName("stu_religion")
	private String stuReligion;

	@SerializedName("stu_birth_date")
	private String stuBirthDate;

	@SerializedName("stu_emerg_relation")
	private String stuEmergRelation;

	@SerializedName("stu_mother_name")
	private String stuMotherName;

	@SerializedName("bro_sis_grade")
	private String broSisGrade;

	@SerializedName("stu_emerg_phone")
	private String stuEmergPhone;

	@SerializedName("stu_birth_photo")
	private String stuBirthPhoto;

	@SerializedName("stu_lname")
	private String stuLname;

	@SerializedName("stu_fa_gua_name")
	private String stuFaGuaName;

	@SerializedName("stu_fa_gua_occup")
	private String stuFaGuaOccup;

	@SerializedName("stu_transferred_sch")
	private String stuTransferredSch;

	@SerializedName("stu_mother_phone1")
	private String stuMotherPhone1;

	@SerializedName("stu_gender")
	private String stuGender;

	@SerializedName("stu_mother_phone2")
	private String stuMotherPhone2;

	@SerializedName("stu_mo_qual_photo")
	private String stuMoQualPhoto;

	@SerializedName("stu_sec_lang")
	private String stuSecLang;

	@SerializedName("stu_mo_id_photo")
	private String stuMoIdPhoto;

	@SerializedName("stu_fa_id_photo")
	private String stuFaIdPhoto;

	public void setStuFaQualPhoto(String stuFaQualPhoto){
		this.stuFaQualPhoto = stuFaQualPhoto;
	}

	public String getStuFaQualPhoto(){
		return stuFaQualPhoto;
	}

	public void setStuParentsStatus(String stuParentsStatus){
		this.stuParentsStatus = stuParentsStatus;
	}

	public String getStuParentsStatus(){
		return stuParentsStatus;
	}

	public void setStuFaname(String stuFaname){
		this.stuFaname = stuFaname;
	}

	public String getStuFaname(){
		return stuFaname;
	}

	public void setStuLevel(String stuLevel){
		this.stuLevel = stuLevel;
	}

	public String getStuLevel(){
		return stuLevel;
	}

	public void setStuMotherEmail(String stuMotherEmail){
		this.stuMotherEmail = stuMotherEmail;
	}

	public String getStuMotherEmail(){
		return stuMotherEmail;
	}

	public void setStuFaGuaPhone1(String stuFaGuaPhone1){
		this.stuFaGuaPhone1 = stuFaGuaPhone1;
	}

	public String getStuFaGuaPhone1(){
		return stuFaGuaPhone1;
	}

	public void setStuBus(String stuBus){
		this.stuBus = stuBus;
	}

	public String getStuBus(){
		return stuBus;
	}

	public void setStuFaGuaPhone2(String stuFaGuaPhone2){
		this.stuFaGuaPhone2 = stuFaGuaPhone2;
	}

	public String getStuFaGuaPhone2(){
		return stuFaGuaPhone2;
	}

	public void setStuFname(String stuFname){
		this.stuFname = stuFname;
	}

	public String getStuFname(){
		return stuFname;
	}

	public void setStuGuardian(String stuGuardian){
		this.stuGuardian = stuGuardian;
	}

	public String getStuGuardian(){
		return stuGuardian;
	}

	public void setStuMotherOccup(String stuMotherOccup){
		this.stuMotherOccup = stuMotherOccup;
	}

	public String getStuMotherOccup(){
		return stuMotherOccup;
	}

	public void setStuMedicalInfo(String stuMedicalInfo){
		this.stuMedicalInfo = stuMedicalInfo;
	}

	public String getStuMedicalInfo(){
		return stuMedicalInfo;
	}

	public void setStuPhoto(String stuPhoto){
		this.stuPhoto = stuPhoto;
	}

	public String getStuPhoto(){
		return stuPhoto;
	}

	public void setStuNationality(String stuNationality){
		this.stuNationality = stuNationality;
	}

	public String getStuNationality(){
		return stuNationality;
	}

	public void setStuAddress(String stuAddress){
		this.stuAddress = stuAddress;
	}

	public String getStuAddress(){
		return stuAddress;
	}

	public void setStuEmergName(String stuEmergName){
		this.stuEmergName = stuEmergName;
	}

	public String getStuEmergName(){
		return stuEmergName;
	}

	public void setStuNationalId(String stuNationalId){
		this.stuNationalId = stuNationalId;
	}

	public String getStuNationalId(){
		return stuNationalId;
	}

	public void setBroSisName(String broSisName){
		this.broSisName = broSisName;
	}

	public String getBroSisName(){
		return broSisName;
	}

	public void setStuFaGuaEmail(String stuFaGuaEmail){
		this.stuFaGuaEmail = stuFaGuaEmail;
	}

	public String getStuFaGuaEmail(){
		return stuFaGuaEmail;
	}

	public void setStuReligion(String stuReligion){
		this.stuReligion = stuReligion;
	}

	public String getStuReligion(){
		return stuReligion;
	}

	public void setStuBirthDate(String stuBirthDate){
		this.stuBirthDate = stuBirthDate;
	}

	public String getStuBirthDate(){
		return stuBirthDate;
	}

	public void setStuEmergRelation(String stuEmergRelation){
		this.stuEmergRelation = stuEmergRelation;
	}

	public String getStuEmergRelation(){
		return stuEmergRelation;
	}

	public void setStuMotherName(String stuMotherName){
		this.stuMotherName = stuMotherName;
	}

	public String getStuMotherName(){
		return stuMotherName;
	}

	public void setBroSisGrade(String broSisGrade){
		this.broSisGrade = broSisGrade;
	}

	public String getBroSisGrade(){
		return broSisGrade;
	}

	public void setStuEmergPhone(String stuEmergPhone){
		this.stuEmergPhone = stuEmergPhone;
	}

	public String getStuEmergPhone(){
		return stuEmergPhone;
	}

	public void setStuBirthPhoto(String stuBirthPhoto){
		this.stuBirthPhoto = stuBirthPhoto;
	}

	public String getStuBirthPhoto(){
		return stuBirthPhoto;
	}

	public void setStuLname(String stuLname){
		this.stuLname = stuLname;
	}

	public String getStuLname(){
		return stuLname;
	}

	public void setStuFaGuaName(String stuFaGuaName){
		this.stuFaGuaName = stuFaGuaName;
	}

	public String getStuFaGuaName(){
		return stuFaGuaName;
	}

	public void setStuFaGuaOccup(String stuFaGuaOccup){
		this.stuFaGuaOccup = stuFaGuaOccup;
	}

	public String getStuFaGuaOccup(){
		return stuFaGuaOccup;
	}

	public void setStuTransferredSch(String stuTransferredSch){
		this.stuTransferredSch = stuTransferredSch;
	}

	public String getStuTransferredSch(){
		return stuTransferredSch;
	}

	public void setStuMotherPhone1(String stuMotherPhone1){
		this.stuMotherPhone1 = stuMotherPhone1;
	}

	public String getStuMotherPhone1(){
		return stuMotherPhone1;
	}

	public void setStuGender(String stuGender){
		this.stuGender = stuGender;
	}

	public String getStuGender(){
		return stuGender;
	}

	public void setStuMotherPhone2(String stuMotherPhone2){
		this.stuMotherPhone2 = stuMotherPhone2;
	}

	public String getStuMotherPhone2(){
		return stuMotherPhone2;
	}

	public void setStuMoQualPhoto(String stuMoQualPhoto){
		this.stuMoQualPhoto = stuMoQualPhoto;
	}

	public String getStuMoQualPhoto(){
		return stuMoQualPhoto;
	}

	public void setStuSecLang(String stuSecLang){
		this.stuSecLang = stuSecLang;
	}

	public String getStuSecLang(){
		return stuSecLang;
	}

	public void setStuMoIdPhoto(String stuMoIdPhoto){
		this.stuMoIdPhoto = stuMoIdPhoto;
	}

	public String getStuMoIdPhoto(){
		return stuMoIdPhoto;
	}

	public void setStuFaIdPhoto(String stuFaIdPhoto){
		this.stuFaIdPhoto = stuFaIdPhoto;
	}

	public String getStuFaIdPhoto(){
		return stuFaIdPhoto;
	}

	@Override
 	public String toString(){
		return 
			"SendAdmission{" + 
			"stu_fa_qual_photo = '" + stuFaQualPhoto + '\'' + 
			",stu_parents_status = '" + stuParentsStatus + '\'' + 
			",stu_faname = '" + stuFaname + '\'' + 
			",stu_level = '" + stuLevel + '\'' + 
			",stu_mother_email = '" + stuMotherEmail + '\'' + 
			",stu_fa_gua_phone1 = '" + stuFaGuaPhone1 + '\'' + 
			",stu_bus = '" + stuBus + '\'' + 
			",stu_fa_gua_phone2 = '" + stuFaGuaPhone2 + '\'' + 
			",stu_fname = '" + stuFname + '\'' + 
			",stu_guardian = '" + stuGuardian + '\'' + 
			",stu_mother_occup = '" + stuMotherOccup + '\'' + 
			",stu_medical_info = '" + stuMedicalInfo + '\'' + 
			",stu_photo = '" + stuPhoto + '\'' + 
			",stu_nationality = '" + stuNationality + '\'' + 
			",stu_address = '" + stuAddress + '\'' + 
			",stu_emerg_name = '" + stuEmergName + '\'' + 
			",stu_national_id = '" + stuNationalId + '\'' + 
			",bro_sis_name = '" + broSisName + '\'' + 
			",stu_fa_gua_email = '" + stuFaGuaEmail + '\'' + 
			",stu_religion = '" + stuReligion + '\'' + 
			",stu_birth_date = '" + stuBirthDate + '\'' + 
			",stu_emerg_relation = '" + stuEmergRelation + '\'' + 
			",stu_mother_name = '" + stuMotherName + '\'' + 
			",bro_sis_grade = '" + broSisGrade + '\'' + 
			",stu_emerg_phone = '" + stuEmergPhone + '\'' + 
			",stu_birth_photo = '" + stuBirthPhoto + '\'' + 
			",stu_lname = '" + stuLname + '\'' + 
			",stu_fa_gua_name = '" + stuFaGuaName + '\'' + 
			",stu_fa_gua_occup = '" + stuFaGuaOccup + '\'' + 
			",stu_transferred_sch = '" + stuTransferredSch + '\'' + 
			",stu_mother_phone1 = '" + stuMotherPhone1 + '\'' + 
			",stu_gender = '" + stuGender + '\'' + 
			",stu_mother_phone2 = '" + stuMotherPhone2 + '\'' + 
			",stu_mo_qual_photo = '" + stuMoQualPhoto + '\'' + 
			",stu_sec_lang = '" + stuSecLang + '\'' + 
			",stu_mo_id_photo = '" + stuMoIdPhoto + '\'' + 
			",stu_fa_id_photo = '" + stuFaIdPhoto + '\'' + 
			"}";
		}
}