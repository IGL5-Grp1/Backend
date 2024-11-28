package com.project.gestion_examens.mapper;

import com.project.gestion_examens.dto.SectionDTO;
import com.project.gestion_examens.entities.Section;
import org.springframework.beans.BeanUtils;

public class SectionMapper {

    public static SectionDTO toDTO(Section section) {
        if (section == null) {
            return null;
        }

        SectionDTO sectionDTO = new SectionDTO();
        BeanUtils.copyProperties(section, sectionDTO);
        return sectionDTO;
    }

    public static Section toEntity(SectionDTO sectionDTO) {
        if (sectionDTO == null) {
            return null;
        }

        Section section = new Section();
        BeanUtils.copyProperties(sectionDTO, section);
        return section;
    }
}