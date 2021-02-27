/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.RoadTrips.view;

import br.uefs.ecomp.RoadTrips.facade.RoadTripsFacade;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Natalia Rosa & Adriel Brito
 */
public class RoadTripsInterface {
    private JFrame frame= new JFrame ("Road Trips");
    private Container container;
    private RoadTripsFacade facade;
    
    public RoadTripsInterface (RoadTripsFacade facade){
        this.facade = facade;
        
        frame = new RoadTrips_LOGIN_principal(facade);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
