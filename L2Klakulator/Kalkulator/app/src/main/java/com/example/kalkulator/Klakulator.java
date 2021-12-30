package com.example.kalkulator;

class Kalkulator
{

    public Kalkulator()
    {
        activeState = State.putArgument;
        argument1 = 0;
        operator = Operator.add;
    }
    //interface
    public float getResult()
    {
        activeState = State.putOperator;
        return argument1;
    }

    public boolean putArgument(float argument)
    {
        if (activeState == State.putArgument)
        {
            argument2 = argument;
            calculate();
            activeState = State.putOperator;
            return true;
        }
        else {
           return false; 
        }
    }

    public boolean putOperator(Operator operator)
    {
        if (activeState == State.putOperator)
        {
            this.operator = operator;
            if(operator==Operator.strong)
            {
                calculate();
                activeState =State.putOperator;
            }
            else
            {
                activeState = State.putArgument;
            }
            return true;
        }
        else {
           return false; 
        }
    }

    public void reset()
    {
        activeState = State.putArgument;
        argument1 = 0;
        operator = Operator.add;
    }

    public enum Operator {
        add, substract, multiply, divide, power, strong
    }
    
    //state
    private enum State {
        putArgument, putOperator
    }
    
    private float argument1, argument2;
    private Operator operator;
    private State activeState;

    /**
     * modifie argument1
     * reading argument1, argument2
     */
    private void calculate()
    {
        if(operator ==Operator.add)
        {
            argument1 = argument1 + argument2;
        }
        else if(operator ==Operator.substract)
        {
            argument1 = argument1 - argument2;
        }
        else if (operator == Operator.multiply) 
        {
            argument1 = argument1 * argument2;
        }
        else if (operator == Operator.divide) 
        {
            if(argument2==0)
            {
                argument2=1;
            }
            argument1 = argument1 / argument2;
        }
        else if (operator == Operator.power)
        {
            argument1 = (float) Math.pow(argument1,argument2);
        }
        else if (operator == Operator.strong)
        {
            argument1 = strong((int)argument1);
        }

    }

    private int strong(int argument)
    {
       int wynik=1;

       for(int i= argument; i>1; i--)
       {
           wynik*=i;
       }
       return wynik;
    }

}