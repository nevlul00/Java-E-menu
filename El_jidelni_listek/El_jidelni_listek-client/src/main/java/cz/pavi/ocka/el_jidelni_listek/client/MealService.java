/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek.client;

import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Langi
 */
public interface MealService 
{
    ObservableList<String> getSideDishes();
    
    ObservableList<Meal> getCurrentMeal(int type);
    
    ArrayList<Meal> getChosenMeals();
    
    void addToOrder(Meal meal);
    
    void deleteFromOrder(Meal meal);
    
    void order();
    
    void setChosenTable(int number); 
    
    int getChosenTable();

    int getNumberOfOrderedMeals();
    
    int getPriceOfChosenMeals();
}
