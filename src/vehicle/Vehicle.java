/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */


class Normal{
    private String model;
    private String enginePower;
    private String tireSize;
    private String engineType;

    public Normal(String model, String engineType, String enginePower, String tireSize) {
        this.model = model;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.engineType = engineType;
    }

    public String getModel() {
        return model;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public String getTireSize() {
        return tireSize;
    }

    public String getEngineType() {
        return engineType;
    }



}

class Sports extends Normal{
    private String turbo;
    public Sports(String model, String turbo, String engineType, String enginePower, String tireSize) {
        super(model, engineType, enginePower, tireSize);
        this.turbo = turbo;
    }


    public String getTurbo() {
        return turbo;
    }


}

class Heavy extends Normal{
    private String weight;

    public Heavy(String model, String weight, String engineType, String enginePower, String tireSize) {
        super(model, engineType, enginePower,tireSize);
        this.weight = weight;
    }


    public String getWeight() {
        return weight;
    }


}

public class Vehicle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//System.out.println(args.length);
        Scanner sc = new Scanner(System.in);
        List<Normal> Vehicles = new ArrayList<Normal>();
        int visitor = 0;
        while(sc.hasNext())
        {
            String choice = sc.next();
            if(choice.equalsIgnoreCase("add"))
            {
                sc.nextLine();
                String input = sc.nextLine();
                String[] vehicle = input.split(" ");
// For Normal Model
//Model number,Engine Type,Engine Power,Tire Size
                if(vehicle.length==4)
                {
                    System.out.println("Normal");
                    Vehicles.add(new Normal(vehicle[0], vehicle[1], vehicle[2], vehicle[3]));
                }
                else
                {
// For Sports Model
//Model number,Model Name(Turbo),Engine Type,Engine Power,Tire Size

                    if(vehicle[1].equalsIgnoreCase("turbo"))
                    {
                        System.out.println("Sports");
                        visitor+=20;
                        boolean add = Vehicles.add(new Sports(vehicle[0], vehicle[1], vehicle[2], vehicle[3], vehicle[4]));
                    }

// For Heavy Model
//Model number,Weight,Engine Type,Engine Power,Tire Size
                    else
                    {
                        boolean add = Vehicles.add(new Heavy(vehicle[0], vehicle[1], vehicle[2], vehicle[3], vehicle[4]));
                    }


                }
            }
            else if(choice.equalsIgnoreCase("remove"))
            {
                if(Vehicles.size()>0)
                {
                    visitor-=20;
                    Vehicles.remove(Vehicles.size()-1);
                }
                else
                {
                    System.out.println("Empty Vehicle");
                }
            }
            else if(choice.equalsIgnoreCase("vehicles_with_details"))
            {
                for(Normal obj:Vehicles)
                {

                    if(obj instanceof Sports)
                    {
                        System.out.println("Model Number = "+obj.getModel()+" Modwl Name = "+((Sports) obj).getTurbo()+" Engine Type = "+obj.getEngineType()+" Engine Power = "+obj.getEnginePower()+" Tire Size = "+obj.getTireSize());
                    }
                    else if(obj instanceof Heavy)
                    {
                        System.out.println("Model Number = "+obj.getModel()+" Weight = "+((Heavy) obj).getWeight()+" Engine Type = "+obj.getEngineType()+" Engine Power = "+obj.getEnginePower()+" Tire Size = "+obj.getTireSize());
                    }
                    else if(obj instanceof Normal)
                    {
                        System.out.println("Model Number = "+obj.getModel()+" Engine Type = "+obj.getEngineType()+" Engine Power = "+obj.getEnginePower()+" Tire Size = "+obj.getTireSize());
                    }
                }
            }



            else if(choice.equalsIgnoreCase("vehicles_with_details"))
            {
                for(Normal obj:Vehicles)
                {

                    if(obj instanceof Sports)
                    {
                        System.out.println("Model Number = "+obj.getModel()+" Modwl Name = "+((Sports) obj).getTurbo()+" Engine Type = "+obj.getEngineType()+" Engine Power = "+obj.getEnginePower()+" Tire Size = "+obj.getTireSize()+" Current expected Visitor = "+visitor);
                    }
                    else if(obj instanceof Heavy)
                    {
                        System.out.println("Model Number = "+obj.getModel()+" Weight = "+((Heavy) obj).getWeight()+" Engine Type = "+obj.getEngineType()+" Engine Power = "+obj.getEnginePower()+" Tire Size = "+obj.getTireSize()+" Current expected Visitor = "+visitor);
                    }
                    else if(obj instanceof Normal)
                    {
                        System.out.println("Model Number = "+obj.getModel()+" Engine Type = "+obj.getEngineType()+" Engine Power = "+obj.getEnginePower()+" Tire Size = "+obj.getTireSize()+" Current expected Visitor = "+visitor);
                    }
                }
            }


        }

    }

}

