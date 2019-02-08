package de.switchdevelop.documentadmin.io.db.dao;

import java.util.Calendar;

public class DocumentDao {
	private int id;
	private Calendar created;
	private Calendar modified;
	private int documentTypeId;
	private String content;

	public DocumentDao(Calendar created, Calendar modified, int documentTypeId, String content) {
		this.created = created;
		this.modified = modified;
		this.documentTypeId = documentTypeId;
		this.content = content;
	}
	//TODO: Implement functionality for getting datatable informations
}