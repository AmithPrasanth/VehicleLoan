package com.vlc.dao;

public class test {

	public static void main(String[] args) {
		Credentials cred=new Credentials();
		cred.setCustomerId(1);
		cred.setUsername("VANIL");
		cred.setPassword("pass");
		CredentialsDao credDao = new CredentialsDaoImpl();
		credDao.createCredentials(cred);
	}

}
