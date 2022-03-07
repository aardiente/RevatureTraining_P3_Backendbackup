package com.revature.revspace.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.revature.revspace.models.User;

public class UserSerializer extends StdSerializer<User> {
    
    public UserSerializer() {
        this(null);
    }
  
    public UserSerializer(Class<User> t) {
        super(t);
    }


	@Override
	public void serialize(User value, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		
		gen.writeStartObject();
		gen.writeNumberField("userId", value.getUserId());
		gen.writeStringField("email", value.getEmail());
		gen.writeStringField("firstName", value.getFirstName());
		gen.writeStringField("lasstName", value.getLastName());
		if(value.getBirthday() != null)
		gen.writeNumberField("birthday", value.getBirthday());
		if(value.getRevatureJoinDate() != null)
		gen.writeNumberField("revatureJoinDate", value.getRevatureJoinDate());
		gen.writeStringField("githubUsername", value.getGithubUsername());
		gen.writeStringField("title", value.getTitle());
		gen.writeStringField("location", value.getLocation());
		gen.writeStringField("aboutMe", value.getAboutMe());
		gen.writeArrayFieldStart("followers");
		if(value.getFollowers() != null) {
			for(User field : value.getFollowers()) {
				gen.writeStartObject();
				gen.writeNumberField("userId", field.getUserId());
				gen.writeStringField("firstName", field.getFirstName());
				gen.writeStringField("lastName", field.getLastName());
				gen.writeEndObject();
			}
		}
		gen.writeEndArray();
		gen.writeArrayFieldStart("following");
		if(value.getFollowing() != null) {
			for(User field : value.getFollowing()) {
				gen.writeStartObject();
				gen.writeNumberField("userId", field.getUserId());
				gen.writeStringField("firstName", field.getFirstName());
				gen.writeStringField("lastName", field.getLastName());
				gen.writeEndObject();
			}
		}
		gen.writeEndArray();
		gen.writeEndObject();
	}

}
