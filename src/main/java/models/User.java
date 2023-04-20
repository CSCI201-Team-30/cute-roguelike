package models;

import java.util.List;

public class User {
	private int id;
	private String username;
	private List<Integer> reviews; // list of ids of all reviews the user has made.
}
