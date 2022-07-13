package pojo;

import java.util.Hashtable;

import utilities.GlobalUtil;

public class Setterclass {

	GetExcelData dataset;
	public void settingdata(Hashtable<String, String> data)
	{
		
		 dataset=new GetExcelData();
		dataset.setURL(data.get("URL"));
		dataset.setUserName(data.get("UserName"));
		dataset.setPassword(data.get("Password"));
		dataset.setInvalidEmail(data.get("InvalidEmail"));
		dataset.setSecurityquetion(data.get("SecurityAnswer"));
		dataset.setCountry(data.get("Country"));
		dataset.setJobTitle(data.get("JobTitle"));
		dataset.setCPSURL(data.get("CPSURL"));
		dataset.setFullName(data.get("FullName"));
		dataset.setWSOURL(data.get("WSOURL"));
		dataset.setSuperAdminPassword(data.get("SuperAdminPassword"));
		dataset.setJobTitle(data.get("JobTitle"));
		dataset.setConfirmPassword(data.get("ConfirmPassword"));
		dataset.setPhoneNumber(data.get("PhoneNumber"));
		dataset.setEmailAddress(data.get("EmailAddress"));
		dataset.setChangePasswordURL(data.get("ChangePasswordURL"));
		dataset.setAdminpassword(data.get("AdminPassword"));
		dataset.setInvalidFullName(data.get("InvalidFullName"));
		dataset.setCleardata(data.get("Cleardata"));
		dataset.setPolicyName(data.get("PolicyName"));
		dataset.setEndUser(data.get("EndUser"));
		dataset.setEndUserPassword(data.get("EndUserPassword"));
		dataset.setUserGroup(data.get("UserGroup"));
		dataset.setPolicyPage(data.get("PolicyPage"));
		dataset.setSecurityAnswer(data.get("SecurityAnswer"));
		dataset.setPreLoginURL(data.get("PreLoginURL"));
		dataset.setOrganizationName(data.get("OrganizationName"));
		dataset.setSuperAdminUsername(data.get("SuperAdminUsername"));
		dataset.setHostName(data.get("HostName"));
		dataset.setInvalidPhone(data.get("InvalidPhone"));
		dataset.setUserDetail(data.get("UserDetail"));
		dataset.setSecurityQuetion(data.get("SecurityQuetion"));
		dataset.setEmailoption(data.get("Emailoption"));
		dataset.setPhoneoption(data.get("Phoneoption"));
		dataset.setCombinationName(data.get("CombinationName"));
		dataset.setTenantURL(data.get("TenantURL"));
		dataset.setMFAConfiguration(data.get("MFAConfiguration"));
		dataset.setCustomQuestion(data.get("CustomQuestion"));
		dataset.setNotifications(data.get("Notifications"));
		dataset.setSearch(data.get("Search"));
		dataset.setLessSecurePassword(data.get("LessSecurePassword"));
		dataset.setMobilePushoption(data.get("MobilePushoption"));
		dataset.setAddUserURL(data.get("addUserURL"));
		dataset.setConnectionUrl(data.get("connectionUrl"));
		dataset.setConnectionName(data.get("connectionName"));
		dataset.setUserNameAD(data.get("userNameAD"));
		dataset.setPasswordAD(data.get("passwordAD"));
		dataset.setBaseDn(data.get("baseDn"));
		dataset.setUserEntryObjectClass(data.get("userEntryObjectClass"));
		dataset.setUserSearchFilter(data.get("userSearchFilter"));
		dataset.setUserListFilter(data.get("userListFilter"));
		dataset.setPasswordAttribute(data.get("passwordAttribute"));
		dataset.setEmailAttribute(data.get("emailAttribute"));
		
		
		
		
		
		
		
		
		
		
		GlobalUtil.domainname=GetExcelData.getUserName().split("@")[1];
	}
	
}
