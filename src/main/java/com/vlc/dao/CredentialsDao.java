package com.vlc.dao;

import java.util.List;

public interface CredentialsDao {
	void             createCredentials(Credentials credObj);
	Credentials 	 readCredential(String username);
	List<Credentials> readCredentials();
	void             updateCredential(Credentials credObj);
	void 			 deleteCredential(String username);
}
