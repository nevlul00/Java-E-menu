/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek.client;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Langi
 */
public class MealServiceImplementation implements MealService {
    
    DatabaseHelper dt;
    
    int chosenTable = 0;
    
    int numberOfOrderedMeals = 0;
    
    private ArrayList<Meal> chosenMeals = null;
    
    private ObservableList<Meal> currentMeals = null;
    
    private ObservableList<String> sideDishes = null;
    
    /**
     * Konstruktor. Vytvoří novou instanci Databazovniku.
     */
    public MealServiceImplementation()
    {
        dt = new DatabaseHelper();
        chosenMeals = new ArrayList<Meal>();
    }


    @Override
    public ObservableList<String> getSideDishes() {
        ArrayList<Meal> databaseList = dt.nactiDataZDatabaze(5);
        
        ArrayList<String> infoSideDishes = new ArrayList<>();
        for(Meal j: databaseList)
        {
            String name = j.getName();
            String price = String.valueOf(j.getPrice());
            infoSideDishes.add(name + " (" + price + " Kč)");
        }
        sideDishes = FXCollections.observableArrayList (infoSideDishes);
        
        return sideDishes;
    }
    
    
    /**
     * Požádá DatabaseHelper o hodnoty z databáze k danému typu jídla a vrátí je jako ObservableList
     * @param type Typ jídla
     */
    @Override
    public ObservableList<Meal> getCurrentMeal(int type) {
        ArrayList<Meal> databaseList = dt.nactiDataZDatabaze(type);
        currentMeals = FXCollections.observableArrayList (databaseList);
        
        return currentMeals;
    }

    @Override
    public void addToOrder(Meal meal) {
        chosenMeals.add(meal);
    }

    @Override
    public void order() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChosenTable(int number) {
        chosenTable = number;
    }

    @Override
    public int getChosenTable() {
        return chosenTable;
    }

    @Override
    public ArrayList<Meal> getChosenMeals() {
        return chosenMeals;
    }


    @Override
    public int getNumberOfOrderedMeals() {
        return chosenMeals.size();
    }

    @Override
    public void deleteFromOrder(Meal meal) {
        chosenMeals.remove(meal);
    }

    @Override
    public int getPriceOfChosenMeals() {
        int sum = 0;
        for(Meal j: chosenMeals)
        {
            sum += j.getPrice();
        }
        
        return sum;
    }
    
}
