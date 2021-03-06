/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.persistence.crud;

import br.com.tpartner.persistence.model.EducationalResource;
import br.com.tpartner.persistence.model.ResourceInteraction;
import java.util.List;

/**
 *
 * @author sergio
 */
public interface ResourceInteractionCRUD
        extends GenericCRUD<ResourceInteraction, Integer> {
    
    public List<ResourceInteraction> findByEducationalResource(
            EducationalResource educationalResource);
    
}
