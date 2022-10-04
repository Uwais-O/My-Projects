## Capstone project I

import math

## Printed required statements/ phrases as well as a line space between line 5 and line 7 as per instructions
print("Choose either 'investment' or 'bond' from the menu below to proceed: ")
print(" ")
print("investment - to calculate the amount of interest you'll earn on interest ")
print("bond - to calculate the amount you'll pay on a home loan")


## Stored user input as variable called type_1
## Stored variable in lower case as variable called type_2 thereby removing case sensitivity
type_1 = input("")
type_2 = type_1.lower()

## Used an if and conditional statement to recognize undesired input and print a notification alerting user of it
if not(type_2 == "investment") and not(type_2 == "bond"):
    print("You have entered an invalid input. Please try again. ")

## Used an if statement to set conditons if user entered "investment"
## Asked user for amount, interest rate and number of years
# Stored input as variables called Principle, interest_rate and year
if type_2 == "investment":
    Principle = float(input("Please enter the amount in Rands you wish to deposit: "))  
    interest_rate = int(input("Please enter your desired interest rate as a number: ")) 
    years = int(input("Please enter the number of years you wish to invest for: ")) 
    
    ## Asked user to input user type and stored variable called interest_options
    ## Stored this variable as a new variable called interest 
    ## Set interest variable as lower case to remove case sensitivity
    interest_options = input("Choose your interest type. Enter either 'simple' or 'compound': ")
    interest = interest_options.lower()
    r = float(interest_rate/100) 
    # Let variable called r be interest rate divided by 100, to be used in future calculation
    

    ## Used an if and elif statement to output interest
    if interest == "simple":
        A = Principle*(1+r*years) # Used formula , but implemented my variables
         
         # Used round function to obtain 2 decimal places in printed amount
        print("Your total amount(including interest) is" + " " + "R"+str(round(A, 2)))
    
    elif interest == "compound":
        A = Principle* math.pow((1+r),years)
        print("Your total amount(including interest) is" + " " + "R"+str(round(A, 2)))

## Used an elif to set conditions if type_2 variable is equal to 'bond'
## Asked user for present value, interest and number of months 
elif type_2 == "bond":

    # Stored user input as  variable called present value, interest_rate1 and months
    present_value = float(input("Please enter the present value of the house in Rands: "))  
    interest_rate1 = int(input("Please enter your desired interest rate as a number: "))
    months = int(input("Please enter the number of months in which you wish to repay the bond: ")) 
    r = interest_rate1/100
   # Let variable called r be interest rate divided by 100, to be used in future calculation

    # Set variable X to equal calculation of bond repayment formula(given)
    # Used variables previously obtained from user
    # Printed out X and rounded to 2 decimal places
    X = (interest_rate1*present_value)/(1-(1+r)**-months)
    print("Your monthly repayment will be" + " " + "R"+str(round(X,2)))

    

