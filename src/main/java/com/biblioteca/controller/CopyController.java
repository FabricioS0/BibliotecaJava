package com.biblioteca.controller;

import com.biblioteca.dao.CopyDAO;
import com.biblioteca.dto.CopyDTO;
import com.biblioteca.model.Copy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CopyController {
    private CopyDAO copyDAO;

    public CopyController() {
        this.copyDAO = new CopyDAO();
    }

    public void addCopy(CopyDTO copyDTO) throws SQLException {
        Copy copy = new Copy();
        copy.setStatus(copyDTO.getStatus());
        copy.setIdentifier(copyDTO.getIdentifier());
        copy.setBookId(copyDTO.getBookId());
        copyDAO.addCopy(copy);
    }

    public List<CopyDTO> getAllCopies() throws SQLException {
        List<Copy> copies = copyDAO.getAllCopies();
        List<CopyDTO> copyDTOs = new ArrayList<>();
        for (Copy copy : copies) {
            CopyDTO dto = new CopyDTO();
            dto.setId(copy.getId());
            dto.setStatus(copy.getStatus());
            dto.setIdentifier(copy.getIdentifier());
            dto.setBookId(copy.getBookId());
            copyDTOs.add(dto);
        }
        return copyDTOs;
    }

    public CopyDTO getCopyById(int id) throws SQLException {
        Copy copy = copyDAO.getCopyById(id);
        if (copy != null) {
            CopyDTO dto = new CopyDTO();
            dto.setId(copy.getId());
            dto.setStatus(copy.getStatus());
            dto.setIdentifier(copy.getIdentifier());
            dto.setBookId(copy.getBookId());
            return dto;
        }
        return null;
    }

    public void updateCopy(CopyDTO copyDTO) throws SQLException {
        Copy copy = new Copy();
        copy.setId(copyDTO.getId());
        copy.setStatus(copyDTO.getStatus());
        copy.setIdentifier(copyDTO.getIdentifier());
        copy.setBookId(copyDTO.getBookId());
        copyDAO.updateCopy(copy);
    }

    public void deleteCopy(int id) throws SQLException {
        copyDAO.deleteCopy(id);
    }
}