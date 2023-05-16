package com.company.prop.Management.Service.IMPL;

import com.company.prop.Management.Converter.PropertyConverter;
import com.company.prop.Management.DTO.PropertyDTO;
import com.company.prop.Management.Entity.PropertyEntity;
import com.company.prop.Management.Entity.UserEntity;
import com.company.prop.Management.Repository.PropertyRepository;
import com.company.prop.Management.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PropertyServiceIMPL implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

            PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);

            pe = propertyRepository.save(pe);

            propertyDTO = propertyConverter.convertEntityToDTO(pe);

            return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();

        for(PropertyEntity pe : listOfProps){
            PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
            propList.add(dto);
        }
        return propList;
    }

//    @Override
//    public List<PropertyDTO> getAllPropertiesForUser(Long userId) {
//        List<PropertyEntity> listOfProps = (List<PropertyEntity>)propertyRepository.findAll();
//        List<PropertyDTO> propList = new ArrayList<>();
//
//        for(PropertyEntity pe : listOfProps){
//            PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
//            propList.add(dto);
//        }
//        return propList;
//    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){

            PropertyEntity pe = optEn.get();//data from database
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()) {

            PropertyEntity pe = optEn.get();//data from database
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;

    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();//data from database
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
