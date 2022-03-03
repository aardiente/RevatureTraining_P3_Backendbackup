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
		gen.writeNumberField("", 0);
		
	}

}
