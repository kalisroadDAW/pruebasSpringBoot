package com.example.demo.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.location.Location;

@Service
public class UserService {
	
	
	   
			User user1 = new User(
				"u1", 
				"Jany", 
				"Lawrence",
				new Location("l1", "Lagos"),
				"Jany@gmail.com");
				
			User user2 = new User(
				"u2", 
				"Jadon", 
				"Mills",
				new Location("l2", "Asaba"),
				"Jadon@gmail.com");
				
			List<User> users= new ArrayList<>(Arrays.asList(user1, user2));	
			
			
			
			
			public List<User> getAllUsers() {
				return users;
			}
			
			public User getUser(String id) {
				User user=users.stream()
						.filter(t-> id.equals(t.getId()))
						.findFirst()
						.orElse(null);
				return user;
				
			}
			
			public void addUser(User user) {
				users.add(user);
			}
			
			public void updateuser(String id, User user) {
				for (int i = 0; i < users.size(); i++) { //recorremos el array de usuarios

					User u = users.get(i); //definimos una variable de tipo User que se irá reasignando conforme a las iteraciones

					if (u.getId().equals(id)) { //si el id al que se accede en la iteración es igual al id indicado
						users.set(i, user);
						
						return;//el usuario coincidente en dicha iteración queda sustituido por otro objeto usuario
					}
				}
			}
			
			public void deleteUser(String id) {
				for (int i = 0; i < users.size(); i++) { 

					User u = users.get(i); 

					if (u.getId().equals(id)) { 
						users.remove(i);
						
						return;
					}
				}
			}
		}


