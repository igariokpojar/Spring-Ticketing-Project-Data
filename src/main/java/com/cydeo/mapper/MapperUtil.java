package com.cydeo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MapperUtil {

    private final ModelMapper modelMapper;

    public MapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    // this method is going to convert DTO to Entity and opposite
    public <T> T convert(Object objectsToBeConverted, T convertedObject){
        return modelMapper.map(objectsToBeConverted,(Type)convertedObject.getClass());
}
    // this is the same method as one above but different implementation
    // this method is going to convert DTO to Entity and opposite

//    public <T> T convert(Object objectsToBeConverted, Class<T> convertedObject) {
//        return modelMapper.map(objectsToBeConverted,  convertedObject);
//    }
}
