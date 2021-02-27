/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.view;

import br.uefs.ecomp.RoadTrips.exceptions.UsuarioDuplicadoException;
import br.uefs.ecomp.RoadTrips.facade.RoadTripsFacade;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natalia Rosa & Adriel
 */
public class RoadTrips {
    public static void main (String [] args) throws UsuarioDuplicadoException, NoSuchAlgorithmException, UnsupportedEncodingException{
        RoadTripsFacade facade = new RoadTripsFacade();
        facade.inserirUsuario("JamylleS", "JamylleS", "123");
        RoadTripsInterface roadTrips = new RoadTripsInterface(facade);
        
    }
}
