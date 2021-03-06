/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.services.facade;

import br.com.tpartner.persistence.model.AccessSession;
import br.com.tpartner.persistence.model.SubSession;
import java.util.List;

/**
 *
 * @author sergio
 */
public interface SubSessionFacade extends GenericFacade<SubSession, Integer> {
    
    public List<SubSession> findByAccessSession(AccessSession accessSession);
    
}